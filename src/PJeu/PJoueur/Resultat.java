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
        boolean checkScore = this.checkSiScore(nomJeu);
        if (checkScore) {
            return this.a_score.get(nomJeu);
        } else {
            return null;
        }

    }

    public Integer getLastScore(String nomJeu) {
        boolean checkScore = this.checkSiScore(nomJeu);
        if (checkScore) {
            Integer nombreScore = this.a_score.get(nomJeu).size();
            return this.a_score.get(nomJeu).get(nombreScore - 1);
        } else {
            return null;
        }
    }

    public void addScore(String nomJeu, Integer newScore) {
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

    public void addJeu(String nomJeu) {
        List<Integer> score = new ArrayList<>();
        this.a_score.put(nomJeu, score);
    }

    public void afficher() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
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
        return !(this.a_score.get(nomJeu) == null);
    }

    private boolean checkSiScore(String nomJeu) {
        boolean checkJeu = this.checkSiJeu(nomJeu);
        if (checkJeu) {
            return this.a_score.get(nomJeu).size()>0;
        } else {
            return checkJeu;
        }
    }
}
