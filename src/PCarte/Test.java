package PCarte;

public class Test {

    public static void main(String[] args) {
        System.out.println("Carte 1, vide");
        Carte carte1 = new Carte(null, null);

        carte1.afficher();
        carte1.setType(Couleur.PIQUE);
        carte1.setValeur("1");
        System.out.println(carte1);


        System.out.println("\nCarte 2, vide puis affectation carte 1");
        Carte carte2 = new Carte(null, null);
        carte2.affecter(carte1);
        carte2.afficher();

        assert carte1.equals(carte2) : "Carte différente";
        carte2.setValeur("2");
        assert !carte1.equals(carte2) : "Carte égale";
        carte2.setType(Couleur.CARREAU);
        assert !carte1.equals(carte2) : "Carte égale";
        carte2.afficher();


        System.out.println("\nCarte 3 avec valeur et type");
        Carte carte3 = new Carte("3", Couleur.COEUR);
        carte3.afficher();


        System.out.println("\nCarte 4, avec carte");
        Carte carte4 = new Carte(carte3);
        carte4.afficher();
        carte4.setValeur("4");
        carte4.setType(Couleur.TREFLE);
        carte4.afficher();
        assert !carte4.equals(carte1) : "Carte égale";
    }
}
