package PJeu.PJeuCarte;

import PJeu.Utilitaire;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JeuCarte extends AJeu {

    private MoteurDeJeuCarte a_moteurJeu = new MoteurDeJeuCarte();
    private Utilitaire utilitaire = new Utilitaire();


    public JeuCarte() {
        super();
        /**
         * Constructeur lançant immédiatement le menu
         */
        String menu = String.join("\n",
            "\nQue souhaitez-vous faire ? : ",
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
                this.afficherRegle();
            } else if (choix.equals("2")) {
                this.addJoueur();
            } else if (choix.equals("3")) {
                if (this.a_joueur.size() > 0) {
                    this.jouer();
                } else {
                    System.out.println("Aucun joueur existant");
                }
            } else if (choix.equals("4")) {
                if (this.a_joueur.size() > 0) {
                    this.statJoueur();
                } else {
                    System.out.println("Aucun joueur existant");
                }
            } else if (choix.equals("0")) {
                System.out.println("Bye");
                return;
            }
        }
    }

    private void statJoueur() {
        /**
         * Menu permettant de demander à l'utilisateur les stats pour un joueur
         */
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
            resultatAVoir = utilitaire.myInputInt(menuJoueur);
            if (resultatAVoir < 1 || resultatAVoir > 4) {
                resultatAVoir = null;
            }
        }
        if (resultatAVoir != 1) {
            Integer idJeu = afficherJeux();
            String jeuxAVoir = getAllJeux().get(idJeu);
            if (resultatAVoir == 2) {
                List<Integer> bestScore = this.a_joueur.get(idJoueur).getResultat().getAllScore(jeuxAVoir);
                if (bestScore != null) {
                    String affichage = "\nScore de " + this.a_joueur.get(idJoueur).getPseudo() + " pour le jeu " + jeuxAVoir + " :\n";
                    for (int i = 0; i < bestScore.size(); i++) {
                        affichage += "\t" + (i + 1) + " : " + bestScore.get(i) + "\n";
                    }
                    System.out.println(affichage);
                } else {
                    System.out.println("\nAucun score enregistré pour ce jeu");
                }
            } else if (resultatAVoir == 3) {
                System.out.println("\nDernier score de "+this.a_joueur.get(idJoueur).getPseudo()+" pour le jeu "+jeuxAVoir+" : "+this.a_joueur.get(idJoueur).getResultat().getLastScore(jeuxAVoir)+"\n");
            } else {
                System.out.println("\nMeilleur score de "+this.a_joueur.get(idJoueur).getPseudo()+" pour le jeu "+jeuxAVoir+" : "+this.a_joueur.get(idJoueur).getResultat().getBestScore(jeuxAVoir)+"\n");
            }
        } else {
            System.out.println("\n"+this.a_joueur.get(idJoueur) + "\n");
        }
    }


    private Integer afficherJoueur() {
        /**
         * Menu demandant à l'utilisateur de choisir un joueur
         * Return :
         *      Renvoi l'index du joueur parmi la liste a_joueur
         */
        Integer idJoueur = null;
        while (idJoueur == null) {
            String affichage = "\nChoisir le jeu : \n";
            for (int i = 0; i < this.a_joueur.size(); i++) {
                affichage += (i+1) +" - "+ this.a_joueur.get(i).getPseudo() + "\n";
            }
            affichage += "Joueur : ";
            idJoueur = utilitaire.myInputInt(affichage);
            if (idJoueur > this.a_joueur.size() || idJoueur == 0) {
                idJoueur = null;
            }
        }
        return idJoueur-1;
    }


    private Integer afficherJeux() {
        /**
         * Menu demandant à l'utilisateur de choisir un jeu
         * Return :
         *      Renvoi l'id du jeu choisi
         */
        Integer idJeu = null;
        List<String> nomJeux = getAllJeux();
        while (idJeu == null) {
            String affichage = "\nChoisir le jeu : \n";
            for (int i = 0; i < nomJeux.size(); i++) {
                affichage += (i+1) +" - "+ nomJeux.get(i) + "\n";
            }
            affichage += "Jeu : ";
            idJeu = utilitaire.myInputInt(affichage);
            if (idJeu > nomJeux.size() || idJeu == 0) {
                idJeu = null;
            }
        }
        return idJeu-1;
    }


    public void jouer() {
        /**
         * Fonction lancant une partie selon un joueur et un jeu choisi
         */
        Integer idJoueur = afficherJoueur();
        Integer idJeu = afficherJeux();
        String nomJeu = getAllJeux().get(idJeu);
        Integer result = a_moteurJeu.jouer(nomJeu);
        this.a_joueur.get(idJoueur).getResultat().addScore(nomJeu, result);
    }

    public List<String> getAllJeux() {
        /**
         * Renvoie sous forme de liste tous les jeux disponibles
         */
        List<String> jeux = new ArrayList<>();
        for (Map.Entry mapentry : a_listeRegle.entrySet()) {
            String nomJeu = (String) mapentry.getKey();
            jeux.add(nomJeu);
        }
        return jeux;
    }


    public void afficherRegle() {
        for (Map.Entry mapentry : a_listeRegle.entrySet()) {
            String nomJeu = (String) mapentry.getKey();
            IRegle regleJeu = (IRegle) mapentry.getValue();
            System.out.println(nomJeu + " : " + regleJeu.toString());
        }

    }






}
