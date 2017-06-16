package View;

import MC.Abalone;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class MenuAbalone extends JPanel {

    JButton btn;
    Abalone abalone;

    public MenuAbalone(){
        //UI
        this.setBackground(Color.darkGray);
        this.add(new JLabel("<html> <font color='white' size='7'> Abalone </font> </html>"));
    }


}
