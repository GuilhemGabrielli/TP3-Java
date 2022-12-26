package PJeuCarte;

import PCarte.Carte;

import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JeuBataille {

    private Map<Integer, List<Carte>>  a_cartes = new HashMap<>();
    private int size0;
    private int size1;

    JeuBataille(List<Carte> cartes, String joueur1, String joueur2) {
        List<Carte> sousListe0 = cartes.subList(0, 26);
        List<Carte> sousListe1 = cartes.subList(26,52);

        this.a_cartes.put(0, new ArrayList<>());
        for (Carte carte:sousListe0 ) {
            this.a_cartes.get(0).add(carte);
        }

        this.a_cartes.put(1, new ArrayList<>());
        for (Carte carte:sousListe1 ) {
            this.a_cartes.get(1).add(carte);
        }


        while (this.a_cartes.get(0).size()>0 && this.a_cartes.get(1).size()>0) {
            System.out.println("\ndebut tout");
            System.out.println(this.a_cartes.get(0).size());
            System.out.println(this.a_cartes.get(1).size());
            System.out.println(this.a_cartes.get(0).size()>0 && this.a_cartes.get(1).size()>0);

            Carte carte1 = retournerCarte(0);
            Carte carte2 = retournerCarte(1);

            comparerCartes(carte1, carte2);

        }

        if (this.a_cartes.get(0).size() != 0) {
            System.out.println("j1 à gagné");
        } else {
            System.out.println("j2 à gagné");
        }

    }

    private Carte retournerCarte(int idJoueur) {
        Integer nb_carte = this.a_cartes.get(idJoueur).size();
        if (nb_carte>0) {
            return this.a_cartes.get(idJoueur).remove(nb_carte-1);
        } else {
            return null;
        }
        
    }

    private Integer comparerCartes(Carte carteJoueur1, Carte carteJoueur2) {
        Integer valeur1 = carteJoueur1.getValeur();
        System.out.println("valeur1 "+valeur1);
        Integer valeur2 = carteJoueur2.getValeur();
        System.out.println("valeur2 "+valeur2);

        System.out.println(carteJoueur1);
        System.out.println(carteJoueur2);

        Integer gagnant = null;
        if (valeur1 > valeur2) {
            System.out.println("ava1");
            this.a_cartes.get(0).add(0, carteJoueur1);
            this.a_cartes.get(0).add(0, carteJoueur2);
            gagnant = 0;
        } else if (valeur1 < valeur2){
            System.out.println("ava2");
            this.a_cartes.get(1).add(0, carteJoueur1);
            this.a_cartes.get(1).add(0, carteJoueur2);
            gagnant = 1;
        } else {
            System.out.println("else");
            Carte faceCacheJoueur1 = this.retournerCarte(0);
            Carte faceCacheJoueur2 = this.retournerCarte(1);
            Carte batailleJoueur1 = this.retournerCarte(0);
            Carte batailleJoueur2 = this.retournerCarte(1);
            
            if (batailleJoueur1 != null && batailleJoueur2 != null) {
                System.out.println("bataille");
                int resultBataille = this.comparerCartes(batailleJoueur1, batailleJoueur2);
                if (resultBataille == 0) {
                    this.a_cartes.get(0).add(0, carteJoueur1);
                    this.a_cartes.get(0).add(0, carteJoueur2);
                    this.a_cartes.get(0).add(0,faceCacheJoueur1);
                    this.a_cartes.get(0).add(0,faceCacheJoueur2);
                    gagnant = 0;
                } else {
                    this.a_cartes.get(1).add(0, carteJoueur1);
                    this.a_cartes.get(1).add(0, carteJoueur2);
                    this.a_cartes.get(1).add(0,faceCacheJoueur1);
                    this.a_cartes.get(1).add(0,faceCacheJoueur2);
                    gagnant = 1;
                }  
            } else if (batailleJoueur1 != null) {
                this.a_cartes.get(0).add(0, carteJoueur1);
                this.a_cartes.get(0).add(0, carteJoueur2);
                this.a_cartes.get(0).add(0,faceCacheJoueur1);
                this.a_cartes.get(0).add(0,faceCacheJoueur2);
                this.a_cartes.get(0).add(0,batailleJoueur1);
                gagnant = 0;
            } else if (batailleJoueur2 != null) {
                this.a_cartes.get(1).add(0, carteJoueur1);
                this.a_cartes.get(1).add(0, carteJoueur2);
                this.a_cartes.get(1).add(0,faceCacheJoueur1);
                this.a_cartes.get(1).add(0,faceCacheJoueur2);
                this.a_cartes.get(1).add(0,batailleJoueur2);
                gagnant = 1;
            } else if (faceCacheJoueur1 != null && faceCacheJoueur2 != null) {
                gagnant = this.comparerCartes(faceCacheJoueur1, faceCacheJoueur2);
            } else if (faceCacheJoueur1 != null) {
                this.a_cartes.get(0).add(0, carteJoueur1);
                this.a_cartes.get(0).add(0, carteJoueur2);
                this.a_cartes.get(0).add(0,faceCacheJoueur1);
                gagnant = 0;
            } else {
                this.a_cartes.get(1).add(0, carteJoueur1);
                this.a_cartes.get(1).add(0, carteJoueur2);
                this.a_cartes.get(1).add(0,faceCacheJoueur2);
                gagnant = 1;
            }
        }
        return gagnant;
    }
}
