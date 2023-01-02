package PJeu.PJeuCarte;

import PJeu.PJeuCarte.PCarte.Carte;
import PJeu.PJeuCarte.PCarte.Couleur;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MoteurDeJeuCarte {

    private List<Carte> a_cartes = new ArrayList<>();

    MoteurDeJeuCarte() {

    }


    public Integer jouer(String nomJeu) {
        if (nomJeu == "Bataille") {
            creer52Cartes();
            Collections.shuffle(this.a_cartes);
            JeuBataille jeuBataille = new JeuBataille(this.a_cartes);
            return jeuBataille.lancerPartie();
        } else {
            return null;
        }
    }

    private void creer52Cartes() {
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
            this.a_cartes.add(carte1);
            this.a_cartes.add(carte2);
            this.a_cartes.add(carte3);
            this.a_cartes.add(carte4);
        }
    }


}
