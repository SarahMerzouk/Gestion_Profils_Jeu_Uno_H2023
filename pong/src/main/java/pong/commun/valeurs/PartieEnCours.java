package pong.commun.valeurs;

public class PartieEnCours extends RendezVous {

	private String nomDeuxiemeJoueur;
	private String idPartie;

	public PartieEnCours() {
		super();
	}

	public String getNomDeuxiemeJoueur() {
		return nomDeuxiemeJoueur;
	}

	public void setNomDeuxiemeJoueur(String nomDeuxiemeJoueur) {
		this.nomDeuxiemeJoueur = nomDeuxiemeJoueur;
	}

	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	
}
