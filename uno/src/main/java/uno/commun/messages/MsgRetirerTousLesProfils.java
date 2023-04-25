package uno.commun.messages;

import ca.ntro.app.messages.MessageNtro;
import uno.commun.modeles.ModeleProfil;

public class MsgRetirerTousLesProfils extends MessageNtro {

	public MsgRetirerTousLesProfils() {
	}
	
	public void supprimerTout(ModeleProfil profil) {

		profil.retirerTousLesProfils();
	}

}
