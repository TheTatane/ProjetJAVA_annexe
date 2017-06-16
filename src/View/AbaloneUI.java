package View;

import MC.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 02/05/2017.
 */
public class AbaloneUI extends JPanel implements ActionListener {


    ArrayList<Integer> listeSymboleHex = new ArrayList<Integer>();
    Plateau plateau;
    Abalone game;

    //Buttons
    JButton tabbutton[] = new JButton[63];
    JButton btnDirection[] = new JButton[6];

    //Panels
    JPanel panelGlobal;
    JPanel panelJeu;
    JPanel panelInfoJeu;
    JPanel panelInfo;
    JPanel panelDirection;
    JPanel panelbtnDirection;

    //Police
    Font policeTitle;
    Font policeText;

    //Labels
    JLabel labelTitle;
    JLabel labelTitle2;
    JLabel labelPionPousseJ1;
    JLabel labelPionPousseJ2;




    public AbaloneUI(Abalone jeu) {

        game = jeu;
        //this.setBackground(new Color(255, 208, 186, 137));
        //this.setLayout(new GridBagLayout());
        this.setLayout(new BorderLayout());

        //Initialisation des caractères Hex
        listeSymboleHex.add(0x2196); //HautGauche
        listeSymboleHex.add(0x2197); //HautDroit
        listeSymboleHex.add(0x2190); //Gauche
        listeSymboleHex.add(0x2192); //Droit
        listeSymboleHex.add(0x2199); //BasGacuhe
        listeSymboleHex.add(0x2198); //BasDroit

        //Police
        policeTitle = new Font("Arial", Font.BOLD, 20);
        policeText = new Font("Arial",Font.BOLD, 12);

        //Label
        labelTitle = new JLabel("Informations de la partie");
        labelTitle.setFont(policeTitle);
        labelTitle.setHorizontalAlignment(JLabel.CENTER);
        labelTitle.setPreferredSize(new Dimension(300,30));

        labelTitle2 = new JLabel("Directions");
        labelTitle2.setFont(policeTitle);
        labelTitle2.setHorizontalAlignment(JLabel.CENTER);
        labelTitle2.setPreferredSize(new Dimension(300,30));

        labelPionPousseJ1 = new JLabel("Blanc : Nonbre de pions poussés ");
        labelPionPousseJ1.setFont(policeText);
        labelPionPousseJ1.setHorizontalAlignment(JLabel.CENTER);
        labelPionPousseJ1.setPreferredSize(new Dimension(250,30));

        labelPionPousseJ2 = new JLabel("Noir : Nonbre de pions poussés ");
        labelPionPousseJ2.setFont(policeText);
        labelPionPousseJ2.setHorizontalAlignment(JLabel.CENTER);
        labelPionPousseJ2.setPreferredSize(new Dimension(250,30));

        panelGlobal = new JPanel(new BorderLayout());
        panelJeu = new JPanel(new GridBagLayout());
        panelJeu.setBackground(new Color(255, 208, 186, 137));
        panelInfoJeu = new JPanel(new BorderLayout());
        panelInfoJeu.setBackground(new Color(255, 208, 186, 137));

        panelInfo = new JPanel(new BorderLayout());

        panelDirection = new JPanel(new BorderLayout());
        panelDirection.setBackground(new Color(255, 208, 0, 137));

        panelbtnDirection = new JPanel(new GridLayout(3,2));
        panelbtnDirection.setBackground(new Color(255, 208, 0, 137));

        plateau = game.getPlateau();


        for (int i = 1; i < 62; i++) {
            tabbutton[i] = new JButton();
            tabbutton[i].setPreferredSize(new Dimension(20, 20));
            tabbutton[i].setBorder(new RoundedBorder(50));
            tabbutton[i].setBackground(Color.darkGray);
            tabbutton[i].setForeground(plateau.getPlateau()[i].getPion().getCouleur());
            tabbutton[i].setName(Integer.toString(i));
        }

        for (int i = 0; i < 6; i++) {
            btnDirection[i] = new JButton();
            btnDirection[i].setPreferredSize(new Dimension(30, 30));
            btnDirection[i].setBackground(Color.darkGray);
            btnDirection[i].setName(Integer.toString(i));
            btnDirection[i].setText(Character.toString((char) (int)Integer.valueOf(listeSymboleHex.get(i))));
        }

        affichePlateau();
        panelDirection.add(labelTitle2,BorderLayout.NORTH);

        for(int i=0;i<6;i++)
        {
            panelbtnDirection.add(btnDirection[i]);
        }

        panelDirection.add(panelbtnDirection,BorderLayout.CENTER);

        JPanel panel1 = new JPanel();
        panel1.setBackground(new Color(255, 208, 186, 137));
        panel1.add(labelPionPousseJ1);
        JPanel panel2 = new JPanel();
        panel2.setBackground(new Color(255, 208, 186, 137));
        panel2.add(labelPionPousseJ2);

        panelInfo.add(panel1,BorderLayout.NORTH);
        panelInfo.add(panel2, BorderLayout.CENTER);

        panelInfoJeu.add(labelTitle, BorderLayout.NORTH);
        panelInfoJeu.add(panelInfo, BorderLayout.CENTER);
        panelInfoJeu.add(panelDirection, BorderLayout.SOUTH);
        panelGlobal.add(panelJeu, BorderLayout.CENTER);
        panelGlobal.add(panelInfoJeu, BorderLayout.EAST);
        this.add(panelGlobal, BorderLayout.CENTER);
    }

        public void affichePlateau()
        {
            GridBagConstraints constraint = new GridBagConstraints();
            constraint.gridx=5;constraint.gridy=4;
            constraint.gridheight=1; constraint.gridwidth=1;
            constraint.ipadx=8; constraint.ipady=8;

            int taille=4, ligne=0;
            for(int i=1; i< 62 ; i++)
            {
                tabbutton[i].setText(Integer.toString(i));

                if(plateau.getPlateau()[i].getDroite() == null)
                {
                    tabbutton[i].addActionListener(this);
                    panelJeu.add(tabbutton[i], constraint);

                    if (i<34 )
                    {
                        constraint.gridy += 1;
                        constraint.gridx = taille-ligne;
                    }
                    else
                    {
                        constraint.gridy += 1;
                        constraint.gridx = ligne;
                    }
                     ligne = i == 26 ? 2 : ligne+1;
                }
                else
                {
                    tabbutton[i].addActionListener(this);
                    panelJeu.add(tabbutton[i], constraint);
                    constraint.gridx += 2;
                }
            }
        }

    /*

    public AbaloneUI(Plateau p){
        this.setBackground(Color.black);
        //draw grid ?
    }

    public void draw(Plateau p){
        System.out.println("Abalone draw");
    }

    */

    @Override
    public void actionPerformed(ActionEvent e) {


    }
}
