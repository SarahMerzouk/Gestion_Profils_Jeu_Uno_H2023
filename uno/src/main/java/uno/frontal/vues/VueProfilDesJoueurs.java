package uno.frontal.vues;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import ca.ntro.app.NtroApp;
import ca.ntro.app.frontend.ViewLoader;
import ca.ntro.app.fx.controls.ResizableAvatar;
import ca.ntro.app.views.ViewFx;
import ca.ntro.core.initialization.Ntro;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.messages.MsgRetirerTousLesProfils;
import uno.commun.modeles.ModeleProfil;
import uno.commun.valeurs.Joueur;
import uno.frontal.evenements.EvtAfficherAcceuil;
import uno.frontal.evenements.EvtAfficherInformations;
import uno.frontal.evenements.EvtAfficherProfil;
import uno.frontal.fragments.FragmentProfil;
import uno.maquettes.MaquetteProfils;
import uno.maquettes.MaquetteSession;

public class VueProfilDesJoueurs extends ViewFx {

	@FXML
	private Button boutonRetourVersAcceuil;

	@FXML
	private Button boutonAjouter;

	@FXML
	private VBox conteneurProfil;

	@FXML
	private Button boutonRetirerTousLesProfils;

	private ViewLoader<FragmentProfil> viewLoaderProfil;

	@FXML
	private ResizableAvatar logo;

	@Override
	public void initialiser() {

		Ntro.assertNotNull("boutonRetourVersAcceuil", boutonRetourVersAcceuil);

		Ntro.assertNotNull("boutonAjouter", boutonAjouter);

		Ntro.assertNotNull("conteneurProfil", conteneurProfil);

		Ntro.assertNotNull("boutonRetirerTousLesProfils", boutonRetirerTousLesProfils);

		Ntro.assertNotNull(logo);

		logo.setImage(new Image("/logoUnePersonne.jpg"));

		installerEvtAfficherAcceuil();
		installerMsgAjouterProfil();
		installerMsgSupprimerTousLesProfils();
	}

	private void installerEvtAfficherAcceuil() {

		EvtAfficherAcceuil evtNtro = NtroApp.newEvent(EvtAfficherAcceuil.class);

		boutonRetourVersAcceuil.setOnAction(evtFx -> {

			evtNtro.trigger();

		});
	}

	public void afficher(ModeleProfil profil) {

		List<Joueur> joueurs = profil.getListeDesJoueurs();

	}

	private void installerMsgAjouterProfil() {
		MsgAjouterProfil msgAjouterProfil = NtroApp.newMessage(MsgAjouterProfil.class);

		boutonAjouter.setOnAction(evtFx -> {

			msgAjouterProfil.setJoueur(MaquetteProfils.usagerCourant());
			msgAjouterProfil.send();

			MaquetteProfils.prochainUsager();
		});

	}

	private void installerMsgSupprimerTousLesProfils() {
		MsgRetirerTousLesProfils msgRetirerTousLesProfils = NtroApp.newMessage(MsgRetirerTousLesProfils.class);

		boutonRetirerTousLesProfils.setOnAction(evtFx -> {
			msgRetirerTousLesProfils.send();
		});

	}

	public ViewLoader<FragmentProfil> getViewLoaderProfil() {
		return viewLoaderProfil;
	}

	public void setViewLoaderProfil(ViewLoader<FragmentProfil> viewLoaderProfil) {
		this.viewLoaderProfil = viewLoaderProfil;
	}

	public void ajouterProfil(Joueur joueur) {
		FragmentProfil fragment = joueur.creerFragment(viewLoaderProfil);
		joueur.afficherSur(fragment);

		conteneurProfil.getChildren().add(fragment.rootNode());
	}

	public void viderListeProfils() {
		conteneurProfil.getChildren().clear();
	}
}
