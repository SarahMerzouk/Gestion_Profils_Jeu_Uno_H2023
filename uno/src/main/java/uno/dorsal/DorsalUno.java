package uno.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import uno.dorsal.taches.ModifierProfil;
import uno.maquettes.MaquetteUsagers;

public class DorsalUno extends LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {

		for (String idUsager : MaquetteUsagers.usagerEnCours()) {
			ModifierProfil.creerTaches(tasks, idUsager);
		}

	}

	public void execute() {

	}

}
