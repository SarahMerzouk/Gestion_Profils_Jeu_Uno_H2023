package pong.commun.valeurs;

import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.models.ModelValue;
import pong.frontal.fragments.FragmentPartieEnCours;
import pong.frontal.fragments.FragmentRendezVous;

public class RendezVous implements ModelValue {

	private String idRendezVous;
	private Joueur premierJoueur;

	public RendezVous() {

	}

	public RendezVous(String idRendezVous, Joueur premierJoueur) {

		setIdRendezVous(idRendezVous);
		setPremierJoueur(premierJoueur);
	}

	public String getIdRendezVous() {
		return idRendezVous;
	}

	public void setIdRendezVous(String idRendezVous) {
		this.idRendezVous = idRendezVous;
	}

	public Joueur getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(Joueur premierJoueur) {
		this.premierJoueur = premierJoueur;
	}

	@Override
	public String toString() {
		return premierJoueur.toString();
	}

	public FragmentRendezVous creerFragment(ViewLoader<FragmentRendezVous> viewLoaderRendezVous,
			ViewLoader<FragmentPartieEnCours> viewLoaderPartieEnCours) {

		return viewLoaderRendezVous.createView();
	}
	
	 public void afficherSur(FragmentRendezVous fragmentRendezVous) {
         fragmentRendezVous.afficherNomPremierJoueur(premierJoueur.getPrenom());
     }
}
