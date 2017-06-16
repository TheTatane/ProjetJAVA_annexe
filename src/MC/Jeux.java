package MC;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public abstract class Jeux {

    protected Plateau plateau;
    protected ArrayList<String> joueur;
    protected int score[];
    protected String modeJeu;
    protected ArrayList<Color> jcolor[];
    protected String tourJoueur;

    protected ArrayList<Joueur> listJoueur;

/*
    CONSTRUCTEUR
     */

    public Jeux() { }

    /*
        GETTER & SETTER
    */

    public ArrayList<String> getJoueur() {
        return joueur;
    }

    public int[] getScore() {
        return score;
    }

    public void setScore(int[] score) {
        this.score = score;
    }

    public String getModeJeu() {
        return modeJeu;
    }

    public void setModeJeu(String modeJeu) {
        this.modeJeu = modeJeu;
    }



    public ArrayList<Color>[] getJcolor() {
        return jcolor;
    }

    public void setJcolor(ArrayList<Color>[] jcolor) {
        this.jcolor = jcolor;
    }

    /////////////////////////////////////////////////////////////////////////////////////
    /////////////////////////////////////////////////////////////////////////////////////

    public boolean addJoueur(String nomJoueur){
        for(String n : joueur){
            if(n==nomJoueur)
                return false;
        }
        joueur.add(nomJoueur);
        return true;
    }

    public void removeJoueur(String nomJoueur){
        joueur.remove(nomJoueur);
    }

    public void removeAllJoueur(){
        for (int i=0; i<joueur.size(); i++){
            joueur.remove(i);
        }
    }

    public abstract void tourSuivant();

    public void setTourJoueur(String tourJoueur) {
        this.tourJoueur = tourJoueur;
    }

    public String getTourJoueur(){return tourJoueur;}

    public boolean pionAppartientJoueurCourant(Color color){
        int indexOfJoueur = this.joueur.indexOf(this.tourJoueur);
        System.out.println("color="+color+" / colorJcourant"+jcolor[indexOfJoueur].toString());
        for(Color c : jcolor[indexOfJoueur]){
            if(c==color)
                return true;
        }
        return false;
    }

    public abstract int checkVictoire();

    public abstract String getVictoriousName();

    public abstract String getJoueurFromColor(Color color);




    public void ajoutJoueur(Joueur j)
    {
        listJoueur.add(j);
    }

    public Color getCouleurJoueur(String nomJ)
    {
        Color color=Color.gray;

        for(int i=0;i<listJoueur.size();i++)
        {
            if(listJoueur.get(i).getNom().equals(nomJ))
                color=listJoueur.get(i).getCouleur();
        }

        return color;
    }

    /*
    METHODES POUR SAUVEGARDER AVEC BD ICI
     */

}
