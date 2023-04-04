package uno.frontal.taches;

import ca.ntro.core.reflection.observer.Modified;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import static ca.ntro.app.tasks.frontend.FrontendTasks.*;

import uno.commun.modeles.ModeleProfil;
import uno.frontal.vues.VueProfilDesJoueurs;

public class AfficherProfil {

	public static void creerTaches(FrontendTasks tasks, String idUsager) {

		tasks.taskGroup("AfficherProfil")

				.waitsFor("Initialisation")

				.andContains(subTasks -> {

					afficherProfil(subTasks, idUsager);

				});
	}

	private static void afficherProfil(FrontendTasks tasks, String idUsager) {

		tasks.task("afficherProfil")

				.waitsFor(modified(ModeleProfil.class, idUsager))

				.executes(inputs -> {

					VueProfilDesJoueurs vueProfil = inputs.get(created(VueProfilDesJoueurs.class));
					Modified<ModeleProfil> profil = inputs.get(modified(ModeleProfil.class, idUsager));

					ModeleProfil ancienProfil = profil.previousValue();
					ModeleProfil profilCourrant = profil.currentValue();

					profilCourrant.afficherSur(vueProfil);

				});
	}
}
