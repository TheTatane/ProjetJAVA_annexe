package MC;


import java.awt.*;
import java.util.ArrayList;

public abstract class Plateau {

    protected Case plateau[];
    protected ArrayList<Color> joueurColor[];
    protected String modeJeu;

    public Plateau(ArrayList<Color> jc[], String mode) {
        joueurColor=jc;
        modeJeu=mode;
    }

    public Plateau(){}

    public abstract void affiche_plateau();

    public Case[] getPlateau() {
        return plateau;
    }

    public Case getCase(int i){
        return plateau[i];
    }

}