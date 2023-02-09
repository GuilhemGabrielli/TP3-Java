package PJeu.PJeuCarte;

import java.util.*;

public class RegleDuJeuCarte implements IRegle {

    public String a_regle = "";

    @Override
    public void afficher() {
        /**
         * Affiche l'affichage de la fonction toString()
         */
        System.out.println(a_regle);
    }


    @Override
    public String toString() {
        /**
         * Renvoie l'affichage de tous les jeux ainsi que leur règle
         */
        return a_regle;
    }


    public RegleDuJeuCarte(String regle) {
        this.a_regle = regle;
    }
}
