package pong.dorsal.taches;

import static ca.ntro.app.tasks.backend.BackendTasks.*;

import ca.ntro.app.models.Model;
import ca.ntro.app.models.Watch;
import ca.ntro.app.models.WriteObjectGraph;
import ca.ntro.app.tasks.backend.BackendTasks;
import pong.commun.messages.MsgAjouterRendezVous;
import pong.commun.modeles.ModeleFileAttente;
import pong.commun.valeurs.Usager;

public class ModifierFileAttente{

    public static void creerTaches(BackendTasks tasks) {

        tasks.taskGroup("ModifierFileAttente")

             .waitsFor(model(ModeleFileAttente.class))

             .andContains(subTasks -> {

                    sInscrire(subTasks);

              });
    }

    private static void sInscrire(BackendTasks tasks) {
        tasks.task("sInscrire")

             .waitsFor(message(MsgAjouterRendezVous.class))

             .thenExecutes(inputs -> {

                 MsgAjouterRendezVous msgAjouterRendezVous = inputs.get(message(MsgAjouterRendezVous.class));
                 ModeleFileAttente    fileAttente          = inputs.get(model(ModeleFileAttente.class));

                 msgAjouterRendezVous.ajouterA(fileAttente);
             });
    }
    
}