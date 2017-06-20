package MC;

import java.awt.*;

/**
 * Created by tatane on 17/06/2017.
 */
public class Joueur {

    private String nom;
    private Color couleur;
    private int nbPionPoussé;

    public Joueur()
    {
        nbPionPoussé=0;
    }

    public Joueur(String nom, Color col)
    {
        this.nom=nom;
        this.couleur=col;
        nbPionPoussé=0;
    }

    public void incrementPoussee()
    {
        nbPionPoussé++;
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

    public int getNbPionPoussé() {
        return nbPionPoussé;
    }

    public void setNbPionPoussé(int nbPionPoussé) {
        this.nbPionPoussé = nbPionPoussé;
    }
}
