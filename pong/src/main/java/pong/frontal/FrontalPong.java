package pong.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import pong.frontal.taches.AfficherFileAttente;
import pong.frontal.taches.Initialisation;
import pong.frontal.vues.VueFileAttente;
import pong.frontal.vues.VueRacine;

public class FrontalPong implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		
		Initialisation.creerTaches(tasks);
		
		AfficherFileAttente.creerTaches(tasks);
		
	}

	@Override
	public void execute() {
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
		// Le XML
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueFileAttente.class, "/file_attente.xml");
		
		// Le CSS
		// registrar.registerStylesheet("/dev.css");
		 registrar.registerStylesheet("/prod.css");
		 
		 // La LANGUE
		 registrar.registerDefaultResources("/chaine_fr.properties");
		 registrar.registerResources(NtroApp.locale("en"), "/chaine_en.properties");

	}

}
