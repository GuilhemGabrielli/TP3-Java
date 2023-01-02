package PJeu.PJeuCarte;

import PJeu.PJoueur.Joueur;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JeuCarte {

    private List<Joueur> a_joueur = new ArrayList<>();
    private RegleDuJeuCarte a_regle = new RegleDuJeuCarte();
    private MoteurDeJeuCarte a_moteurJeu = new MoteurDeJeuCarte();

    private Scanner sc = new Scanner(System.in);



    public void addJoueur() {
        System.out.print("Nom du nouveau joueur : ");
        String nom = sc.next();

        System.out.print("Prénom du nouveau joueur : ");
        String prenom = sc.next();

        System.out.print("Pseudo du nouveau joueur : ");
        String pseudo = sc.next();

        Joueur newJoueur = new Joueur(prenom, nom, pseudo);
        a_joueur.add(newJoueur);
        System.out.println("Joueur ajouté avec succès \n");
    }

    public RegleDuJeuCarte getRegle() {
        return this.a_regle;
    }

    JeuCarte() {
        Joueur newJ = new Joueur("prenom", "nom", "pseudo");
        this.a_joueur.add(newJ);

        String menu = String.join("\n",
            "Que souhaitez-vous faire ? : ",
            "1 - Voir les règles des différents jeux",
            "2 - Ajouter un joueur",
            "3 - Jouer",
            "4 - Stats joueur",
            "0 - Quitter",
            "Votre choix : ");

        while (true) {
            System.out.print(menu);
            String choix = sc.next();
            if (choix.equals("1")) {
                System.out.println(this.a_regle+"\n");
            } else if (choix.equals("2")) {
                this.addJoueur();
            } else if (choix.equals("3")) {
                if (this.a_joueur.size() > 0) {
                    this.jouer();
                } else {
                    System.out.println("Aucun joueur existant \n");
                }
            } else if (choix.equals("4")) {
                this.statJoueur();
            } else if (choix.equals("0")) {
                return;
            }
        }
    }

    private void statJoueur() {
        Integer idJoueur = afficherJoueur();
        Integer resultatAVoir = null;
        String menuJoueur = String.join("\n",
                "\nQue souhaitez-vous savoir ? : ",
                "1 - Tout les derniers scores",
                "2 - Les derniers scores pour un seul jeu",
                "3 - Le dernier score pour un seul jeu",
                "4 - Le meilleur score pour un seul jeu",
                "Votre choix : ");
        while (resultatAVoir == null) {
            resultatAVoir = myInputInt(menuJoueur);
            if (resultatAVoir < 1 || resultatAVoir > 4) {
                resultatAVoir = null;
            }
        }
        if (resultatAVoir != 1) {
            String jeuxAVoir = afficherJeux();
            if (resultatAVoir == 2) {
                List<Integer> bestScore = this.a_joueur.get(idJoueur).getResultat().getAllScore(jeuxAVoir);
                if (bestScore != null) {
                    String affichage = "\nScore de " + this.a_joueur.get(idJoueur).getPseudo() + " pour le jeu " + jeuxAVoir + " :\n";
                    for (int i = 0; i < bestScore.size(); i++) {
                        affichage += "\t" + (i + 1) + " : " + bestScore.get(i) + "\n";
                    }
                    System.out.println(affichage);
                } else {
                    System.out.println("\nAucun score enregistré pour ce jeu \n");
                }
            } else if (resultatAVoir == 3) {
                System.out.println("\nDernier score de "+this.a_joueur.get(idJoueur).getPseudo()+" pour le jeu "+jeuxAVoir+" : "+this.a_joueur.get(idJoueur).getResultat().getLastScore(jeuxAVoir)+"\n");
            } else {
                System.out.println("\nMeilleur score de"+this.a_joueur.get(idJoueur).getPseudo()+" pour le jeu "+jeuxAVoir+" : "+this.a_joueur.get(idJoueur).getResultat().getBestScore(jeuxAVoir)+"\n");
            }
        } else {
            System.out.println("\n"+this.a_joueur.get(idJoueur) + "\n");
        }
    }


    private Integer afficherJoueur() {
        Integer idJoueur = null;
        while (idJoueur == null) {
            String affichage = "\nListe des joueurs : \n";
            for (int i = 0; i < this.a_joueur.size(); i++) {
                affichage += (i+1) +" - "+ this.a_joueur.get(i).getPseudo() + "\n";
            }
            affichage += "Joueur : ";
            idJoueur = myInputInt(affichage);
            if (idJoueur > this.a_joueur.size() || idJoueur == 0) {
                idJoueur = null;
            }
        }
        return idJoueur-1;
    }


    private String afficherJeux() {
        Integer idJeu = null;
        List<String> nomJeux = this.a_regle.getJeux();
        while (idJeu == null) {
            String affichage = "\nJeux disponibles : \n";
            for (int i = 0; i < nomJeux.size(); i++) {
                affichage += (i+1) +" - "+ nomJeux.get(i) + "\n";
            }
            affichage += "Jeu : ";
            idJeu = myInputInt(affichage);
            if (idJeu > nomJeux.size() || idJeu == 0) {
                idJeu = null;
            }
        }
        return nomJeux.get(idJeu-1);
    }


    private void jouer() {
        Integer idJoueur = afficherJoueur();
        String nomJeu = afficherJeux();
        Integer result = a_moteurJeu.jouer(nomJeu);
        this.a_joueur.get(idJoueur).getResultat().addScore(nomJeu, result);
    }


    public Integer myInputInt(String message) {
        /**
         * Retourne un entier
         */
        System.out.print(message);
        try {
            String str = sc.next();
            int result = Integer.parseInt(str);
            if (result < 0) {
                result *= -1;
            }
            return result;
        } catch (Exception e) {
            System.out.println("Erreur, veuillez rentrer un entier. ");
            return null;
        }

    }



}
