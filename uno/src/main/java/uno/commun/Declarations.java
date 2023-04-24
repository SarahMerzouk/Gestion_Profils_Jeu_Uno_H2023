package uno.commun;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.modeles.ModeleProfil;
import uno.commun.valeurs.Joueur;

public class Declarations {

	public static void declarerMessages(MessageRegistrar registrar) {
		registrar.registerMessage(MsgAjouterProfil.class);
	}

	public static void declarerModeles(ModelRegistrar registrar) {
		
		registrar.registerModel(ModeleProfil.class);	
		registrar.registerValue(Joueur.class);
	}
	
}
