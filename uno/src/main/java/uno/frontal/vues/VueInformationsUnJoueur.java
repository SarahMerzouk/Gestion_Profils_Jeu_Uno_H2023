package uno.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import uno.commun.monde2d.MondeUno2d;
import uno.frontal.controles.CanvasInformations;
import uno.frontal.evenements.EvtAfficherProfil;

public class VueInformationsUnJoueur extends ViewFx {
	
	@FXML
	private Button boutonQuitterPageInfos;
	
	 @FXML
	 private CanvasInformations canvasInformations;

	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("boutonQuitterPageInfos", boutonQuitterPageInfos);
		Ntro.assertNotNull("canvasInformations",canvasInformations);
		
		installerEvtAfficherProfils();
		
	}
	
	private void installerEvtAfficherProfils() {
		
		EvtAfficherProfil evtNtro = NtroApp.newEvent(EvtAfficherProfil.class);

        boutonQuitterPageInfos.setOnAction(evtFx -> {

           evtNtro.trigger();

        });
    }
	
	public void viderCanvas() {
        canvasInformations.clearCanvas();
    }
	
//	public void afficherImagesParSeconde(String fps) {
//        canvasInformations.afficherFps(fps);
//    }
	
    public void afficherUno2d(MondeUno2d mondeUno2d) {
        mondeUno2d.drawOn(canvasInformations);
    }

}
