package PJeu.PJeuCarte;

import java.util.*;

public class RegleDuJeuCarte {

    protected Map<String, String> a_regle = new HashMap<>();

    public void afficher(String nomJeu) {
        System.out.println(nomJeu + " : " + a_regle.get(nomJeu));
    }


    @Override
    public String toString() {
        String affichage = "";
        for (Map.Entry mapentry : a_regle.entrySet()) {
            String nomJeu = (String) mapentry.getKey();
            String regleJeu = (String) mapentry.getValue();
            affichage += nomJeu + " : " + regleJeu;
        }

        return affichage;
    }

    public List<String> getJeux() {
        List<String> jeux = new ArrayList<>();
        for (Map.Entry mapentry : a_regle.entrySet()) {
            String nomJeu = (String) mapentry.getKey();
            jeux.add(nomJeu);
        }
        return jeux;
    }

    RegleDuJeuCarte() {
        a_regle.put("Bataille", "Règle Bataille, 1 signifie victoire et 0 défaite");
    }
}
