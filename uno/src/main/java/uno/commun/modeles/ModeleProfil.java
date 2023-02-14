package uno.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;
import uno.commun.valeurs.Joueur;

public class ModeleProfil implements Model, Watch, WriteObjectGraph {
	
	private String idJoueur;
	private List<Joueur> listeDesJoueurs = new ArrayList<>();
	
	public ModeleProfil() {
		
	}

	public String getIdJoueur() {
		return idJoueur;
	}

	public void setIdJoueur(String idJoueur) {
		this.idJoueur = idJoueur;
	}

	public List<Joueur> getListeDesJoueurs() {
		return listeDesJoueurs;
	}

	public void setListeDesJoueurs(List<Joueur> listeDesJoueurs) {
		this.listeDesJoueurs = listeDesJoueurs;
	}
	
}
