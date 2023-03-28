package pong.maquettes;

import java.util.List;

import ca.ntro.core.initialization.Ntro;
import pong.commun.valeurs.Joueur;

public class MaquetteUsagers {

    public static void prochainUsager() {
        MaquetteSession.usagerCourant = eviterRepetitionDePrenom(usagerAleatoire());
    }

    public static Joueur usagerCourant () {
        return MaquetteSession.usagerCourant;
    }

    static Joueur usagerAleatoire() {
        Joueur usager = new Joueur();

        usager.setId(idAleatoire());
        usager.setPrenom(prenomAleatoire());
        usager.setNom(nomAleatoire());

        return usager;
    }

    private static Joueur eviterRepetitionDePrenom(Joueur usagerAleatoire) {

        while(usagerAleatoire.getPrenom().equals(MaquetteSession.usagerCourant.getPrenom())) {

            usagerAleatoire.setPrenom(prenomAleatoire());
        }

        return usagerAleatoire;
    }

    static String idAleatoire() {
        return Ntro.random().nextId(4);
    }

    static String prenomAleatoire() {

        List<String> choixDeNoms = List.of("Alice", 
                                           "Bob", 
                                           "Chaaya", 
                                           "Dominic", 
                                           "�lisabeth", 
                                           "Firas", 
                                           "Gregson",
                                           "Mehdi",
                                           "Louis",
                                           "Marcel",
                                           "Ashwin",
                                           "Ichiro",
                                           "Jun");

        return Ntro.random().choice(choixDeNoms);
    }

    static String nomAleatoire() {

        List<String> choixDeNoms = List.of("Abdenouri", 
                                           "Ahmadi", 
                                           "Augustin", 
                                           "Chauss�", 
                                           "Delisle", 
                                           "Heer", 
                                           "Lagrois",
                                           "Daverna",
                                           "Gonzales",
                                           "Medjoubi",
                                           "Castillo",
                                           "Josan",
                                           "Yi");

        return Ntro.random().choice(choixDeNoms);
    }
}