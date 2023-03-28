package pong.maquettes;

import pong.commun.enumPacket.Cadran;
import pong.commun.valeurs.Joueur;

public class MaquetteSession {

    public static boolean modeTest = true;

    static Joueur usagerCourant = MaquetteUsagers.usagerAleatoire();
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
        String prenom = null;
        String nom = null;

        if(args.length > 0) {
            id = args[0];
            modeTest = false;
        }else {
            id = MaquetteUsagers.idAleatoire();
        }           

        if(args.length > 1) {
            prenom = args[1];
        }else {
            prenom = MaquetteUsagers.prenomAleatoire();
        }

        if(args.length > 2) {
            nom = args[2];
        }else {
            nom = MaquetteUsagers.nomAleatoire();
        }

        usagerCourant = new Joueur(id, prenom, nom);
    }

}