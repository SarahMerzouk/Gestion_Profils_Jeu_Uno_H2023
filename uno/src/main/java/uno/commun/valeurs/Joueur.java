package uno.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import uno.frontal.fragments.FragmentProfil;

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
	
	public FragmentProfil creerFragment(ViewLoader<FragmentProfil> viewLoaderProfil){

		return viewLoaderProfil.createView();
	}
	
	public void afficherSur(FragmentProfil fragmentProfil) {
		fragmentProfil.afficherPseudoDuJoueur(getPseudo());
		
		fragmentProfil.memoriserIdProfil(id);
    }
}
