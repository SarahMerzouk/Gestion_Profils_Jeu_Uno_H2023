package uno.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class VueAcceuil  extends ViewFx {
	
	@FXML
	private Button boutonVersProfils;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("boutonVersProfils", boutonVersProfils);
		
		installerEvtAfficherProfil();
	}
	
	private void installerEvtAfficherProfil() {

		boutonVersProfils.setOnAction(evtFx -> {

			System.out.println("[VueAcceuil] clic: " + evtFx.getEventType());

		});
	}

}
