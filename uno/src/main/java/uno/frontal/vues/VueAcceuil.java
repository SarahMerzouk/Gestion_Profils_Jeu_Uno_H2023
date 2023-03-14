package uno.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import uno.frontal.evenements.EvtAfficherAcceuil;
import uno.frontal.evenements.EvtAfficherProfil;

public class VueAcceuil  extends ViewFx {
	
	@FXML
	private Button boutonVersProfils;
	
	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("boutonVersProfils", boutonVersProfils);
		
		installerEvtAfficherProfil();
	}
	
	private void installerEvtAfficherProfil() {
		
		EvtAfficherProfil evtNtro = NtroApp.newEvent(EvtAfficherProfil.class);

		boutonVersProfils.setOnAction(evtFx -> {

			evtNtro.trigger();

		});
	}

}
