package uno.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;

import uno.frontal.vues.VueProfilDesJoueurs;
import uno.frontal.vues.VueRacine;

public class Initialisation {
	
	// CRÉATION DE TACHES
	public static void creerTaches (FrontendTasks tasks) {
		
		tasks.taskGroup("Initialisation")
		
			.contains(subTasks -> {
				
				creerVueRacine(subTasks);
				
				installerVueRacine(subTasks);
				
				
				creerVueProfilDesJoueurs(subTasks);
				
				installerVueProfilDesJoueurs(subTasks);
				
				
				afficherFenetre(subTasks);
				
			});
	}
	
	public static void afficherFenetre(FrontendTasks subTasks) {
		
		subTasks.task("AfficherFenetre")
		
			.waitsFor(window())
			
			.thenExecutes(inputs -> {
				
				Window window = inputs.get(window());
				
				// changer fenêtre
				window.resize(750, 500);
				window.show();
			});
	}
	
	// TACHE DE LA VUE RACINE
	private static void creerVueRacine(FrontendTasks tasks) {

        tasks.task(create(VueRacine.class))

             .waitsFor(viewLoader(VueRacine.class))

             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));

                 VueRacine vueRacine = viewLoader.createView();

                 return vueRacine;
             });
    }

    private static void installerVueRacine(FrontendTasks tasks) {

        tasks.task("installerVueRacine")

              .waitsFor(window())

              .waitsFor(created(VueRacine.class))

              .thenExecutes(inputs -> {

                  VueRacine vueRacine = inputs.get(created(VueRacine.class));
                  Window    window    = inputs.get(window());

                  window.installRootView(vueRacine);
              });
    }
    
    // TACHE DE LA VUE PROFIL DES JOUEURS
    private static void creerVueProfilDesJoueurs(FrontendTasks tasks) {

        tasks.task(create(VueProfilDesJoueurs.class))

             .waitsFor(viewLoader(VueProfilDesJoueurs.class))

             .thenExecutesAndReturnsValue(inputs -> {

                 ViewLoader<VueProfilDesJoueurs> viewLoader = inputs.get(viewLoader(VueProfilDesJoueurs.class));

                 VueProfilDesJoueurs vueProfilDesJoueurs = viewLoader.createView();

                 return vueProfilDesJoueurs;
             });
    }

    private static void installerVueProfilDesJoueurs(FrontendTasks tasks) {

        tasks.task("installerVueProfilDesJoueurs")

              .waitsFor(created(VueRacine.class))

              .waitsFor(created(VueProfilDesJoueurs.class))

              .thenExecutes(inputs -> {

                  VueRacine      vueRacine      = inputs.get(created(VueRacine.class));
                  VueProfilDesJoueurs vueProfilDesJoueurs = inputs.get(created(VueProfilDesJoueurs.class));

                  vueRacine.afficherSousVue(vueProfilDesJoueurs);

              });
    }

}
