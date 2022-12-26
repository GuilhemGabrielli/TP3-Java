package PJoueur;

import java.text.MessageFormat;

public class Joueur {

    public Joueur(String prenom, String nom, String pseudo) {
        this.a_prenom = prenom;
        this.a_nom = nom;
        this.a_pseudo = pseudo;
    }

    private String a_nom;
    private String a_prenom;
    private String a_pseudo;
    private Resultat a_resultat = new Resultat();


    public void setNom(String nom) {
        this.a_nom = nom;
    }

    public String getNom() {
        return this.a_nom;
    }


    public void setPrenom(String prenom) {
        this.a_prenom = prenom;
    }

    public String getPrenom() {
        return this.a_prenom;
    }


    public void setPseudo(String pseudo) {
        this.a_pseudo = pseudo;
    }

    public String getPseudo() {
        return this.a_pseudo;
    }


    public Resultat getResultat() {
        return a_resultat;
    }


    public void afficher() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        String affichage = MessageFormat.format("Prénom : {0} \nNom : {1} \nPseudo : {2} \n", this.a_prenom, this.a_nom, this.a_pseudo);
        String resultat = this.a_resultat.toString();
        if (resultat != "") {
            affichage += resultat;
        } else {
            affichage += "Aucun score enregistré";
        }

        return affichage;
    }
}
