package uno.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.messages.MsgRafraichirModeleProfil;
import uno.commun.messages.MsgRetirerTousLesProfils;
import uno.commun.messages.MsgRetirerUnProfil;
import uno.commun.modeles.ModeleProfil;
import uno.commun.valeurs.Joueur;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterProfil.class);
		registrar.registerMessage(MsgRafraichirModeleProfil.class);
		registrar.registerMessage(MsgRetirerUnProfil.class);
		registrar.registerMessage(MsgRetirerTousLesProfils.class);
		
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		
		registrar.registerModel(ModeleProfil.class);	
		registrar.registerValue(Joueur.class);
	}
	
}
