package uno.frontal.taches;

import ca.ntro.core.reflection.observer.Modified;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import uno.commun.modeles.ModeleProfil;
import uno.frontal.vues.VueProfilDesJoueurs;

public class AfficherProfil {

	public static void creerTaches(FrontendTasks tasks) {

		tasks.taskGroup("AfficherProfil")

				.waitsFor("Initialisation")

				.andContains(subTasks -> {

					afficherProfil(subTasks);

				});
	}

	private static void afficherProfil(FrontendTasks tasks) {

		tasks.task("afficherProfil")

				.waitsFor(modified(ModeleProfil.class))

				.executes(inputs -> {

					VueProfilDesJoueurs vueProfil = inputs.get(created(VueProfilDesJoueurs.class));
					Modified<ModeleProfil> profil = inputs.get(modified(ModeleProfil.class));

					ModeleProfil ancienProfil = profil.previousValue();
					ModeleProfil profilCourrant = profil.currentValue();

					profilCourrant.afficherSur(vueProfil);

				});
	}
}
