package uno.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import uno.commun.modeles.ModeleProfil;
import uno.commun.valeurs.Joueur;
import uno.frontal.evenements.EvtAfficherAcceuil;
import uno.frontal.evenements.EvtAfficherProfil;

public class VueProfilDesJoueurs extends ViewFx{
	
	@FXML
	private Label labelUnJoueur;
	
	@FXML
	private Button boutonRetourVersAcceuil;
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
		Ntro.assertNotNull("labelUnJoueur", labelUnJoueur);
		
		Ntro.assertNotNull("boutonRetourVersAcceuil", boutonRetourVersAcceuil);
		
		installerEvtAfficherAcceuil();
	}
	
	private void installerEvtAfficherAcceuil() {
		
		EvtAfficherAcceuil evtNtro = NtroApp.newEvent(EvtAfficherAcceuil.class);
		
		boutonRetourVersAcceuil.setOnAction(evtFx -> {

			evtNtro.trigger();

		});
	}
	
	public void afficher(ModeleProfil profil){

        List<Joueur> joueurs = profil.getListeDesJoueurs();

    }
	
	public void afficherJoueursEnTexte(String message) {
        labelUnJoueur.setText(message);
    }

}
