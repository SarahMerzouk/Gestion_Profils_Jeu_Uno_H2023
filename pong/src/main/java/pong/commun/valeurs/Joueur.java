package pong.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {

	private String id;
	private String prenom;
	private String nom;
	
	public Joueur() {
		
	}
	public Joueur(String pId, String pPrenom, String Pnom) {
		id = pId;
		prenom = pPrenom;
		nom = Pnom;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@Override
    public String toString() {
        return nomComplet();
    }

    public String nomComplet() {
        return prenom + " " + nom;
    }
}
