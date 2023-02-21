package uno.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import uno.commun.modeles.ModeleProfil;
import uno.commun.valeurs.Joueur;

public class MsgAjouterProfil extends MessageNtro {

	private Joueur joueur;

	public MsgAjouterProfil() {

	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public void ajouterA(ModeleProfil profil) {

		profil.ajouterProfil(joueur);
	}

}
