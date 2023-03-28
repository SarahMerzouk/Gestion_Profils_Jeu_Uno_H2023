package uno;

import ca.ntro.app.NtroClientFx;
import ca.ntro.app.backend.BackendRegistrar;
import ca.ntro.app.frontend.FrontendRegistrarFx;
import ca.ntro.app.messages.MessageRegistrar;
import ca.ntro.app.models.ModelRegistrar;
import uno.commun.Declarations;
import uno.dorsal.DorsalUnoDistant;
import uno.frontal.FrontalUno;
import uno.maquettes.MaquetteSession;

public class ClientUno implements NtroClientFx {
	
	public static void main(String[] args) {
		MaquetteSession.initialiser(args);
		NtroClientFx.launch(args);
	}
	
	@Override
	public void registerBackend(BackendRegistrar registrar) {

		registrar.registerBackend(new DorsalUnoDistant());
	}

	@Override
	public void registerFrontend(FrontendRegistrarFx registrar) {
		
		registrar.registerFrontend(new FrontalUno());
	}

	@Override
	public void registerMessages(MessageRegistrar registrar) {

		Declarations.declarerMessages(registrar);
	}

	@Override
	public void registerModels(ModelRegistrar registrar) {
		
		Declarations.declarerModeles(registrar);
		
	}
}
