package MC;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public class Abalone extends Jeux {

    /*
    CONSTRUCTEUR
     */
    public Abalone() {
        this.modeJeu="";
        this.score=new int[2];
        this.jcolor = new ArrayList[2];
        this.joueur=new ArrayList<String>();
        this.plateau=new PlateauAbalone(/*this.jcolor*/);
        listJoueur = new ArrayList<>();
    }



    @Override
    public void tourSuivant() { }

    @Override
    public int checkVictoire() {
        return 0;
    }

    @Override
    public String getVictoriousName() {
        return null;
    }

    @Override
    public String getJoueurFromColor(Color color) {
        return null;
    }

    public PlateauAbalone getPlateau() {
        return (PlateauAbalone) plateau;
    }


    /*
    GETTER & SETTER
     */


}
