package PJeuCarte;

import PCarte.Carte;
import PCarte.Couleur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MoteurDeJeuCarte {

    private List<Carte> a_cartes;

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
    }


    public void jouer(String nomJeu) {
        if (nomJeu == "Bataille") {
            Collections.shuffle(this.a_cartes);
            JeuBataille jeuBataille = new JeuBataille(this.a_cartes, "j1", "j2");
        }
    }


}
