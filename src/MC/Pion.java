package MC;

import java.awt.*;

public class Pion {

    private int valeur;
    private Color couleur;

    public Pion()
    {
        couleur=null;
        valeur=0;
    }
    public Pion(Color C, int val)
    {
        couleur=C;
        valeur=val;
    }

    public Color getCouleur() {
        if(this.couleur==null){
            return Color.white;
        }
        return couleur;
    }

    public void setCouleur(Color couleur) {
        this.couleur = couleur;
    }

    public void setValeur(int val) { valeur=val; }

    public int getValeur() { return valeur; }

    @Override
    public String toString() {
        return "Pion{" +
                "couleur=" + couleur +
                '}';
    }
}
