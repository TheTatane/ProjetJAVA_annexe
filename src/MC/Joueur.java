package MC;

import java.awt.*;

/**
 * Created by tatane on 17/06/2017.
 */
public class Joueur {

    private String nom;
    private Color couleur;

    public Joueur()
    {

    }

    public Joueur(String nom, Color col)
    {
        this.nom=nom;
        this.couleur=col;
    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Color getCouleur() {
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }
}
