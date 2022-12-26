package PJeuCarte;

public class Test {


    public static void main(String[] args) {
        JeuCarte jeuCarte = new JeuCarte();

        MoteurDeJeuCarte moteurDeJeuCarte = new MoteurDeJeuCarte(jeuCarte);

        RegleDuJeuCarte regleDuJeuCarte = new RegleDuJeuCarte();

        regleDuJeuCarte.afficher("Bataille");

        moteurDeJeuCarte.jouer("Bataille");

    }
}
