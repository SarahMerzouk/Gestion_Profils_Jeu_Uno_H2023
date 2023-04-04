package uno.frontal.donnees;

import ca.ntro.app.frontend.ViewData;
import ca.ntro.core.initialization.Ntro;
import uno.commun.monde2d.MondeUno2d;
import uno.frontal.vues.VueInformationsUnJoueur;

public class DonneesVueInformations implements ViewData {

	private MondeUno2d mondeUno2d = new MondeUno2d();
	private String fpsCourant = "0";

	private static long CALCULER_FPS_A_CHAQUE_X_MILLISECONDES = 200;
	private long horodatageDernierCalculFps = Ntro.time().nowMilliseconds();
	private long imagesAfficheesDepuisDernierCalculFps = 0;

	public void afficherSur(VueInformationsUnJoueur vueInformationsUnJoueur) {

		calculerFpsSiNecessaire();

		vueInformationsUnJoueur.viderCanvas();
		vueInformationsUnJoueur.afficherUno2d(mondeUno2d);

		imagesAfficheesDepuisDernierCalculFps++;

	}

	private void calculerFpsSiNecessaire() {
		long horodatageMaintenant = Ntro.time().nowMilliseconds();
		long millisecondesEcoulees = horodatageMaintenant - horodatageDernierCalculFps;

		if (millisecondesEcoulees > CALCULER_FPS_A_CHAQUE_X_MILLISECONDES) {
			calculerFpsMaintenant(millisecondesEcoulees);

			imagesAfficheesDepuisDernierCalculFps = 0;
			horodatageDernierCalculFps = horodatageMaintenant;
		}
	}

	private void calculerFpsMaintenant(long millisecondesEcoulees) {
		double secondesEcoulees = millisecondesEcoulees / 1E3;
		double fps = imagesAfficheesDepuisDernierCalculFps / secondesEcoulees;
		fpsCourant = String.valueOf(Math.round(fps));
	}

	public void reagirTempsQuiPasse(double elapsedTime) {
		mondeUno2d.onTimePasses(elapsedTime);
	}
}
