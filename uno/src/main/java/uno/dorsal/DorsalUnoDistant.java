package uno.dorsal;

import ca.ntro.app.ServerRegistrar;
import ca.ntro.app.backend.RemoteBackendNtro;
import uno.commun.Declarations;

public class DorsalUnoDistant extends RemoteBackendNtro {
	
	@Override
    public void registerServer(ServerRegistrar registrar) {
        Declarations.declarerServeur(registrar);
    }

}
