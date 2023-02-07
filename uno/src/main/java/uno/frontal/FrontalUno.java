package uno.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;

import uno.frontal.taches.Initialisation;
import uno.frontal.vues.VueAcceuil;
import uno.frontal.vues.VueProfilDesJoueurs;
import uno.frontal.vues.VueRacine;

public class FrontalUno implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		Initialisation.creerTaches(tasks);
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
		registrar.registerView(VueProfilDesJoueurs.class, "/profilJoueurs.xml");
		registrar.registerView(VueAcceuil.class, "/acceuil.xml");
		
		// Le CSS
		 registrar.registerStylesheet("/profilJoueurs.css");
		 
		 // La LANGUE
		 registrar.registerDefaultResources("/chaine_fr.properties");
		 registrar.registerResources(NtroApp.locale("en"), "/chaine_en.properties");
	}

}
