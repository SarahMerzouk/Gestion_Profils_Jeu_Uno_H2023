package uno.frontal;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.FrontendFx;
import ca.ntro.app.frontend.ViewRegistrarFx;
import ca.ntro.app.frontend.events.EventRegistrar;
import ca.ntro.app.tasks.frontend.FrontendTasks;
import uno.frontal.donnees.DonneesVueInformations;
import uno.frontal.evenements.EvtAfficherAcceuil;
import uno.frontal.evenements.EvtAfficherInformations;
import uno.frontal.evenements.EvtAfficherProfil;
import uno.frontal.fragments.FragmentProfil;
import uno.frontal.taches.AfficherInformations;
import uno.frontal.taches.AfficherProfil;
import uno.frontal.taches.Initialisation;
import uno.frontal.taches.Navigation;
import uno.frontal.vues.VueAcceuil;
import uno.frontal.vues.VueInformationsUnJoueur;
import uno.frontal.vues.VueProfilDesJoueurs;
import uno.frontal.vues.VueRacine;

public class FrontalUno implements FrontendFx{

	@Override
	public void createTasks(FrontendTasks tasks) {
		
		Initialisation.creerTaches(tasks);
		
		AfficherProfil.creerTaches(tasks);
		
		Navigation.creerTaches(tasks);
		
		AfficherInformations.creerTaches(tasks);
		
	}

	@Override
	public void execute() {
		
	}

	@Override
	public void registerEvents(EventRegistrar registrar) {
		
		registrar.registerEvent(EvtAfficherAcceuil.class);
		
		registrar.registerEvent(EvtAfficherProfil.class);
		
		registrar.registerEvent(EvtAfficherInformations.class);
	}

	@Override
	public void registerViews(ViewRegistrarFx registrar) {
		
		// Le XML
		registrar.registerView(VueRacine.class, "/racine.xml");
		registrar.registerView(VueProfilDesJoueurs.class, "/profilJoueurs.xml");
		registrar.registerView(VueAcceuil.class, "/acceuil.xml");
		registrar.registerView(VueInformationsUnJoueur.class, "/informationsJoueurs.xml");
		
		// Le CSS
		 registrar.registerStylesheet("/style.css");
		 
		 // La LANGUE
		 registrar.registerDefaultResources("/chaine_fr.properties");
		 registrar.registerResources(NtroApp.locale("en"), "/chaine_en.properties");
		 
		 // FRAGMENTS
		 registrar.registerFragment(FragmentProfil.class, "/fragments/profils.xml");
		 
		 // DONNEES
		 registrar.registerViewData(DonneesVueInformations.class);
	}

}
