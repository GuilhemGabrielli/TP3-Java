package PJeu.PJoueur;

import java.util.ArrayList;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        // Test de la classe Joueur
        Joueur joueur1 = new Joueur("prenom", "nom", "pseudo");

        assert joueur1.getPrenom() == "prenom" : "Prénom différent";
        assert joueur1.getNom() == "nom" : "Nom différent";
        assert joueur1.getPseudo() == "pseudo" : "Pseudo différent";

        joueur1.setPrenom("prenom1");
        joueur1.setNom("nom1");
        joueur1.setPseudo("pseudo1");

        assert joueur1.getPrenom() == "prenom1" : "Prénom différent";
        assert joueur1.getNom() == "nom1" : "Nom différent";
        assert joueur1.getPseudo() == "pseudo1" : "Pseudo différent";

        System.out.println(joueur1);


        // Test de la classe Resultat
        Resultat resultat = joueur1.getResultat();

        List<Integer> scoreBataille = new ArrayList<>();
        resultat.addScore("Bataille", 15);
        scoreBataille.add(15);

        List<Integer> jeu2 = new ArrayList<>();
        resultat.addScore("Jeu 2", 2);
        jeu2.add(2);

        assert resultat.getAllScore("Balle") == null;
        assert resultat.getAllScore("Bataille").equals(scoreBataille);
        assert resultat.getBestScore("Bataille") == 15;
        assert resultat.getLastScore("Bataille") == 15;

        jeu2.add(5);
        resultat.addScore("Jeu 2", 5);

        scoreBataille.add(25);
        resultat.addScore("Bataille", 25);
        scoreBataille.add(5);
        resultat.addScore("Bataille", 5);

        assert resultat.getAllScore("Jeu 2").equals(jeu2) : "Score différent";
        assert resultat.getAllScore("Bataille").equals(scoreBataille) : "Score différent";

        assert resultat.getBestScore("Bataille") == 25 : "Meilleur score différent";
        assert resultat.getLastScore("Bataille") == 5 : "Dernier score différent";

        System.out.println(joueur1);
    }



}
