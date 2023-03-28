package uno.maquettes;

import uno.commun.enums.Cadran;
import uno.commun.valeurs.Joueur;

public class MaquetteSession {

    public static boolean modeTest = true;

    static Joueur usagerCourant = MaquetteProfils.usagerAleatoire();
    private static Cadran cadranCourant = Cadran.DROITE;

    public static Joueur usagerCourant () {
        return usagerCourant;
    }

    public static boolean siOnPeutJouerGauche() {
        return cadranCourant == Cadran.GAUCHE 
                || cadranCourant == Cadran.LES_DEUX;

    }

    public static boolean siOnPeutJouerDroite() {
        return cadranCourant == Cadran.DROITE 
                || cadranCourant == Cadran.LES_DEUX;

    }

    public static void memoriserCadranCourant(String idPremierJoueur, 
                                              String idDeuxiemeJoueur) {

        if(idPremierJoueur.equals(usagerCourant.getId())) {

            cadranCourant = Cadran.GAUCHE;

        }else if(idDeuxiemeJoueur.equals(usagerCourant.getId())) {

            cadranCourant = Cadran.DROITE;

        }else {

            cadranCourant = Cadran.LES_DEUX;
        }
    }

    public static void initialiser(String[] args) {
        String id = null;
        String nom = null;
        String pseudo = null;

        if(args.length > 0) {
            id = args[0];
            modeTest = false;
        }else {
            id = MaquetteProfils.idAleatoire();
        }           

        if(args.length > 1) {
            pseudo = args[1];
        }else {
            pseudo = MaquetteProfils.pseudoAleatoire();
        }

        if(args.length > 2) {
            nom = args[2];
        }else {
            nom = MaquetteProfils.nomAleatoire();
        }

        usagerCourant = new Joueur(id,nom, pseudo);
    }

}