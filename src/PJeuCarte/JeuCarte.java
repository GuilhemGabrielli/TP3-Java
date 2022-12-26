package PJeuCarte;

import PJoueur.Joueur;

public class JeuCarte {

    private Joueur a_joueur;
    private RegleDuJeuCarte a_regle;
    private MoteurDeJeuCarte a_moteurJeu;



    public void addJoueur(Joueur newJoueur) {
        this.a_joueur = newJoueur;
    }

    public RegleDuJeuCarte getRegle() {
        return this.a_regle;
    }

    JeuCarte() {

    }

}
