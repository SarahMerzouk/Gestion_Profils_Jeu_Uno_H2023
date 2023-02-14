package pong.commun.valeurs;

public class PartieEnCours extends RendezVous {

	private String idPartie;
	private Usager deuxiemeJoueur;

	public PartieEnCours() {
		super();
	}


	public String getIdPartie() {
		return idPartie;
	}

	public void setIdPartie(String idPartie) {
		this.idPartie = idPartie;
	}
	
	@Override
    public String toString() {
        return getPremierJoueur().getPrenom() + " Vs " + deuxiemeJoueur.getPrenom();
    }

	public Usager getDeuxiemeJoueur() {
		return deuxiemeJoueur;
	}

	public void setDeuxiemeJoueur(Usager deuxiemeJoueur) {
		this.deuxiemeJoueur = deuxiemeJoueur;
	}
	
	
}
