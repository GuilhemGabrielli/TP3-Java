package PJeu.PJeuCarte;

import PJeu.PJeuCarte.PCarte.Carte;

import java.util.*;

public class JeuBataille {

    private Map<Integer, List<Carte>>  a_cartes = new HashMap<>();
    private int nbTour = 0;

    private Map<Integer, List<Carte>>  fausse = new HashMap<>();

    JeuBataille(List<Carte> cartes) {
        /**
         * Contructeur de la classe.
         * Réparti les cartes entre les 2 joueurs
         */
        System.out.print("debut");
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
        this.fausse.put(0, new ArrayList<>());
        this.fausse.put(1, new ArrayList<>());
    }

    public int lancerPartie() {
        /**
         * Fonction executant la partie jusqu'à ce qu'un des 2 joueurs n'est plus de carte
         * Return :
         *      Renvoie 1 si le gagant est le joueur, 0 si l'utilisateur a perdu
         */
        while ((this.a_cartes.get(0).size()>0 || this.fausse.get(0).size()>0) && (this.a_cartes.get(1).size()>0 || this.fausse.get(1).size()>0)) {
            nbTour++;
            Carte carte1 = retournerCarte(0);
            Carte carte2 = retournerCarte(1);
            comparerCartes(carte1, carte2);
        }
        if (this.a_cartes.get(0).size() != 0) {
            System.out.println("\nLe joueur a gagné en "+nbTour+" coups\n");
            return 1;
        } else {
            System.out.println("\nLe joueur a perdu en "+nbTour+" coups\n");
            return 0;
        }
    }

    private Carte retournerCarte(int idJoueur) {
        /**
         * Renvoie la premiere carte de la liste grâce au paramètre spécifiant le joueur
         * Return :
         *      Objet de tyoe Carte
         */
        Integer nb_carte = this.a_cartes.get(idJoueur).size();
        if (nb_carte>0) {
            return this.a_cartes.get(idJoueur).remove(0);
        } else if (this.fausse.get(idJoueur).size()>0) {
            this.a_cartes.get(idJoueur).addAll(this.fausse.get(idJoueur));
            Collections.shuffle(this.a_cartes.get(idJoueur));
            this.fausse.get(idJoueur).removeAll(this.fausse.get(idJoueur));
            return retournerCarte(idJoueur);
        } else {
            return null;
        }
        
    }

    private Integer comparerCartes(Carte carteJoueur1, Carte carteJoueur2) {
        /**
         * Fonction comparant les valeurs entre les 2 cartes en paramètres. La fonction gère aussi de façon récursive la bataille.
         * Return:
         *      Renvoie 0 si le gagnant du tout est le joueur ou 1 si c'est l'IA
         */
        Integer valeur1 = carteJoueur1.getValeur();
        Integer valeur2 = carteJoueur2.getValeur();

        Integer gagnant = null;
        List<Carte> carteAGagner = new ArrayList<>();
        carteAGagner.add(carteJoueur1);
        carteAGagner.add(carteJoueur2);
        if (valeur1 > valeur2) {
            this.fausse.get(0).addAll(carteAGagner);
            gagnant = 0;
        } else if (valeur1 < valeur2){
            this.fausse.get(1).addAll(carteAGagner);
            gagnant = 1;
        } else {
            Carte faceCacheJoueur1 = this.retournerCarte(0);
            Carte faceCacheJoueur2 = this.retournerCarte(1);
            if (faceCacheJoueur1 != null) {
                carteAGagner.add(faceCacheJoueur1);
                if (faceCacheJoueur2 != null) {
                    carteAGagner.add(faceCacheJoueur2);
                    Carte batailleJoueur1 = this.retournerCarte(0);
                    Carte batailleJoueur2 = this.retournerCarte(1);
                    if (batailleJoueur1 != null && batailleJoueur2 != null) {
                        gagnant = this.comparerCartes(batailleJoueur1, batailleJoueur2);
                        if (gagnant == 0) {
                            this.fausse.get(0).addAll(carteAGagner);
                        } else {
                            this.fausse.get(1).addAll(carteAGagner);
                        }
                    } else if (batailleJoueur1 != null){
                        carteAGagner.add(batailleJoueur1);
                        this.fausse.get(0).addAll(carteAGagner);
                        gagnant = 0;
                    } else {
                        carteAGagner.add(batailleJoueur2);
                        this.fausse.get(1).addAll(carteAGagner);
                        gagnant = 1;
                    }
                } else {
                    this.fausse.get(0).addAll(carteAGagner);
                    gagnant = 0;
                }
            } else {
                carteAGagner.add(faceCacheJoueur2);
                this.fausse.get(1).addAll(carteAGagner);
                gagnant = 1;
            }
        }
        return gagnant;
    }
}
