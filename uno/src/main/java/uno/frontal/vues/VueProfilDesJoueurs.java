package uno.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class VueProfilDesJoueurs extends ViewFx{
	
	@FXML
	private Label labelUnJoueur;
	private Button boutonRetourVersAcceuil;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("labelUnJoueur", labelUnJoueur);
		
		Ntro.assertNotNull("boutonRetourVersAcceuil", boutonRetourVersAcceuil);
		
		installerEvtAfficherAcceuil();
	}
	
	private void installerEvtAfficherAcceuil() {

		boutonRetourVersAcceuil.setOnAction(evtFx -> {

			System.out.println("[VueProfil] clic:" + evtFx.getEventType());

		});
	}

}
