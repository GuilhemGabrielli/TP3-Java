package PJeu.PJeuCarte;

public class Test {


    public static void main(String[] args) {
        RegleDuJeuCarte regleDuJeuCarte = new RegleDuJeuCarte("regle bataille");
        assert regleDuJeuCarte.toString() == "regle bataille";
        //System.out.println(regleDuJeuCarte);
    }
}
