package PJeuCarte;

import PCarte.Carte;
import PCarte.Couleur;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MoteurDeJeuCarte {

    private List<Carte> a_cartes;
    private List<Carte> a_cartes2;

    MoteurDeJeuCarte(JeuCarte jeuCarte) {
        a_cartes = new ArrayList<>();
        for (int i = 1; i < 14; i++) {
            String value;
            if (i == 13) {
                value = "Roi";
            } else if (i == 12) {
                value = "Reine";
            } else if (i == 11) {
                value = "Valet";
            } else {
                value = Integer.toString(i);
            }
            Carte carte1 = new Carte(value, Couleur.PIQUE);
            Carte carte2 = new Carte(value, Couleur.COEUR);
            Carte carte3 = new Carte(value, Couleur.CARREAU);
            Carte carte4 = new Carte(value, Couleur.TREFLE);
            a_cartes.add(carte1);
            a_cartes.add(carte2);
            a_cartes.add(carte3);
            a_cartes.add(carte4);
        }

        a_cartes2 = new ArrayList<>();
        Carte carte1 = new Carte("2", Couleur.PIQUE);
        Carte carte2 = new Carte("3", Couleur.COEUR);
        Carte carte3 = new Carte("4", Couleur.CARREAU);
        Carte carte4 = new Carte("5", Couleur.TREFLE);
        Carte carte5 = new Carte("6", Couleur.CARREAU);
        Carte carte6 = new Carte("7", Couleur.TREFLE);
        a_cartes2.add(carte1);
        a_cartes2.add(carte2);
        a_cartes2.add(carte3);
        a_cartes2.add(carte4);
    }


    public void jouer(String nomJeu) {
        if (nomJeu == "Bataille") {
            melangerCarte(this.a_cartes);

            JeuBataille jeuBataille = new JeuBataille(this.a_cartes, "j1", "j2");
        }
    }

    private void melangerCarte(List<Carte> cartes) {
        for (int i = 0; i < cartes.size(); i++) {
            Carte carteAMelanger = cartes.remove(cartes.size()-1);
            Random rand = new Random();
            cartes.add(rand.nextInt(0, cartes.size()), carteAMelanger);
        }
    }


}
