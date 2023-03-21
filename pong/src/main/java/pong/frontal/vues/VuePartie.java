package pong.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pong.commun.monde2d.MondePong2d;
import pong.frontal.controles.CanvasPartie;
import pong.frontal.evenements.EvtAfficherFileAttente;

public class VuePartie extends ViewFx {

	@FXML
	private Button boutonQuitterPartie;
	
	@FXML
    private CanvasPartie canvasPartie;
	
	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("boutonQuitterPartie", boutonQuitterPartie);
		
		Ntro.assertNotNull(canvasPartie);
		
		installerEvtAfficherFileAttente();
		
	}

	private void installerEvtAfficherFileAttente() {

		EvtAfficherFileAttente evtNtro = NtroApp.newEvent(EvtAfficherFileAttente.class);

		boutonQuitterPartie.setOnAction(evtFx -> {

			evtNtro.trigger();
		});
	}
	
	 public void viderCanvas() {
	        canvasPartie.clearCanvas();
	    }

	    public void afficherImagesParSeconde(String fps) {
	        canvasPartie.displayFps(fps);
	    }

	    public void afficherPong2d(MondePong2d mondePong2d) {
	        mondePong2d.drawOn(canvasPartie);
	    }
}
