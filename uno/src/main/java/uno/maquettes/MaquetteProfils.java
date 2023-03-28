 package uno.maquettes;

import java.util.List;

import ca.ntro.core.initialization.Ntro;
import uno.commun.valeurs.Joueur;

public class MaquetteProfils {

    private static Joueur usagerCourant = usagerAleatoire();

    public static Joueur usagerCourant() {
        return MaquetteSession.usagerCourant;
    }

    public static void prochainUsager() {
        MaquetteSession.usagerCourant = eviterRepetitionDePrenom(usagerAleatoire());
    }

    public static Joueur usagerAleatoire() {
    	Joueur usager = new Joueur();

        usager.setId(idAleatoire());
        usager.setNom(nomAleatoire());
        usager.setPseudo(pseudoAleatoire());

        return usager;
    }

    private static Joueur eviterRepetitionDePrenom(Joueur usagerAleatoire) {
        while(usagerAleatoire.getPseudo().equals(MaquetteSession.usagerCourant.getPseudo())) {

            usagerAleatoire.setPseudo(pseudoAleatoire());
        }

        return usagerAleatoire;
    }


    static String idAleatoire() {
        return Ntro.random().nextId(4);
    }

    static String pseudoAleatoire() {

        List<String> choixDePseudos = List.of("Alice23", 
                                           "Bob#2i", 
                                           "Chaaya9082", 
                                           "1223Dominic", 
                                           "12Élisabeth12", 
                                           "87Firas09", 
                                           "90Gregson09",
                                           "Mehd56i",
                                           "Louis2",
                                           "Marcel1",
                                           "Ashwin34",
                                           "Ichiro0000",
                                           "Jun9999");

        return Ntro.random().choice(choixDePseudos);
    }

    static String nomAleatoire() {

        List<String> choixDeNoms = List.of("Abdenouri", 
                                           "Ahmadi", 
                                           "Augustin", 
                                           "Chaussé", 
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
