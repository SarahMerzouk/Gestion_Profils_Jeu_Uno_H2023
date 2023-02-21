package uno;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.modeles.ModeleProfil;
import uno.commun.valeurs.Joueur;
import uno.dorsal.DorsalUno;
import uno.frontal.FrontalUno;

public class UnoCardsLocal implements NtroClientFx {
	
	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}
	
	@Override
	public void registerBackend(BackendRegistrar registrar) {

		registrar.registerBackend(new DorsalUno());
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		
		registrar.registerFrontend(new FrontalUno());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {

		registrar.registerMessage(MsgAjouterProfil.class);
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		registrar.registerModel(ModeleProfil.class);
		
		registrar.registerValue(Joueur.class);
		
	}

}
