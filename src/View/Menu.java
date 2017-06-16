package View;

import MC.Abalone;
import MC.DameChinoise;
import MC.Jeux;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static java.awt.SystemColor.menu;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class Menu extends JPanel implements ActionListener{

    MenuAbalone menuAbalone;
    MenuDameChinoise menuDameChinoise;

    JButton bSuivant=new JButton("SUIVANT");
    CardLayout cardLayout = new CardLayout();
    JPanel panelCard;
    BoutonJouer bJouer= new BoutonJouer();

    // Parametre de jeu
    int nbJoueur=0, nbColor=0;
    String mode=null;
    String  joueurs[]=new String[4];

    //////////////////////////////////////////////

    public Menu(){
        for(int i=0; i<4; i++){
            joueurs[i]=null;
        }
        //UI
        menuAbalone = new MenuAbalone();
        menuDameChinoise = new MenuDameChinoise();
        this.setLayout(new BorderLayout());
        panelCard = new JPanel();
        panelCard.setLayout(cardLayout);
        bSuivant.addActionListener(this);
        panelCard.add(menuAbalone);
        panelCard.add(menuDameChinoise);
        this.add(bSuivant, BorderLayout.WEST);
        this.add(panelCard, BorderLayout.CENTER);
        this.add(bJouer, BorderLayout.SOUTH);

        // listeners
        menuDameChinoise.comboBoxMode.addActionListener(this);
        menuDameChinoise.comBoxColor.addActionListener(this);
        menuDameChinoise.comboBoxJoueur.addActionListener(this);
        setListenerTextFields();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        Object obj = e.getSource();

        if(obj == bSuivant){
            cardLayout.next(panelCard);
        }

        if(menuDameChinoise.comboBoxJoueur == obj){
            String strNbJoueur = (String)menuDameChinoise.comboBoxJoueur.getSelectedItem();
            if(strNbJoueur!= null) {
                switch (strNbJoueur) {
                    case "2 joueurs":
                        menuDameChinoise.resetJcomboCouleur();
                        menuDameChinoise.add2TextFields();
                        nbJoueur=2;
                        break;
                    case "3 joueurs":
                        menuDameChinoise.comBoxColor.removeItem("3 couleurs");
                        menuDameChinoise.add3TextFields();
                        nbJoueur=3;
                        break;
                    case "4 joueurs":
                        menuDameChinoise.comBoxColor.removeItem("3 couleurs");
                        menuDameChinoise.comBoxColor.removeItem("2 couleurs");
                        menuDameChinoise.add4TextFields();
                        nbJoueur=4;
                }
            }
        }

        if(menuDameChinoise.comboBoxMode == obj){
            String strMode = (String)menuDameChinoise.comboBoxMode.getSelectedItem();
            switch (strMode){
                case "Prise":
                    menuDameChinoise.resetJcomboBoxes();
                    mode="PRISE";
                    break;
                case "Classique":
                    menuDameChinoise.resetJcomboBoxes();
                    mode="";
                    break;
                case "IA":
                    menuDameChinoise.comboBoxJoueur.removeItem("3 joueurs");
                    menuDameChinoise.comboBoxJoueur.removeItem("4 joueurs");
                    mode="IA";
                    break;
            }
        }

        if(menuDameChinoise.comBoxColor == obj){
            String strNbColor = (String)menuDameChinoise.comBoxColor.getSelectedItem();
            if(strNbColor!= null) {
                switch (strNbColor) {
                    case "1 couleur":
                        nbColor = 1;
                        break;
                    case "2 couleurs":
                        nbColor = 2;
                        break;
                    case "3 couleurs":
                        nbColor = 3;
                        break;
                }
            }
        }
    }

    public void setListenerTextFields(){
        menuDameChinoise.textJ1.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {}
            public void removeUpdate(DocumentEvent e) { joueurs[0]=menuDameChinoise.textJ1.getText(); }
            public void insertUpdate(DocumentEvent e) { joueurs[0]=menuDameChinoise.textJ1.getText();}
        });
        menuDameChinoise.textJ2.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {}
            public void removeUpdate(DocumentEvent e) { joueurs[1]=menuDameChinoise.textJ2.getText();}
            public void insertUpdate(DocumentEvent e) { joueurs[1]=menuDameChinoise.textJ2.getText();}
        });
        menuDameChinoise.textJ3.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {}
            public void removeUpdate(DocumentEvent e) { joueurs[2]=menuDameChinoise.textJ3.getText();}
            public void insertUpdate(DocumentEvent e) { joueurs[2]=menuDameChinoise.textJ3.getText();}
        });
        menuDameChinoise.textJ4.getDocument().addDocumentListener(new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {}
            public void removeUpdate(DocumentEvent e) { joueurs[3]=menuDameChinoise.textJ4.getText();}
            public void insertUpdate(DocumentEvent e) { joueurs[3]=menuDameChinoise.textJ4.getText();}
        });
    }

}
