package BD;

import java.sql.SQLException;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.runnable;

/**
 * Created by QUENTIN on 16/06/2017.
 */
public class ThreadAddPlayer extends Thread implements Runnable {

    String joueurs[] = new String[4];

    public ThreadAddPlayer(String players[]){
        joueurs=players;
    }

    @Override
    public void run() {
        try {
            for(int i=0; i<joueurs.length; i++){
                if (!BaseDeDonees.playerexist(joueurs[i]) && joueurs[i] != null) {
                    BaseDeDonees.Add_player(joueurs[i]);
                }
            }
        } catch (SQLException e1) {e1.printStackTrace();}
    }
}
