package uno.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import uno.frontal.evenements.EvtAfficherAcceuil;
import uno.frontal.evenements.EvtAfficherInformations;
import uno.frontal.evenements.EvtAfficherProfil;
import uno.frontal.vues.VueAcceuil;
import uno.frontal.vues.VueInformationsUnJoueur;
import uno.frontal.vues.VueProfilDesJoueurs;
import uno.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;


public class Navigation {

    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("Navigation")

             .waitsFor("Initialisation")

             .andContains(subTasks -> {

                 afficherVueProfil(subTasks);
                 afficherVueAcceuil(subTasks);
                 afficherVueInformationsDuJoueur(subTasks);
               
             });
    }

    private static void afficherVueAcceuil(FrontendTasks tasks) {

        tasks.task("afficherVueAcceuil")

             .waitsFor(created(VueAcceuil.class))

             .waitsFor(event(EvtAfficherAcceuil.class))

             .thenExecutes(inputs -> {

                 VueRacine vueRacine = inputs.get(created(VueRacine.class));
                 VueAcceuil vueAcceuil = inputs.get(created(VueAcceuil.class));

                 vueRacine.afficherSousVue(vueAcceuil);
             });
    }

    private static void afficherVueProfil(FrontendTasks tasks) {

        tasks.task("afficherVueProfil")

              .waitsFor(event(EvtAfficherProfil.class))
              
              .thenExecutes(inputs -> {

                  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
                  VueProfilDesJoueurs vueProfilDesJoueurs = inputs.get(created(VueProfilDesJoueurs.class));

                  vueRacine.afficherSousVue(vueProfilDesJoueurs);

              });
    }
    
    private static void afficherVueInformationsDuJoueur(FrontendTasks tasks) {

        tasks.task("afficherVueInformationsDuJoueur")

              .waitsFor(event(EvtAfficherInformations.class))
              
              .thenExecutes(inputs -> {

                  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
                  VueInformationsUnJoueur vueInformationsUnJoueur = inputs.get(created(VueInformationsUnJoueur.class));

                  vueRacine.afficherSousVue(vueInformationsUnJoueur);

              });
    }

}