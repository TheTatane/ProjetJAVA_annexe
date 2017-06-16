package BD;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 16/06/2017.
 */
public class ThreadSavePartie extends Thread implements Runnable {

    private String vainqueur;
    private ArrayList<String> joueurs;

    public ThreadSavePartie(String victorious, ArrayList<String> players){
        vainqueur=victorious;
        joueurs=players;
    }
    @Override
    public void run() {
        try {
            BaseDeDonees.insererPartie("Dame Chinoise", joueurs.size(), vainqueur);
            BaseDeDonees.updateWin(vainqueur);
            int ID_PARTIE = BaseDeDonees.getLastIDPartie();
            for(String joueurLoose : joueurs){
                if(joueurLoose != vainqueur) {
                    BaseDeDonees.updateLoose(joueurLoose);
                    BaseDeDonees.insererPerdant(ID_PARTIE, joueurLoose);
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
