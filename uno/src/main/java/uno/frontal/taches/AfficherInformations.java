package uno.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import uno.frontal.donnees.DonneesVueInformations;
import uno.frontal.vues.VueInformationsUnJoueur;

public class AfficherInformations {

	public static void creerTaches(FrontendTasks tasks) {

		creerDonneesVueInformations(tasks);

		tasks.taskGroup("AfficherInformations")

				.waitsFor(created(DonneesVueInformations.class))

				.andContains(subTasks -> {

					prochaineImage(subTasks);

				});

	}

	private static void creerDonneesVueInformations(FrontendTasks tasks) {

		tasks.task(create(DonneesVueInformations.class))

				.waitsFor("Initialisation")

				.executesAndReturnsCreatedValue(inputs -> {

					return new DonneesVueInformations();
				});
	}

	private static void prochaineImage(FrontendTasks subTasks) {

		subTasks.task("prochaineImage")

				.waitsFor(clock().nextTick())

				.thenExecutes(inputs -> {

					Tick tick = inputs.get(clock().nextTick());

					DonneesVueInformations donneesVueInformations = inputs.get(created(DonneesVueInformations.class));
					VueInformationsUnJoueur vueInformationsUnJoueur = inputs
							.get(created(VueInformationsUnJoueur.class));
					
					donneesVueInformations.reagirTempsQuiPasse(tick.elapsedTime());
					donneesVueInformations.afficherSur(vueInformationsUnJoueur);
				});
	}

}
