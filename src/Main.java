import MC.*;
import View.Fenetre;

import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main (String[] args){

        Fenetre f = new Fenetre();
        DameChinoise d = new DameChinoise(2, 3, "IA");
        Abalone AB = new Abalone();
        //d.getPlateau().affiche_plateau();
        AB.getPlateau(). affiche_plateau_voisin();


    }
}
