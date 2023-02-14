package uno.frontal.taches;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import uno.frontal.evenements.EvtAfficherAcceuil;
import uno.frontal.evenements.EvtAfficherProfil;
import uno.frontal.vues.VueAcceuil;
import uno.frontal.vues.VueProfilDesJoueurs;
import uno.frontal.vues.VueRacine;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.frontend.ViewLoader;


public class Navigation {

    public static void creerTaches(FrontendTasks tasks) {

        tasks.taskGroup("Navigation")

             .waitsFor("Initialisation")

             .andContains(subTasks -> {

                 afficherVueProfil(subTasks);
                 
                 creerVueAcceuil(subTasks);
                 afficherVueAcceuil(subTasks);

             });
    }
    
    private static void creerVueAcceuil(FrontendTasks tasks) {

        tasks.task(create(VueAcceuil.class))

             .waitsFor(viewLoader(VueAcceuil.class))

             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueAcceuil> viewLoader = inputs.get(viewLoader(VueAcceuil.class));

                 VueAcceuil vueAcceuil = viewLoader.createView();

                 return vueAcceuil;
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
}