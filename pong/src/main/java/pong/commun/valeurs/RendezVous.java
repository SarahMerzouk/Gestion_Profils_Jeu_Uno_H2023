package pong.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class RendezVous implements ModelValue {
	
	private String idRendezVous;
	private String premierJoueur;
	    
	public RendezVous() {
		
	}

	public String getIdRendezVous() {
		return idRendezVous;
	}

	public void setIdRendezVous(String idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public String getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(String premierJoueur) {
		this.premierJoueur = premierJoueur;
	}
	
	
}
