package View;

import MC.DameChinoise;
import MC.Jeux;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class MenuDameChinoise extends JPanel implements ActionListener {

    GridBagConstraints constraint;
    JComboBox comboBoxJoueur, comboBoxMode, comBoxColor;
    JLabel labelTitre=new JLabel();
    JTextField textJ1, textJ2, textJ3, textJ4;

    public MenuDameChinoise(){
        // UI
        this.setBackground(Color.darkGray);
        this.setLayout(new GridBagLayout());
        constraint = new GridBagConstraints();
        // LIGNE 1
        constraint.weightx=2;
        constraint.gridx=1;constraint.gridy=0;
        constraint.gridheight=1; constraint.gridwidth=1;
        labelTitre.setText(htmlTitre());
        this.add(labelTitre, constraint);
        //LIGNE 2

        constraint.weighty=1;
        constraint.gridx=0;constraint.gridy=1;
        initJcomboBoxes();
        this.add(comboBoxMode, constraint);
        constraint.gridx++;
        this.add(comboBoxJoueur, constraint);
        constraint.gridx++;
        this.add(comBoxColor, constraint);
        // LIGNE 3
        constraint.gridx=0;constraint.gridy++;
        initTextAreas();


    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public String htmlTitre(){
        return "<html> <font color='white' size='7'> Dame Chinoise </font> </html>";
    }

    public void initJcomboBoxes(){
        comboBoxJoueur=new JComboBox(new String[]{"Nombre de Joueurs", "2 joueurs", "3 joueurs", "4 joueurs"});
        comboBoxMode=new JComboBox(new String[]{"Mode de Jeu","Prise", "Classique", "IA"});
        comBoxColor=new JComboBox(new String[]{"Nombre de Couleurs/joueur","1 couleur","2 couleurs", "3 couleurs"});

    }

    public void resetJcomboBoxes(){
        comboBoxJoueur.removeAllItems();
        comboBoxJoueur.addItem("Nombre de Joueurs");
        comboBoxJoueur.addItem("2 joueurs");
        comboBoxJoueur.addItem("3 joueurs");
        comboBoxJoueur.addItem("4 joueurs");

        comBoxColor.removeAllItems();
        comBoxColor.addItem("Nombre de Couleurs/joueur");
        comBoxColor.addItem("1 couleur");
        comBoxColor.addItem("2 couleurs");
        comBoxColor.addItem("3 couleurs");
    }

    public void resetJcomboCouleur(){
        comBoxColor.removeAllItems();
        comBoxColor.addItem("Nombre de Couleurs/joueur");
        comBoxColor.addItem("1 couleur");
        comBoxColor.addItem("2 couleurs");
        comBoxColor.addItem("3 couleurs");
    }

    public void initTextAreas(){
        textJ1=new JTextField(10);textJ1.setText("J1");
        textJ2=new JTextField(10);textJ2.setText("J2");
        textJ3=new JTextField(10);textJ3.setText("J3");
        textJ4=new JTextField(10);textJ4.setText("J4");
        /*constraint.gridx=0;
        this.add(textJ1, constraint);
        constraint.gridx++;
        this.add(textJ2, constraint);
        constraint.gridx++;
        this.add(textJ3, constraint);
        constraint.gridx++;
        this.add(textJ4, constraint);*/
    }

    public void removeAllTextFields(){
        this.remove(textJ1);
        this.remove(textJ2);
        this.remove(textJ3);
        this.remove(textJ4);
    }

    public void add2TextFields(){
        removeAllTextFields();
        constraint.gridx=0;
        this.add(textJ1, constraint);
        constraint.gridx++;
        if(!comboBoxMode.getSelectedItem().equals("IA"))
            this.add(textJ2, constraint);
        else
            textJ2.setText("IA");

        updateUI();
    }

    public void add3TextFields(){
        removeAllTextFields();
        constraint.gridx=0;
        this.add(textJ1, constraint);
        constraint.gridx++;
        this.add(textJ2, constraint);
        constraint.gridx++;
        this.add(textJ3, constraint);
        updateUI();
    }

    public void add4TextFields(){
        removeAllTextFields();
        constraint.gridx=0;
        this.add(textJ1, constraint);
        constraint.gridx++;
        this.add(textJ2, constraint);
        constraint.gridx++;
        this.add(textJ3, constraint);
        constraint.gridx++;
        this.add(textJ4, constraint);
        updateUI();
    }
}
