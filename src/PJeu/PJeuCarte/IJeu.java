package PJeu.PJeuCarte;

import java.util.HashMap;
import java.util.Map;

public interface IJeu {

    public static Map<String,IRegle> a_listeRegle = new HashMap<>();

    //void setRegle(String nomJeu);

    IRegle getRegle(String nomJeu);

    void addJoueur();

    void jouer();
}
