package pong.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;

public class PartieEnCours extends RendezVous {

	private String idPartie;
	private Joueur deuxiemeJoueur;

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

	public Joueur getDeuxiemeJoueur() {
		return deuxiemeJoueur;
	}

	public void setDeuxiemeJoueur(Joueur deuxiemeJoueur) {
		this.deuxiemeJoueur = deuxiemeJoueur;
	}

	@Override
	public FragmentRendezVous creerFragment(ViewLoader<FragmentRendezVous> viewLoaderRendezVous,
			ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours) {

		return viewLoaderPartieEnCours.createView();
	}
	
	public void afficherSur(FragmentRendezVous fragmentRendezVous) {
        super.afficherSur(fragmentRendezVous);
        
        FragmentPartieEnCours fragmentPartieEnCours = (FragmentPartieEnCours) fragmentRendezVous;
        fragmentPartieEnCours.afficherNomDeuxiemeJoueur(deuxiemeJoueur.getPrenom());
    }
}
