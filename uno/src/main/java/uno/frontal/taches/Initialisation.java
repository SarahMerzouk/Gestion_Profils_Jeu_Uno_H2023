package uno.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.create;
import static ca.ntro.app.tasks.frontend.FrontendTasks.created;
import static ca.ntro.app.tasks.frontend.FrontendTasks.viewLoader;
import static ca.ntro.app.tasks.frontend.FrontendTasks.window;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.services.Window;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import uno.frontal.fragments.FragmentProfil;
import uno.frontal.vues.VueAcceuil;
import uno.frontal.vues.VueInformationsUnJoueur;
import uno.frontal.vues.VueProfilDesJoueurs;
import uno.frontal.vues.VueRacine;

public class Initialisation {

	// CR�ATION DE TACHES
	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("Initialisation")

				.contains(subTasks -> {

					creerVueRacine(subTasks);
					installerVueRacine(subTasks);

					creerVueAcceuil(subTasks);

					creerVueProfilDesJoueurs(subTasks);
					installerVueProfilDesJoueurs(subTasks);

					creerVueInformationsDuJoueur(subTasks);
					installerVueInfosJoueur(subTasks);

					afficherFenetre(subTasks);

				});
	}

	public static void afficherFenetre(FrontendTasks subTasks) {

		subTasks.task("AfficherFenetre")

				.waitsFor(window())

				.thenExecutes(inputs -> {

					Window window = inputs.get(window());

					window.resize(1200, 500);
					window.show();
				});
	}

	private static void creerVueRacine(FrontendTasks tasks) {

		tasks.task(create(VueRacine.class))

				.waitsFor(viewLoader(VueRacine.class))

				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueRacine> viewLoader = inputs.get(viewLoader(VueRacine.class));

					VueRacine vueRacine = viewLoader.createView();

					return vueRacine;
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

	private static void creerVueProfilDesJoueurs(FrontendTasks tasks) {

		tasks.task(create(VueProfilDesJoueurs.class))

				.waitsFor(viewLoader(VueProfilDesJoueurs.class))

				.waitsFor(viewLoader(FragmentProfil.class))

				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueProfilDesJoueurs> viewLoaderProfilDesJoueurs = inputs
							.get(viewLoader(VueProfilDesJoueurs.class));

					ViewLoader<FragmentProfil> viewLoaderProfil = inputs.get(viewLoader(FragmentProfil.class));

					VueProfilDesJoueurs vueProfilDesJoueurs = viewLoaderProfilDesJoueurs.createView();

					vueProfilDesJoueurs.setViewLoaderProfil(viewLoaderProfil);

					return vueProfilDesJoueurs;
				});
	}

	private static void creerVueInformationsDuJoueur(FrontendTasks tasks) {

		tasks.task(create(VueInformationsUnJoueur.class))

				.waitsFor(viewLoader(VueInformationsUnJoueur.class))

				.thenExecutesAndReturnsValue(inputs -> {

					ViewLoader<VueInformationsUnJoueur> viewLoader = inputs
							.get(viewLoader(VueInformationsUnJoueur.class));

					VueInformationsUnJoueur vueInformationsUnJoueur = viewLoader.createView();

					return vueInformationsUnJoueur;
				});
	}

	private static void installerVueRacine(FrontendTasks tasks) {

		tasks.task("installerVueRacine")

				.waitsFor(window())

				.waitsFor(created(VueRacine.class))

				.thenExecutes(inputs -> {

					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					Window window = inputs.get(window());

					window.installRootView(vueRacine);
				});
	}

	private static void installerVueProfilDesJoueurs(FrontendTasks tasks) {

		tasks.task("installerVueProfilDesJoueurs")

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueProfilDesJoueurs.class))

				.thenExecutes(inputs -> {

					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					VueProfilDesJoueurs vueProfilDesJoueurs = inputs.get(created(VueProfilDesJoueurs.class));

					vueRacine.afficherSousVue(vueProfilDesJoueurs);

				});
	}

	private static void installerVueInfosJoueur(FrontendTasks tasks) {

		tasks.task("installerVueInfosJoueur")

				.waitsFor(created(VueRacine.class))

				.waitsFor(created(VueInformationsUnJoueur.class))

				.thenExecutes(inputs -> {

					VueInformationsUnJoueur vueInformationsUnJoueur = inputs
							.get(created(VueInformationsUnJoueur.class));
					VueRacine vueRacine = inputs.get(created(VueRacine.class));
					;

					vueRacine.afficherSousVue(vueInformationsUnJoueur);
				});
	}
}
