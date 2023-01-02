package PJeu.PJeuCarte.PCarte;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Carte {

    private String a_valeur = null;
    private Couleur a_couleur = null;

    private final List<String> a_valeurPossible = new LinkedList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "Valet", "Reine", "Roi", "1"));


    private Carte() {
        this(null, null);
    }

    private boolean checkValeur(String newValeur) {
        return Arrays.asList(this.a_valeurPossible).contains(newValeur);
    }

    public Carte(Carte carte) {
        this.a_valeur = carte.a_valeur;
        this.a_couleur = carte.a_couleur;
    }

    public Carte(String valeur, Couleur couleur) {
        this.a_valeur = valeur;
        this.a_couleur = couleur;
    }

    public void afficher() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "valeur " + this.a_valeur + "\ncouleur " + this.a_couleur;
    }

    public void affecter(Carte carte) {
        this.a_valeur = carte.a_valeur;
        this.a_couleur = carte.a_couleur;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        if (obj.getClass() != this.getClass()) {
            return false;
        }

        final Carte carte = (Carte) obj;
        return (carte.a_valeur == this.a_valeur && carte.a_couleur == this.a_couleur);
    }

    public void setType(Couleur couleur) {
        this.a_couleur = couleur;
    }

    public int getValeur() {
        return this.a_valeurPossible.indexOf(this.a_valeur);
    }

    public void setValeur(String valeur) {
        this.a_valeur = valeur;
    }


}
