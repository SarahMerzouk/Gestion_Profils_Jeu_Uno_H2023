package uno.commun.valeurs;

import ca.ntro.app.models.ModelValue;

public class Joueur implements ModelValue {
	
	private String id;
	private String nom;
	private String pseudo;
	
	public Joueur() {
		
	}
	
	public Joueur(String id, String nom, String pseudo) {
		setId(id);
		setNom(nom);
		setPseudo(pseudo);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	
	
}
