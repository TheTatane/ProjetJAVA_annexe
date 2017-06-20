package MC;

import java.awt.*;
import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by QUENTIN on 19/05/2017.
 */
public class PlateauAbalone extends Plateau{

    private static int decalage=2;
    private static int PION_MAX=62;
    ArrayList<Color> jColor[];
    private int nbBlanc;
    private int nbNoir;

    public PlateauAbalone(/*ArrayList<Color> joueurColor[]*/) {

        //jColor=joueurColor;
        nbBlanc=14;
        nbNoir=14;
        plateau = new Case[62];
        for (int i = 0; i <= 61; i++) {
            plateau[i] = new Case(i, 0, null, null, null, null, null, null);
        }
        create_board_abalone();
        initPlateau();
        //initPlateau_TEST();
    }

    public PlateauAbalone (int nbBlanc, int nbNoir)
    {
        this.nbNoir=nbNoir;
        this.nbBlanc=nbBlanc;
        plateau = new Case[62];
        for (int i = 0; i <= 61; i++) {
            plateau[i] = new Case(i, 0, null, null, null, null, null, null);
        }
        create_board_abalone();
        initPlateau();
        //initPlateau_TEST();
    }

    public void create_board_abalone() {
        int i;
        //row 1
        for(i=1; i<=5; i++){
            if(i != 1)
                plateau[i].setGauche(plateau[i-1]);
            if(i != 5)
                plateau[i].setDroite(plateau[i+1]);
            plateau[i].setB_gauche(plateau[i+5]);
            plateau[i].setB_droite(plateau[i+6]);
        }

        //row 2
        for(i=6; i<=11; i++){
            if(i != 6) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-6]);
            }
            if(i != 11) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-5]);
            }
            plateau[i].setB_gauche(plateau[i+6]);
            plateau[i].setB_droite(plateau[i+7]);
        }
        //row 3
        for(i=12; i<=18; i++){
            if(i != 12) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-7]);
            }
            if(i != 18) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-6]);
            }
            plateau[i].setB_gauche(plateau[i+7]);
            plateau[i].setB_droite(plateau[i+8]);
        }
        //row 4
        for(i=19; i<=26; i++){
            if(i != 19) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-8]);
            }
            if(i != 26) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-7]);
            }
            plateau[i].setB_gauche(plateau[i+8]);
            plateau[i].setB_droite(plateau[i+9]);
        }
        //row 5 (MILIEU)
        for(i=27; i<=35; i++){
            if(i != 27) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i-9]);
                plateau[i].setB_gauche(plateau[i+8]);
            }
            if(i != 35) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i-8]);
                plateau[i].setB_droite(plateau[i+9]);
            }
        }
        //row 6
        for(i=36; i<=43; i++){
            if(i != 36) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i+7]);
            }
            if(i != 43) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i+8]);
            }
            plateau[i].setH_gauche(plateau[i-9]);
            plateau[i].setH_droite(plateau[i-8]);
        }
        //row 7
        for(i=44; i<=50; i++){
            if(i != 44) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i+6]);
            }
            if(i != 50) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i+7]);
            }
            plateau[i].setH_gauche(plateau[i-8]);
            plateau[i].setH_droite(plateau[i-7]);
        }
        //row 8
        for(i=51; i<=56; i++){
            if(i != 51) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i+5]);
            }
            if(i != 56) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i+6]);
            }
            plateau[i].setH_gauche(plateau[i-7]);
            plateau[i].setH_droite(plateau[i-6]);
        }
        //row 9
        for(i=57; i<=61; i++){
            if(i != 57)
                plateau[i].setGauche(plateau[i - 1]);
            if(i != 61)
                plateau[i].setDroite(plateau[i + 1]);

            plateau[i].setH_gauche(plateau[i-6]);
            plateau[i].setH_droite(plateau[i-5]);
        }
    }


    public void initPlateau()
    {
        for (int i=1;i<PION_MAX;i++)
        {
            plateau[i].getPion().setCouleur(Color.gray);
            plateau[i].setEtat(0);
        }

        for (int i=1; i<= nbNoir+decalage;i++)
        {
            if (i<=11 || i>13 )
            {
                plateau[i].getPion().setValeur(1);
                plateau[i].setEtat(1);
                plateau[i].getPion().setCouleur(Color.black);
            }
        }

        for (int i=PION_MAX-nbBlanc-decalage; i< PION_MAX; i++)
        {
            if ((i>=46 && i<=48) || i>=51)
            {
                plateau[i].getPion().setValeur(2);
                plateau[i].setEtat(1);
                plateau[i].getPion().setCouleur(Color.white);
            }
        }
    }


    public void initPlateau_TEST()
    {
        for (int i=1;i<PION_MAX;i++)
        {
            plateau[i].getPion().setCouleur(Color.gray);
        }

        for (int i=1; i<= nbNoir+decalage;i++)
        {
            if (i<=11 || i>13 )
            {
                plateau[i].getPion().setValeur(1);
                plateau[i].setEtat(1);
                plateau[i].getPion().setCouleur(Color.black);
            }
        }

        plateau[2].getPion().setValeur(0);
        plateau[2].setEtat(0);
        plateau[2].getPion().setCouleur(Color.gray);

        plateau[32].getPion().setValeur(2);
        plateau[32].setEtat(1);
        plateau[32].getPion().setCouleur(Color.white);

        plateau[41].getPion().setValeur(2);
        plateau[41].setEtat(1);
        plateau[41].getPion().setCouleur(Color.white);

        plateau[23].getPion().setValeur(2);
        plateau[23].setEtat(1);
        plateau[23].getPion().setCouleur(Color.white);


        for (int i=PION_MAX-nbBlanc-decalage; i< PION_MAX; i++)
        {
            if ((i>=46 && i<=48) || i>=51)
            {
                plateau[i].getPion().setValeur(2);
                plateau[i].setEtat(1);
                plateau[i].getPion().setCouleur(Color.white);
            }
        }
    }

    public void affiche_plateau()
    {
        int nb=4;

        for(int j = 0; j<nb;j++)
        {
            System.out.print(" ");
        }

        for(int i = 1; i < PION_MAX;i++)
        {
            if (plateau[i].getDroite() == null)
            {
                if(plateau[i].getPion().getCouleur()==Color.black)
                {
                    System.out.print("N ");
                }
                else if (plateau[i].getPion().getCouleur()==Color.white)
                {
                    System.out.print("B ");
                }
                else if (plateau[i].getEtat()==0)
                {
                    System.out.print("- ");
                }

                System.out.println("");

                nb = i<35 ? nb-1 : nb+1;

                for(int j = 0; j<nb;j++)
                {
                    System.out.print(" ");
                }
            }
            else
            {
                    if(plateau[i].getPion().getCouleur()==Color.black)
                    {
                        System.out.print("N ");
                    }
                    else if (plateau[i].getPion().getCouleur()==Color.white)
                    {
                        System.out.print("B ");
                    }
                    else if(plateau[i].getEtat()==0)
                    {
                        System.out.print("- ");
                    }
                //System.out.print(plateau[i].getPion().getValeur()+" ");
            }
        }
    }

    //Début de test pour les déplacements
    public boolean jouerCoup(int direction, ArrayList<Integer> listPion, Color couleurAdv,Joueur j)
    {
        boolean ok=false;
        int cpt,adversaire=0;
        //int score;
        //adversaire= plateau[listPion.get(0)].getPion().getValeur() == 1 ? 2 : 1;

        switch (direction)
        {
            case 1 :
                Collections.sort(listPion);
                System.out.println("debug adv : "+adversaire);

                if(plateau[listPion.get(0)].getH_gauche()!=null && plateau[listPion.get(0)].getH_gauche().getEtat() == 0 )
                {
                    decalageHautGauche(listPion);
                    System.out.println("ok h-gauche");
                    ok=true;
                }
                else if(plateau[listPion.get(0)].getH_gauche() !=null && plateau[listPion.get(0)].getH_gauche().getPion().getCouleur() == couleurAdv)
                {
                    System.out.println("adv h-gauche");
                    cpt=comptagePionAdversaireHautGauche(listPion.get(0),couleurAdv);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau[listPion.get(0)].getH_gauche().getH_gauche()!=null && plateau[listPion.get(0)].getH_gauche().getH_gauche().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau[listPion.get(0)].getH_gauche().getId();
                                plateau[id].getH_gauche().getPion().setCouleur(corpDeplacement(id));
                            }
                            else if ( plateau[listPion.get(0)].getH_gauche().getH_gauche()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau[listPion.get(0)].getH_gauche().getPion().setValeur(0);
                                plateau[listPion.get(0)].getH_gauche().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau[listPion.get(0)].getH_gauche().getH_gauche().getH_gauche()!=null && plateau[listPion.get(0)].getH_gauche().getH_gauche().getH_gauche().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau[listPion.get(0)].getH_gauche().getH_gauche().getId();
                                id2=plateau[listPion.get(0)].getH_gauche().getId();
                                plateau[id2].getH_gauche().getPion().setCouleur(corpDeplacement(id));
                                plateau[id].getH_gauche().getPion().setCouleur(corpDeplacement(id2));
                            }
                            else if ( plateau[listPion.get(0)].getH_gauche().getH_gauche().getH_gauche()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau[listPion.get(0)].getH_gauche().getPion().setValeur(0);
                                plateau[listPion.get(0)].getH_gauche().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        decalageHautGauche(listPion);
                        ok=true;
                    }
                    else
                    {
                        //poussé impossible
                    }
                }

                break;
            case 2 :
                Collections.sort(listPion);
                System.out.println("debug adv : "+adversaire);

                if(plateau[listPion.get(0)].getH_droite()!=null && plateau[listPion.get(0)].getH_droite().getEtat() == 0 )
                {
                    System.out.println("ok h-droit");
                    decalageHautDroit(listPion);
                    ok=true;
                }
                else if(plateau[listPion.get(0)].getH_droite() !=null && plateau[listPion.get(0)].getH_droite().getPion().getCouleur() == couleurAdv)
                {
                    cpt=comptagePionAdversaireHautDroit(listPion.get(0),couleurAdv);
                    System.out.println("nb pion : "+ cpt);
                    System.out.println("adv h-droit");

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau[listPion.get(0)].getH_droite().getH_droite()!=null && plateau[listPion.get(0)].getH_droite().getH_droite().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau[listPion.get(0)].getH_droite().getId();
                                plateau[id].getH_droite().getPion().setCouleur(corpDeplacement(id));
                            }
                            else if ( plateau[listPion.get(0)].getH_droite().getH_droite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau[listPion.get(0)].getH_droite().getPion().setValeur(0);
                                plateau[listPion.get(0)].getH_droite().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau[listPion.get(0)].getH_droite().getH_droite().getH_droite()!=null && plateau[listPion.get(0)].getH_droite().getH_droite().getH_droite().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau[listPion.get(0)].getH_droite().getH_droite().getId();
                                id2=plateau[listPion.get(0)].getH_droite().getId();
                                plateau[id2].getH_droite().getPion().setCouleur(corpDeplacement(id));
                                plateau[id].getH_droite().getPion().setCouleur(corpDeplacement(id2));
                            }
                            else if ( plateau[listPion.get(0)].getH_droite().getH_droite().getH_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau[listPion.get(0)].getH_droite().getPion().setValeur(0);
                                plateau[listPion.get(0)].getH_droite().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        decalageHautDroit(listPion);
                        ok=true;
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;
            case 4 :
                System.out.println("debug adv : "+adversaire);
                Collections.sort(listPion, Collections.reverseOrder());
                if(plateau[listPion.get(0)].getDroite()!=null && plateau[listPion.get(0)].getDroite().getEtat() == 0 )
                {
                    decalageDroit(listPion);
                    ok=true;
                    System.out.println("ok droit");
                }
                else if(plateau[listPion.get(0)].getDroite() !=null && plateau[listPion.get(0)].getDroite().getPion().getCouleur() == couleurAdv)
                {
                    cpt=comptagePionAdversaireDroit(listPion.get(0),couleurAdv);
                    System.out.println("nb pion : "+ cpt);
                    System.out.println("adv droit");

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau[listPion.get(0)].getDroite().getDroite()!=null && plateau[listPion.get(0)].getDroite().getDroite().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau[listPion.get(0)].getDroite().getId();
                                plateau[id].getDroite().getPion().setCouleur(corpDeplacement(id));
                            }
                            else if ( plateau[listPion.get(0)].getDroite().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau[listPion.get(0)].getDroite().getPion().setValeur(0);
                                plateau[listPion.get(0)].getDroite().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau[listPion.get(0)].getDroite().getDroite().getDroite()!=null && plateau[listPion.get(0)].getDroite().getDroite().getDroite().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau[listPion.get(0)].getDroite().getDroite().getId();
                                id2=plateau[listPion.get(0)].getDroite().getId();
                                plateau[id2].getDroite().getPion().setCouleur(corpDeplacement(id));
                                plateau[id].getDroite().getPion().setCouleur(corpDeplacement(id2));
                            }
                            else if ( plateau[listPion.get(0)].getDroite().getDroite().getDroite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau[listPion.get(0)].getDroite().getPion().setValeur(0);
                                plateau[listPion.get(0)].getDroite().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        decalageDroit(listPion);
                        ok=true;
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;

            case 6 :
                System.out.println("debug adv : "+adversaire);
                Collections.sort(listPion, Collections.reverseOrder());
                if(plateau[listPion.get(0)].getB_droite()!=null && plateau[listPion.get(0)].getB_droite().getEtat() == 0 )
                {
                    decalageBasDroit(listPion);
                    ok=true;
                    System.out.println("ok b-droit");
                }
                else if(plateau[listPion.get(0)].getB_droite() !=null && plateau[listPion.get(0)].getB_droite().getPion().getCouleur() == couleurAdv)
                {
                    cpt=comptagePionAdversaireBasDroit(listPion.get(0),couleurAdv);
                    System.out.println("nb pion : "+ cpt);

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau[listPion.get(0)].getB_droite().getDroite()!=null && plateau[listPion.get(0)].getB_droite().getB_droite().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau[listPion.get(0)].getB_droite().getId();
                                plateau[id].getB_droite().getPion().setCouleur(corpDeplacement(id));
                            }
                            else if ( plateau[listPion.get(0)].getB_droite().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau[listPion.get(0)].getB_droite().getPion().setValeur(0);
                                plateau[listPion.get(0)].getB_droite().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau[listPion.get(0)].getB_droite().getB_droite().getB_droite()!=null && plateau[listPion.get(0)].getB_droite().getB_droite().getB_droite().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau[listPion.get(0)].getB_droite().getB_droite().getId();
                                id2=plateau[listPion.get(0)].getB_droite().getId();
                                plateau[id2].getB_droite().getPion().setCouleur(corpDeplacement(id));
                                plateau[id].getB_droite().getPion().setCouleur(corpDeplacement(id2));
                            }
                            else if ( plateau[listPion.get(0)].getB_droite().getB_droite().getB_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau[listPion.get(0)].getB_droite().getPion().setValeur(0);
                                plateau[listPion.get(0)].getB_droite().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        decalageBasDroit(listPion);
                        ok=true;
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;

            case 5 :
                System.out.println("debug adv : "+adversaire);
                Collections.sort(listPion, Collections.reverseOrder());

                if(plateau[listPion.get(0)].getB_gauche().getEtat() == 0 )
                {
                    decalageBasGauche(listPion);
                    ok=true;
                    System.out.println("ok b-gauche");
                }
                else if(plateau[listPion.get(0)].getB_gauche() !=null && plateau[listPion.get(0)].getB_gauche().getPion().getCouleur() == couleurAdv)
                {
                    cpt=comptagePionAdversaireBasGauche(listPion.get(0),couleurAdv);
                    System.out.println("nb pion : "+ cpt);
                    System.out.println("adv b-gauche");

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau[listPion.get(0)].getB_gauche().getB_gauche()!=null && plateau[listPion.get(0)].getB_gauche().getB_gauche().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau[listPion.get(0)].getB_gauche().getId();
                                plateau[id].getB_gauche().getPion().setCouleur(corpDeplacement(id));
                            }
                            else if ( plateau[listPion.get(0)].getB_gauche().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau[listPion.get(0)].getB_gauche().getPion().setValeur(0);
                                plateau[listPion.get(0)].getB_gauche().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau[listPion.get(0)].getB_gauche().getB_gauche().getB_gauche()!=null && plateau[listPion.get(0)].getB_gauche().getB_gauche().getB_gauche().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau[listPion.get(0)].getB_gauche().getDroite().getId();
                                id2=plateau[listPion.get(0)].getB_gauche().getId();
                                plateau[id2].getB_gauche().getPion().setCouleur(corpDeplacement(id));
                                plateau[id].getB_gauche().getPion().setCouleur(corpDeplacement(id2));
                            }
                            else if ( plateau[listPion.get(0)].getB_gauche().getB_gauche().getB_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau[listPion.get(0)].getB_gauche().getPion().setValeur(0);
                                plateau[listPion.get(0)].getB_gauche().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        decalageBasGauche(listPion);
                        ok=true;
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;

            case 3 :
                Collections.sort(listPion);
                System.out.println("debug adv : "+adversaire);

                if(plateau[listPion.get(0)].getGauche()!=null && plateau[listPion.get(0)].getGauche().getEtat() == 0 )
                {
                    decalageGauche(listPion);
                    ok=true;
                    System.out.println("ok gauche");
                }
                else if(plateau[listPion.get(0)].getGauche() !=null && plateau[listPion.get(0)].getGauche().getPion().getCouleur() == couleurAdv)
                {
                    cpt=comptagePionAdversaireGauche(listPion.get(0),couleurAdv);
                    System.out.println("nb pion : "+ cpt);
                    System.out.println("adv gauche");

                    if(listPion.size()>cpt)
                    {
                        if(cpt==1)
                        {
                            if ( plateau[listPion.get(0)].getGauche().getGauche()!=null && plateau[listPion.get(0)].getGauche().getGauche().getEtat() == 0 )
                            {
                                System.out.println("CPT : 1 ");
                                int id;
                                id=plateau[listPion.get(0)].getGauche().getId();
                                plateau[id].getGauche().getPion().setCouleur(corpDeplacement(id));
                            }
                            else if ( plateau[listPion.get(0)].getGauche().getDroite()==null)
                            {
                                System.out.println("CPT : 1 ecrase");
                                plateau[listPion.get(0)].getGauche().getPion().setValeur(0);
                                plateau[listPion.get(0)].getGauche().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        else if (cpt==2)
                        {
                            if(plateau[listPion.get(0)].getGauche().getGauche().getGauche()!=null && plateau[listPion.get(0)].getGauche().getGauche().getGauche().getEtat() == 0)
                            {
                                System.out.println("CPT : 2 ");
                                int id=0, id2=0;
                                id=plateau[listPion.get(0)].getGauche().getGauche().getId();
                                id2=plateau[listPion.get(0)].getGauche().getId();
                                plateau[id2].getGauche().getPion().setCouleur(corpDeplacement(id));
                                plateau[id].getGauche().getPion().setCouleur(corpDeplacement(id2));
                            }
                            else if ( plateau[listPion.get(0)].getGauche().getGauche().getB_droite()==null)
                            {
                                System.out.println("CPT : 2 ecrase");
                                plateau[listPion.get(0)].getGauche().getPion().setValeur(0);
                                plateau[listPion.get(0)].getGauche().setEtat(0);
                                j.incrementPoussee();
                            }
                        }
                        decalageGauche(listPion);
                        ok=true;
                    }
                    else
                    {
                        //poussé impossible
                        System.out.println("Poussé impossible");
                    }
                }
                break;
        }

        return ok;
    }

    public Color corpDeplacement (int pion)
    {
        Color val;
        val=plateau[pion].getPion().getCouleur();
        plateau[pion].getPion().setCouleur(Color.gray);
        plateau[pion].setEtat(0);
        System.out.println("Couleur : "+val);

        return val;
    }

    public int comptagePionAdversaireHautGauche(int pion, Color couleurAdv)
    {
        int cpt=1;

        if(plateau[pion].getH_gauche().getH_gauche() !=null && plateau[pion].getH_gauche().getH_gauche().getPion().getCouleur()==couleurAdv)
        {
            cpt++;
            if(plateau[pion].getH_gauche().getH_gauche().getH_gauche() !=null && plateau[pion].getH_gauche().getH_gauche().getH_gauche().getPion().getCouleur()==couleurAdv)
            {
                cpt++;
                if(plateau[pion].getH_gauche().getH_gauche().getH_gauche().getH_gauche() !=null && plateau[pion].getH_gauche().getH_gauche().getH_gauche().getH_gauche().getPion().getCouleur()==couleurAdv)
                    cpt++;
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireHautDroit(int pion,Color couleurAdv)
    {
        int cpt=1;

        if(plateau[pion].getH_droite().getH_droite() !=null && plateau[pion].getH_droite().getH_droite().getPion().getCouleur()==couleurAdv)
        {
            cpt++;
            if(plateau[pion].getH_droite().getH_droite().getH_droite() !=null && plateau[pion].getH_droite().getH_droite().getH_droite().getPion().getCouleur()==couleurAdv)
            {
                cpt++;
                if(plateau[pion].getH_droite().getH_droite().getH_droite().getH_droite() !=null && plateau[pion].getH_droite().getH_droite().getH_droite().getH_droite().getPion().getCouleur()==couleurAdv)
                    cpt++;
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireDroit(int pion, Color couleurAdv)
    {
        int cpt=1;

        if(plateau[pion].getDroite().getDroite() !=null && plateau[pion].getDroite().getDroite().getPion().getCouleur()==couleurAdv)
        {
            cpt++;
            if(plateau[pion].getDroite().getDroite().getDroite() !=null && plateau[pion].getDroite().getDroite().getDroite().getPion().getCouleur()==couleurAdv)
            {
                cpt++;
                if(plateau[pion].getDroite().getDroite().getDroite().getDroite() !=null && plateau[pion].getDroite().getDroite().getDroite().getDroite().getPion().getCouleur()==couleurAdv)
                    cpt++;
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireBasDroit(int pion, Color couleurAdv)
    {
        int cpt=1;

        if(plateau[pion].getB_droite().getB_droite() !=null && plateau[pion].getB_droite().getB_droite().getPion().getCouleur()==couleurAdv)
        {
            cpt++;
            if(plateau[pion].getB_droite().getB_droite().getB_droite() !=null && plateau[pion].getB_droite().getB_droite().getB_droite().getPion().getCouleur()==couleurAdv)
            {
                cpt++;
                if(plateau[pion].getB_droite().getB_droite().getB_droite().getB_droite() !=null && plateau[pion].getB_droite().getB_droite().getB_droite().getB_droite().getPion().getCouleur()==couleurAdv)
                    cpt++;
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireBasGauche(int pion, Color couleurAdv)
    {
        int cpt=1;

        if(plateau[pion].getB_gauche().getB_gauche() !=null && plateau[pion].getB_gauche().getB_gauche().getPion().getCouleur()==couleurAdv)
        {
            cpt++;
            if(plateau[pion].getB_gauche().getB_gauche().getB_gauche() !=null && plateau[pion].getB_gauche().getB_gauche().getB_gauche().getPion().getCouleur()==couleurAdv)
            {
                cpt++;
                if(plateau[pion].getB_gauche().getB_gauche().getB_gauche().getB_gauche() !=null && plateau[pion].getB_gauche().getB_gauche().getB_gauche().getB_gauche().getPion().getCouleur()==couleurAdv)
                    cpt++;
            }
        }

        return cpt;
    }

    public int comptagePionAdversaireGauche(int pion, Color couleurAdv)
    {
        int cpt=1;

        if(plateau[pion].getGauche().getGauche() !=null && plateau[pion].getGauche().getGauche().getPion().getCouleur()==couleurAdv)
        {
            cpt++;
            if(plateau[pion].getGauche().getGauche().getGauche() !=null && plateau[pion].getGauche().getGauche().getGauche().getPion().getCouleur()==couleurAdv)
            {
                cpt++;
                if(plateau[pion].getGauche().getGauche().getGauche().getGauche() !=null && plateau[pion].getGauche().getGauche().getGauche().getGauche().getPion().getCouleur()==couleurAdv)
                    cpt++;
            }
        }

        return cpt;
    }


    public void decalageHautGauche(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau[pion].getH_gauche() !=null && plateau[pion].getH_gauche().getEtat() == 0)
            {
                System.out.println("ok Haut Gauche");
                plateau[pion].getH_gauche().getPion().setCouleur(corpDeplacement(pion));
                plateau[pion].getH_gauche().setEtat(1);
            }

        }
    }

    public void decalageHautDroit(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau[pion].getH_droite() !=null && plateau[pion].getH_droite().getEtat() == 0)
            {
                System.out.println("ok Haut Droit");
                plateau[pion].getH_droite().getPion().setCouleur(corpDeplacement(pion));
                plateau[pion].getH_droite().setEtat(1);
            }

        }
    }

    public void decalageDroit(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau[pion].getDroite() !=null && plateau[pion].getDroite().getEtat() == 0)
            {
                System.out.println("ok Droit");
                plateau[pion].getDroite().getPion().setCouleur(corpDeplacement(pion));
                plateau[pion].getDroite().setEtat(1);
            }

        }
    }

    public void decalageBasDroit(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau[pion].getB_droite()!=null && plateau[pion].getB_droite().getEtat() == 0)
            {
                System.out.println("ok Bas Droit");
                plateau[pion].getB_droite().getPion().setCouleur(corpDeplacement(pion));
                plateau[pion].getB_droite().setEtat(1);
            }

        }
    }

    public void decalageBasGauche(ArrayList<Integer> listPion)
    {
        for(int pion : listPion) {
            if (plateau[pion].getB_gauche() != null && plateau[pion].getB_gauche().getEtat() == 0)
            {
                System.out.println("ok Bas Gauche");
                plateau[pion].getB_gauche().getPion().setCouleur(corpDeplacement(pion));
                plateau[pion].getB_gauche().setEtat(1);

            }

        }
    }

    public void decalageGauche(ArrayList<Integer> listPion)
    {
        for (int pion : listPion) {
            if (plateau[pion].getGauche() !=null && plateau[pion].getGauche().getEtat() == 0)
            {
                System.out.println("ok Gauche");
                plateau[pion].getGauche().getPion().setCouleur(corpDeplacement(pion));
                plateau[pion].getGauche().setEtat(1);
            }

        }

    }


    public void affiche_plateau_voisin() {
        for (int i = 1; i <= plateau.length - 1; i++) {
            System.out.println("CASE :"+plateau[i].toString());
        }
    }

}
