package pong.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.valeurs.Joueur;

public class MsgAjouterRendezVous extends MessageNtro {
	
	private Joueur premierJoueur;
	
	public MsgAjouterRendezVous() {
		
	}

	public Joueur getPremierJoueur() {
		return premierJoueur;
	}

	public void setPremierJoueur(Joueur premierJoueur) {
		this.premierJoueur = premierJoueur;
	}
	
	public void ajouterA(ModeleFileAttente fileAttente) {
		fileAttente.inscrire(premierJoueur);
	}
	
}
