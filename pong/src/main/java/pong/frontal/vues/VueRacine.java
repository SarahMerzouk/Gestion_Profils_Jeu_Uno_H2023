package pong.frontal.vues;

import java.net.URL;
import java.util.ResourceBundle;

import ca.ntro.app.views.ViewFx;
import javafx.scene.layout.Pane;

public class VueRacine extends ViewFx {

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// On s'en sert au module 4
	}
	
	public void afficherSousVue(ViewFx sousVue) {

		Pane racineSousVue = sousVue.rootNode();

		rootNode().getChildren().clear();
		rootNode().getChildren().add(racineSousVue);
	}

}
