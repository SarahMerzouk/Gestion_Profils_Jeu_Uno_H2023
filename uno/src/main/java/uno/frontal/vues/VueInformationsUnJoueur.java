package uno.frontal.vues;

import ca.ntro.app.NtroApp;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import uno.commun.messages.MsgModifierJoueur;
import uno.commun.monde2d.MondeUno2d;
import uno.commun.valeurs.Joueur;
import uno.frontal.controles.CanvasInformations;
import uno.frontal.evenements.EvtAfficherProfil;

public class VueInformationsUnJoueur extends ViewFx {
	
	@FXML
	private Button boutonQuitterPageInfos;
	
	@FXML
	private Button boutonModifier;
	
	 @FXML
	 private CanvasInformations canvasInformations;
	 
	 @FXML 
	 private TextField textFieldId;
	 
	 @FXML 
	 private TextField textFieldNom;
	 
	 @FXML 
	 private TextField textFieldPseudo;
	 
	 private String idProfil;
	 private Joueur joueur;

	@Override
	public void initialiser() {
		
		Ntro.assertNotNull("boutonQuitterPageInfos", boutonQuitterPageInfos);
		Ntro.assertNotNull("boutonModifier", boutonModifier);
		Ntro.assertNotNull("canvasInformations",canvasInformations);
		Ntro.assertNotNull("textFieldId", textFieldId);
		Ntro.assertNotNull("textFieldNom", textFieldNom);
		Ntro.assertNotNull("textFieldPseudo", textFieldPseudo);
		
		installerEvtAfficherProfils();
		installerMsgModifier(idProfil, joueur);
	}
	
	private void installerEvtAfficherProfils() {
		
		EvtAfficherProfil evtNtro = NtroApp.newEvent(EvtAfficherProfil.class);

        boutonQuitterPageInfos.setOnAction(evtFx -> {

           evtNtro.trigger();

        });
    }
	
	protected void installerMsgModifier(String idProfil, Joueur joueur) {

        MsgModifierJoueur msgModifierJoueur = NtroApp.newMessage(MsgModifierJoueur.class);
        
        msgModifierJoueur.setIdProfil(idProfil);
        msgModifierJoueur.setNewJoueur(joueur);
        
        boutonModifier.setOnAction(evtFx -> {
        	msgModifierJoueur.send();
        });
        
}
	
	public void viderCanvas() {
        canvasInformations.clearCanvas();
    }
	
    public void afficherUno2d(MondeUno2d mondeUno2d) {
        mondeUno2d.drawOn(canvasInformations);
    }
    
    public void afficherInformations(Joueur joueur) {
    	textFieldId.clear();
    	textFieldNom.clear();
    	textFieldPseudo.clear();
    	
    	textFieldId.setText(joueur.getId());
    	textFieldNom.setText(joueur.getNom());
    	textFieldPseudo.setText(joueur.getPseudo());
    }

}
