package uno.frontal.fragments;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import uno.frontal.evenements.EvtAfficherInformations;
import uno.frontal.evenements.EvtAfficherProfil;

public class FragmentProfil extends ViewFragmentFx {

	@FXML
	private Button boutonVoirInfos;

	// @FXMLs
	// private Button boutonSupprimerJoueur;

	@FXML
	private Label labelPseudoJoueur;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonVoirInfos", boutonVoirInfos);

		// Ntro.assertNotNull("boutonSupprimerJoueur",boutonSupprimerJoueur);

		Ntro.assertNotNull("labelPseudoJoueur", labelPseudoJoueur);

		installerEvtAfficherInformations();

	}

	public void afficherPseudoDuJoueur(String pseudoJoueur) {
		labelPseudoJoueur.setText(pseudoJoueur);
	}

	private void installerEvtAfficherInformations() {

		EvtAfficherInformations evtNtro = NtroApp.newEvent(EvtAfficherInformations.class);

		boutonVoirInfos.setOnAction(evtFx -> {

			evtNtro.trigger();

		});
	}

	public void afficherSousVue(ViewFx sousVue) {

		Pane racineSousVue = sousVue.rootNode();

		rootNode().getChildren().clear();
		rootNode().getChildren().add(racineSousVue);
	}
}
