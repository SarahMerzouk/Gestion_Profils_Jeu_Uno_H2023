package uno.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.tasks.backend.BackendTasks;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.modeles.ModeleProfil;

public class ModifierProfil {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierProfil")

				.waitsFor(model(ModeleProfil.class))

				.andContains(subTasks -> {
					
					ajouterProfil(subTasks);
				});
	}

	private static void ajouterProfil(BackendTasks subTasks) {
		subTasks.task("ajouterProfil")

				.waitsFor(message(MsgAjouterProfil.class))

				.thenExecutes(inputs -> {

					MsgAjouterProfil msgAjouterProfil = inputs.get(message(MsgAjouterProfil.class));
					ModeleProfil profil = inputs.get(model(ModeleProfil.class));
					
					msgAjouterProfil.ajouterA(profil);
				});
	}
}
