package PJeu.PJoueur;

import java.util.*;

public class Resultat {
    // Stocke result de jeux
    // Stocker dernier score, tous les score, meilleurs score, score et date, liste score et date ?

    // Map : [nomJeu: [score1, score2], nomJeu2 : [score1, score2]]

    private Map<String, List<Integer>> a_score = new HashMap<>();

    public Resultat() {
    }

    public Integer getBestScore(String nomJeu) {
        /**
         * Renvoie le meilleur score du joueur pour le jeu mis en paramètre
         */
        boolean checkScore = this.checkSiScore(nomJeu);
        if (checkScore) {
            List<Integer> score = this.a_score.get(nomJeu);
            List<Integer> copiedScore = new ArrayList<>(score);
            Collections.sort(copiedScore, Collections.reverseOrder());
            return copiedScore.get(0);
        } else {
            return null;
        }
    }

    public List<Integer> getAllScore(String nomJeu) {
        /**
         * Renvoie une liste de tout les scores du joueur pour le jeu mis en paramètre
         */
        boolean checkScore = this.checkSiScore(nomJeu);
        if (checkScore) {
            return this.a_score.get(nomJeu);
        } else {
            return null;
        }
    }

    public Integer getLastScore(String nomJeu) {
        /**
         * Renvoie le dernier score du joueur pour le jeu mis en paramètre
         */
        boolean checkScore = this.checkSiScore(nomJeu);
        if (checkScore) {
            Integer nombreScore = this.a_score.get(nomJeu).size();
            return this.a_score.get(nomJeu).get(nombreScore - 1);
        } else {
            return null;
        }
    }

    public void addScore(String nomJeu, Integer newScore) {
        /**
         * Ajoute le score mis en paramètre pour le jeu en paramètre
         */
        boolean checkJeu = this.checkSiJeu(nomJeu);
        if (checkJeu) {
            List<Integer> score = this.a_score.get(nomJeu);
            score.add(newScore);
        } else {
            List<Integer> score = new ArrayList<>();
            score.add(newScore);
            this.a_score.put(nomJeu, score);
        }
    }

    public void afficher() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        /**
         * Renvoie l'affichage de tout les jeux ainsi que leurs score triès par ordre décroissant
         */
        String result = "";
        for (Map.Entry mapentry : a_score.entrySet()) {
            String jeu = (String) mapentry.getKey();
            List<Integer> score = (List<Integer>) mapentry.getValue();
            List<Integer> copiedScore = new ArrayList<>(score);
            Collections.sort(copiedScore, Collections.reverseOrder());
            result += "Jeu : " + jeu + ", liste des meilleurs score :\n";
            for (int i = 0; i < copiedScore.size(); i++) {
                result += "\t" + (i + 1) + " : " + copiedScore.get(i) + "\n";
            }
        }
        return result;
    }


    private boolean checkSiJeu(String nomJeu) {
        /**
         * Test si le jeu existe
         * Return :
         *      Renvoie un booléen en fonction du résultat
         */
        return !(this.a_score.get(nomJeu) == null);
    }

    private boolean checkSiScore(String nomJeu) {
        /**
         * Test si un score à été inscrit pour le jeu mis en paramètre
         * Return :
         *      Renvoie un booléen en fonction du résultat
         */
        boolean checkJeu = this.checkSiJeu(nomJeu);
        if (checkJeu) {
            return this.a_score.get(nomJeu).size()>0;
        } else {
            return checkJeu;
        }
    }
}
