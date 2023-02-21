package uno.dorsal;

import ca.ntro.app.backend.LocalBackendNtro;
import ca.ntro.app.tasks.backend.BackendTasks;
import uno.dorsal.taches.ModifierProfil;

public class DorsalUno extends  LocalBackendNtro {

	@Override
	public void createTasks(BackendTasks tasks) {
		ModifierProfil.creerTaches(tasks);
	}

	@Override
	public void execute() {
		
	}

}
