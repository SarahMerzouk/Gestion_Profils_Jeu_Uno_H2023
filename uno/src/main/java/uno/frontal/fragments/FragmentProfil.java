package uno.frontal.fragments;

import ca.ntro.app.views.ViewFragmentFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class FragmentProfil extends ViewFragmentFx {
	
	//@FXML
    //private Button boutonVoirInfos;
	
	//@FXMLs
    // private Button boutonSupprimerJoueur;
	
	@FXML
	private Label labelPseudoJoueur;

	@Override
	public void initialiser() {
		//Ntro.assertNotNull("boutonVoirInfos",boutonVoirInfos);
		
		//Ntro.assertNotNull("boutonSupprimerJoueur",boutonSupprimerJoueur);
		
		Ntro.assertNotNull("labelPseudoJoueur",labelPseudoJoueur);
		
	}
	
	public void afficherPseudoDuJoueur(String pseudoJoueur) {
        labelPseudoJoueur.setText(pseudoJoueur);
    }
}
