package uno.frontal.taches;

import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import ca.ntro.app.tasks.frontend.FrontendTasks;
import ca.ntro.core.clock.Tick;
import ca.ntro.core.reflection.observer.Modified;
import uno.commun.modeles.ModeleProfil;
import uno.frontal.donnees.DonneesVueInformations;
import uno.frontal.evenements.EvtAfficherInformations;
import uno.frontal.vues.VueInformationsUnJoueur;
import uno.frontal.vues.VueProfilDesJoueurs;
import uno.maquettes.MaquetteProfils;
import uno.maquettes.MaquetteSession;

public class AfficherInformations {

	public static void creerTaches(FrontendTasks tasks) {

		creerDonneesVueInformations(tasks);
		
		tasks.taskGroup("AfficherInformations")

				.waitsFor(created(DonneesVueInformations.class))

				.andContains(subTasks -> {

					prochaineImage(subTasks);
					observerInformations(subTasks);

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
	
	private static void observerInformations(FrontendTasks tasks) {

		tasks.task("observerInformations")

				.waitsFor(modified(ModeleProfil.class))

				.executes(inputs -> {

					VueInformationsUnJoueur vueInformationsUnJoueur = inputs.get(created(VueInformationsUnJoueur.class));
					Modified<ModeleProfil> profil = inputs.get(modified(ModeleProfil.class));

					
					ModeleProfil ancienProfil = profil.previousValue();
					ModeleProfil profilCourrant = profil.currentValue();

					profilCourrant.afficherSurInformations(vueInformationsUnJoueur, MaquetteProfils.idProfilCourant);

				});
	}

}
