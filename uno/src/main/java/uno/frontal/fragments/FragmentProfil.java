package uno.frontal.fragments;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import uno.commun.messages.MsgRetirerUnProfil;
import uno.frontal.evenements.EvtAfficherInformations;
import uno.frontal.evenements.EvtAfficherProfil;

public class FragmentProfil extends ViewFragmentFx {

	@FXML
	private Button boutonVoirInfos;

	@FXML
	private Button boutonRetirerProfil;

	@FXML
	private Label labelPseudoJoueur;
	
	private String idProfil;

	@Override
	public void initialiser() {
		Ntro.assertNotNull("boutonVoirInfos", boutonVoirInfos);

		Ntro.assertNotNull("boutonRetirerProfil",boutonRetirerProfil);

		Ntro.assertNotNull("labelPseudoJoueur", labelPseudoJoueur);

		installerEvtAfficherInformations();

	}

	public void afficherPseudoDuJoueur(String pseudoJoueur) {
		labelPseudoJoueur.setText(pseudoJoueur);
	}

	public void afficherSousVue(ViewFx sousVue) {

		Pane racineSousVue = sousVue.rootNode();

		rootNode().getChildren().clear();
		rootNode().getChildren().add(racineSousVue);
	}
	
	public void memoriserIdProfil(String idProfil) {
        this.idProfil = idProfil;
        installerMsgRetirerLeProfil(idProfil);
    }
	
	private void installerEvtAfficherInformations() {

		EvtAfficherInformations evtNtro = NtroApp.newEvent(EvtAfficherInformations.class);

		boutonVoirInfos.setOnAction(evtFx -> {

			evtNtro.trigger();

		});
	}
	
	protected void installerMsgRetirerLeProfil(String idProfil) {
		
		MsgRetirerUnProfil msgRetirerUnProfil = NtroApp.newMessage(MsgRetirerUnProfil.class);
		msgRetirerUnProfil.setIdProfil(idProfil);
		
		boutonRetirerProfil.setOnAction(evtFx -> {
			msgRetirerUnProfil.send();
		});
	}
}
