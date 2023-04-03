package uno.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.modeles.ModeleProfil;

public class ModifierProfil {

	public static void creerTaches(BackendTasks tasks, String idUsager) {

		tasks.taskGroup("ModifierProfil" + "/" + idUsager)

				.waitsFor(model(ModeleProfil.class, idUsager))

				.andContains(subTasks -> {
					
					ajouterProfil(subTasks, idUsager);
				});
	}

	private static void ajouterProfil(BackendTasks subTasks, String idUsager) {
		subTasks.task("ajouterProfil" + "/" + idUsager)

				.waitsFor(message(MsgAjouterProfil.class, idUsager))

				.thenExecutes(inputs -> {

					MsgAjouterProfil msgAjouterProfil = inputs.get(message(MsgAjouterProfil.class, idUsager));
					ModeleProfil profil = inputs.get(model(ModeleProfil.class, idUsager));
					
					msgAjouterProfil.ajouterA(profil);
				});
	}
	
	// créer une méthode modifierInfosProfil comme le tutoriel ?
}
