package pong;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import pong.commun.modeles.ModeleFileAttente;
import pong.frontal.FrontalPong;

public class PongLocal implements NtroClientFx {

	public static void main(String[] args) {
		NtroClientFx.launch(args);
	}

	@Override
	public void registerBackend(BackendRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		
		registrar.registerFrontend(new FrontalPong());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		registrar.registerModel(ModeleFileAttente.class);
		
	}

}
