package uno.commun.modeles;

import java.util.ArrayList;
import java.util.List;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;
import uno.commun.valeurs.Joueur;
import uno.frontal.vues.VueProfilDesJoueurs;

public class ModeleProfil implements Model, Watch, WriteObjectGraph {
	
	private List<Joueur> listeDesJoueurs = new ArrayList<>();
	
	public ModeleProfil() {
		
	}

	public List<Joueur> getListeDesJoueurs() {
		return listeDesJoueurs;
	}

	public void setListeDesJoueurs(List<Joueur> listeDesJoueurs) {
		this.listeDesJoueurs = listeDesJoueurs;
	}
	
	public void afficherSur(VueProfilDesJoueurs vueProfilDesJoueurs) {

		vueProfilDesJoueurs.afficherJoueursEnTexte(this.toString());
    }
	
	@Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        int nbJoueur = 1;
        
        for(Joueur joueur : listeDesJoueurs) {
        	
        	builder.append(nbJoueur);
        	builder.append(". ");
        	builder.append(joueur.getPseudo());
        	builder.append("\n");
        	
        	nbJoueur++;
        	
        }

        return builder.toString();
    }
}
