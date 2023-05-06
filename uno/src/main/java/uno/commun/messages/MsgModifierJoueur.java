package uno.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import uno.commun.modeles.ModeleProfil;
import uno.commun.valeurs.Joueur;

public class MsgModifierJoueur  extends MessageNtro {

	private String idProfil;
	private Joueur newJoueur;
	
	public MsgModifierJoueur() {
		
	}

	public String getIdProfil() {
		return idProfil;
	}

	public void setIdProfil(String idProfil) {
		this.idProfil = idProfil;
	}

	public Joueur getNewJoueur() {
		return newJoueur;
	}

	public void setNewJoueur(Joueur newJoueur) {
		this.newJoueur = newJoueur;
	}
	
	public void modifier(ModeleProfil profil) {
		profil.modifierJoueur(idProfil, newJoueur);
	}
}
