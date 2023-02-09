package PJeu.PJeuCarte;

import PJeu.PJoueur.Joueur;

import java.util.*;


public abstract class AJeu implements IJeu {
    protected Scanner sc = new Scanner(System.in);
    protected Map<String,IRegle> a_listeRegle = null;
    protected List<Joueur> a_joueur = new ArrayList<>();


    @Override
    public IRegle getRegle(String nomJeu) {
        return this.a_listeRegle.get(nomJeu);
    }


    @Override
    public void addJoueur() {
        System.out.print("\nNom du nouveau joueur : ");
        String nom = sc.next();

        System.out.print("Prénom du nouveau joueur : ");
        String prenom = sc.next();

        System.out.print("Pseudo du nouveau joueur : ");
        String pseudo = sc.next();

        Joueur newJoueur = new Joueur(prenom, nom, pseudo);
        a_joueur.add(newJoueur);
        System.out.println("Joueur ajouté avec succès");
    }

    protected AJeu() {
        /**
         * Constructeur de AJeu ajoutant les règles du jeu de bataille
         */
        this.a_listeRegle = new HashMap<>();
        RegleDuJeuCarte regle = new RegleDuJeuCarte("1 si l'utilisateur à gagné, 0 si il perd");
        this.a_listeRegle.put("Bataille", regle);
    }
}
