package uno.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.WatchJson;
import ca.ntro.app.models.WriteObjectGraph;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.valeurs.Joueur;
import uno.frontal.vues.VueInformationsUnJoueur;
import uno.frontal.vues.VueProfilDesJoueurs;

public class ModeleProfil implements Model, WriteObjectGraph {

	private List<Joueur> listeDesJoueurs = new ArrayList<>();

	public ModeleProfil() {

	}

	public List<Joueur> getListeDesJoueurs() {
		return listeDesJoueurs;
	}

	public void setListeDesJoueurs(List<Joueur> listeDesJoueurs) {
		this.listeDesJoueurs = listeDesJoueurs;
	}

	public void afficherSurProfil(VueProfilDesJoueurs vueProfilDesJoueurs) {

		vueProfilDesJoueurs.viderListeProfils();

		for (Joueur joueur : listeDesJoueurs) {

			vueProfilDesJoueurs.ajouterProfil(joueur);
		}
	}
	
	public void afficherSurInformations(VueInformationsUnJoueur vueInformationsUnJoueur, String idProfil) {
				
		Joueur joueur = null;
		
		for (int i = 0; i < listeDesJoueurs.size(); i++) {
			if (listeDesJoueurs.get(i).getId().equals(idProfil)) {
				joueur = listeDesJoueurs.get(i);
				break;
				
			}
		}
		
		if (joueur != null) {
			vueInformationsUnJoueur.afficherInformations(joueur);
		}		
	}
	
	@Override
	public String toString() {

		StringBuilder builder = new StringBuilder();
		int nbJoueur = 1;

		for (Joueur joueur : listeDesJoueurs) {

			builder.append(nbJoueur);
			builder.append(". ");
			builder.append(joueur.getPseudo());
			builder.append("\n");

			nbJoueur++;

		}

		return builder.toString();
	}

	public void ajouterProfil(MsgAjouterProfil msg) {

		Joueur joueur = msg.getJoueur();
	}

	public void ajouterProfil(Joueur player) {
		listeDesJoueurs.add(player);
	}

	public void retirerTousLesProfils() {
		listeDesJoueurs.clear();
	}
	
	public void retirerLeProfil(String idProfil) {
		int indiceProfil = -1;
		
		for (int i = 0; i < listeDesJoueurs.size(); i++) {
			if (listeDesJoueurs.get(i).getId().equals(idProfil)) {
				indiceProfil = i;
				break;
			}
		}
		
		if (indiceProfil >= 0) {
			listeDesJoueurs.remove(indiceProfil);
		}
		
	}
	
	public void modifierJoueur(String idProfil, Joueur newJoueur) {
		int indiceProfil = -1;
		
		for (int i = 0; i < listeDesJoueurs.size(); i++ ) {
			if(listeDesJoueurs.get(i).getId().equals(idProfil)) {
	                indiceProfil = i;
	                break;
	            }
		}

		if (indiceProfil >= 0) {
			listeDesJoueurs.set(indiceProfil, newJoueur);
		}
	}


}
