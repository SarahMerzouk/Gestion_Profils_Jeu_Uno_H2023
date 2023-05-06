package uno.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.NtroApp;
import ca.ntro.app.tasks.backend.BackendTasks;
import uno.commun.messages.MsgAjouterProfil;
import uno.commun.messages.MsgModifierJoueur;
import uno.commun.messages.MsgRafraichirModeleProfil;
import uno.commun.messages.MsgRetirerTousLesProfils;
import uno.commun.messages.MsgRetirerUnProfil;
import uno.commun.modeles.ModeleProfil;

public class ModifierProfil {

	public static void creerTaches(BackendTasks tasks) {

		tasks.taskGroup("ModifierProfil")

				.waitsFor(model(ModeleProfil.class))

				.andContains(subTasks -> {

					ajouterProfil(subTasks);
					retirerTousLesProfils(subTasks);
					retirerLeProfil(subTasks);
					rafraichirProfil(subTasks);
					modifierJoueur(subTasks);

				});
	}

	private static void ajouterProfil(BackendTasks subTasks) {
		subTasks.task("ajouterProfil")

				.waitsFor(message(MsgAjouterProfil.class))

				.thenExecutes(inputs -> {

					MsgAjouterProfil msgAjouterProfil = inputs.get(message(MsgAjouterProfil.class));
					ModeleProfil profil = inputs.get(model(ModeleProfil.class));

					msgAjouterProfil.ajouterA(profil);
				});
	}

	private static void rafraichirProfil(BackendTasks subTasks) {
		subTasks.task("rafraichirModeleProfil")

				.waitsFor(message(MsgRafraichirModeleProfil.class))

				.thenExecutes(inputs -> {

					// XXX: contournement pour forcer a re-observer le modele

				});
	}

	private static void retirerTousLesProfils(BackendTasks subTasks) {
		subTasks.task("retirerTousLesProfils")

				.waitsFor(message(MsgRetirerTousLesProfils.class))

				.thenExecutes(inputs -> {

					MsgRetirerTousLesProfils msgRetirerTousLesProfils = inputs
							.get(message(MsgRetirerTousLesProfils.class));
					ModeleProfil profil = inputs.get(model(ModeleProfil.class));

					msgRetirerTousLesProfils.supprimerTout(profil);
				});
	}

	private static void retirerLeProfil(BackendTasks subTasks) {
		subTasks.task("retirerLeProfil")

				.waitsFor(message(MsgRetirerUnProfil.class))

				.thenExecutes(inputs -> {

					MsgRetirerUnProfil msgRetirerUnProfil = inputs.get(message(MsgRetirerUnProfil.class));
					ModeleProfil profil = inputs.get(model(ModeleProfil.class));

					msgRetirerUnProfil.retirerLeProfil(profil);
				});

	}
	
	private static void modifierJoueur(BackendTasks subTasks) {
		  subTasks.task("modifierJoueur")

          .waitsFor(message(MsgModifierJoueur.class))
          
          .thenExecutes(inputs -> {

        	  MsgModifierJoueur msgModifierJoueur = inputs.get(message(MsgModifierJoueur.class));
              ModeleProfil    profil          = inputs.get(model(ModeleProfil.class));

              msgModifierJoueur.modifier(profil);              
          });
	}
}
