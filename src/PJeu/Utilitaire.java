package PJeu;

import java.util.Scanner;

public class Utilitaire {
    private Scanner sc = new Scanner(System.in);

    public Integer myInputInt(String message) {
        /**
         * Retourne un entier
         */
        while (true) {
            System.out.print(message);
            try {
                String str = sc.next();
                Integer result = Integer.parseInt(str);
                if (result < 0) {
                    result *= -1;
                }
                return result;
            } catch (Exception e) {
                System.out.println("Erreur, veuillez rentrer un entier. ");
            }
        }
    }


}
