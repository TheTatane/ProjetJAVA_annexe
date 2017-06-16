package MC;

import java.awt.*;
import java.util.ArrayList;

import static javafx.scene.paint.Color.VIOLET;

/**
 * Created by QUENTIN on 19/05/2017.
 */
public class PlateauDC extends Plateau {



    public PlateauDC(ArrayList<Color> jc[], int nbColor, int nbJoueur, String mode){
        super(jc, mode);
        plateau = new Case[122];
        for (int i = 0; i <= 121; i++) {
            plateau[i] = new Case(i, 0, null, null, null, null, null, null);
        }
        createBoard();
        switch (nbJoueur){
            case 2:
                setPion2joueur(nbColor);break;
            case 3:
                setPion3joueur(nbColor);break;
            case 4:
                setPion4joueur();break;
            default:
                //erreur
                break;
        }
        fillBases();
    }

    public void createBoard() {
        /////////////////////////////////  TRIANGLE SOMMET ///////////////////////////////////
        //N1

        plateau[1].setB_gauche(plateau[2]);
        plateau[1].setB_droite(plateau[3]);
        //N2
        plateau[2].setDroite(plateau[3]);
        plateau[2].setB_gauche(plateau[4]);
        plateau[2].setB_droite(plateau[5]);
        plateau[2].setH_droite(plateau[1]);
        plateau[3].setGauche(plateau[2]);
        plateau[3].setB_gauche(plateau[5]);
        plateau[3].setB_droite(plateau[6]);
        plateau[3].setH_gauche(plateau[1]);
        //N3
        plateau[4].setDroite(plateau[5]);
        plateau[4].setB_gauche(plateau[7]);
        plateau[4].setB_droite(plateau[8]);
        plateau[4].setH_droite(plateau[2]);
        plateau[5].setGauche(plateau[4]);
        plateau[5].setDroite(plateau[6]);
        plateau[5].setH_gauche(plateau[2]);
        plateau[5].setH_droite(plateau[3]);
        plateau[5].setB_gauche(plateau[8]);
        plateau[5].setB_droite(plateau[9]);
        plateau[6].setH_gauche(plateau[3]);
        plateau[6].setGauche(plateau[5]);
        plateau[6].setB_gauche(plateau[9]);
        plateau[6].setB_droite(plateau[10]);


        ////////////////////////////////  CORPS ETOILE ///////////////////////////////////////
        //ETAGE 0
        int i = 0;
        for (i = 7; i < 7 + 4; i++) {
            plateau[i].setB_droite(plateau[i + 9]);
            plateau[i].setB_gauche(plateau[i + 8]);
            if (i != 10) {
                plateau[i].setH_droite(plateau[i - 3]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i != 7) {
                plateau[i].setH_gauche(plateau[i - 4]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }


        // ETAGE 1
        for (i = 11; i < 11 + 13; i++) {
            if (!est_bordure_d(i, 1)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 13]);
            }
            if (!est_bordure_g(i, 1)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 12]);
            }
        }

        plateau[15].setH_droite(plateau[7]);
        plateau[16].setH_gauche(plateau[7]);
        plateau[16].setH_droite(plateau[8]);
        plateau[17].setH_gauche(plateau[8]);
        plateau[17].setH_droite(plateau[9]);
        plateau[18].setH_gauche(plateau[9]);
        plateau[18].setH_droite(plateau[10]);
        plateau[19].setH_gauche(plateau[10]);

        // ETAGE 2
        for (i = 24; i < 24 + 12; i++) {
            if (!est_bordure_d(i, 2)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 12]);
            }
            if (!est_bordure_g(i, 2)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 11]);
            }
            plateau[i].setH_gauche(plateau[i - 13]);
            plateau[i].setH_droite(plateau[i - 12]);
        }

        // ETAGE 3
        for (i = 36; i < 36 + 11; i++) {
            if (!est_bordure_d(i, 3)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 11]);
            }

            if (!est_bordure_g(i, 3)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 10]);
            }
            plateau[i].setH_droite(plateau[i - 11]);
            plateau[i].setH_gauche(plateau[i - 12]);
        }

        // ETAGE 4
        for (i = 47; i < 47 + 10; i++) {
            if (!est_bordure_d(i, 4)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setB_droite(plateau[i + 10]);
            }

            if (!est_bordure_g(i, 4)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setB_gauche(plateau[i + 9]);
            }
            plateau[i].setH_droite(plateau[i - 10]);
            plateau[i].setH_gauche(plateau[i - 11]);
        }

        // ETAGE 5
        for (i = 57; i < 57 + 9; i++) {
            if (!est_bordure_d(i, 5)) {
                plateau[i].setDroite(plateau[i + 1]);
            }

            if (!est_bordure_g(i, 5)) {
                plateau[i].setGauche(plateau[i - 1]);
            }
            plateau[i].setH_droite(plateau[i - 9]);
            plateau[i].setH_gauche(plateau[i - 10]);
            plateau[i].setB_droite(plateau[i + 10]);
            plateau[i].setB_gauche(plateau[i + 9]);
        }

        /////////////////////////////// MILIEU CORPS /////////////////////////////////
        // ETAGE 6
        for (i = 66; i < 66 + 10; i++) {
            if (!est_bordure_d(i, 6)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 9]);
            }

            if (!est_bordure_g(i, 6)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 10]);
            }
            plateau[i].setB_droite(plateau[i + 11]);
            plateau[i].setB_gauche(plateau[i + 10]);
        }

        // ETAGE 7
        for (i = 76; i < 76 + 11; i++) {
            if (!est_bordure_d(i, 7)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 10]);
            }

            if (!est_bordure_g(i, 7)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 11]);
            }
            plateau[i].setB_droite(plateau[i + 12]);
            plateau[i].setB_gauche(plateau[i + 11]);
        }

        // ETAGE 8
        for (i = 87; i < 87 + 12; i++) {
            if (!est_bordure_d(i, 8)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 11]);
            }
            if (!est_bordure_g(i, 8)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 12]);
            }
            plateau[i].setB_droite(plateau[i + 13]);
            plateau[i].setB_gauche(plateau[i + 12]);
        }

        // ETAGE 9
        for (i = 99; i < 99 + 13; i++) {
            if (!est_bordure_d(i, 9)) {
                plateau[i].setDroite(plateau[i + 1]);
                plateau[i].setH_droite(plateau[i - 12]);
            }

            if (!est_bordure_g(i, 9)) {
                plateau[i].setGauche(plateau[i - 1]);
                plateau[i].setH_gauche(plateau[i - 13]);
            }

        }

        plateau[103].setB_droite(plateau[112]);
        plateau[104].setB_gauche(plateau[112]);
        plateau[104].setB_droite(plateau[113]);
        plateau[105].setB_gauche(plateau[113]);
        plateau[105].setB_droite(plateau[114]);
        plateau[106].setB_gauche(plateau[114]);
        plateau[106].setB_droite(plateau[115]);
        plateau[107].setB_gauche(plateau[115]);

        /////////////////////////////////  TRIANGLE BASE ///////////////////////////////////
        //ETAGE 10
        for (i = 112; i < 112 + 4; i++) {
            plateau[i].setH_droite(plateau[i - 8]);
            plateau[i].setH_gauche(plateau[i - 9]);
            if (i != 115) {
                plateau[i].setB_droite(plateau[i + 4]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i != 112) {
                plateau[i].setB_gauche(plateau[i + 3]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }

        for (i = 116; i < 116 + 3; i++) {
            plateau[i].setH_droite(plateau[i - 3]);
            plateau[i].setH_gauche(plateau[i - 4]);
            if (i != 118) {
                plateau[i].setB_droite(plateau[i + 3]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i != 116) {
                plateau[i].setB_gauche(plateau[i + 2]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }

        for (i = 119; i < 119 + 2; i++) {
            plateau[i].setH_droite(plateau[i - 2]);
            plateau[i].setH_gauche(plateau[i - 3]);
            if (i == 119) {
                plateau[i].setB_droite(plateau[i + 2]);
                plateau[i].setDroite(plateau[i + 1]);
            }
            if (i == 120) {
                plateau[i].setB_gauche(plateau[i + 1]);
                plateau[i].setGauche(plateau[i - 1]);
            }
        }
        plateau[121].setH_droite(plateau[120]);
        plateau[121].setH_gauche(plateau[119]);
    }

    public boolean est_bordure_d(int pos, int etage) {
        switch (etage) {
            case 0:
                if (pos == 10) return true;
                break;
            case 1:

                if (pos == 23) return true;
                break;
            case 2:

                if (pos == 35) return true;
                break;
            case 3:
                if (pos == 46) return true;
                break;
            case 4:
                if (pos == 56) return true;
                break;
            case 5:
                if (pos == 65) return true;
                break;
            case 6:
                if (pos == 75) return true;
                break;
            case 7:
                if (pos == 86) return true;
                break;
            case 8:
                if (pos == 98) return true;
                break;
            case 9:
                if (pos == 111) return true;
                break;
            case 10:
                if (pos == 115) return true;
                break;
        }

        return false;
    }

    public boolean est_bordure_g(int pos, int etage) {
        switch (etage) {
            case 0:
                if (pos == 7) return true;
                break;
            case 1:

                if (pos == 11) return true;
                break;
            case 2:

                if (pos == 24) return true;
                break;
            case 3:
                if (pos == 36) return true;
                break;
            case 4:
                if (pos == 47) return true;
                break;
            case 5:
                if (pos == 57) return true;
                break;
            case 6:
                if (pos == 66) return true;
                break;
            case 7:
                if (pos == 76) return true;
                break;
            case 8:
                if (pos == 87) return true;
                break;
            case 9:
                if (pos == 99) return true;
                break;
            case 10:
                if (pos == 112) return true;
                break;
        }

        return false;
    }

    public void setPion2joueur(int nb_color){

        init_rouge();joueurColor[0].add(Color.red);// j1
        init_bleu();joueurColor[1].add(Color.blue);//  j2
        switch (nb_color){
            case 2:
                init_vert();joueurColor[0].add(Color.green);// j1
                init_noir();joueurColor[1].add(Color.black);// j2
                break;
            case 3:
                init_vert();joueurColor[0].add(Color.green);// j1
                init_jaune();joueurColor[0].add(Color.yellow);// j1

                init_violet();joueurColor[1].add(Color.pink);// j2
                init_noir();joueurColor[1].add(Color.black);// j2
                break;
        }
    }

    public void setPion3joueur(int nb_color){
        init_rouge();joueurColor[0].add(Color.red);// j1
        init_violet();joueurColor[1].add(Color.pink);// j2
        init_noir();joueurColor[2].add(Color.black);//   j3
        if(nb_color == 2){
            init_vert();joueurColor[0].add(Color.green);//  j1
            init_bleu();joueurColor[1].add(Color.blue);//  j2
            init_jaune();joueurColor[2].add(Color.yellow);// j3
        }
    }

    public void setPion4joueur(){
        init_rouge();joueurColor[0].add(Color.red);
        init_bleu();joueurColor[1].add(Color.blue);
        init_violet();joueurColor[2].add(Color.pink);
        init_jaune();joueurColor[3].add(Color.yellow);
    }

    public void init_rouge(){
        // intervalle [1;10]
        for(int i=1; i<=10 ; i++){
            plateau[i].setPion(Color.red);
            plateau[i].setEtat(1);
        }
    }

    public void init_bleu(){
        // intervalle [112;121]
        for(int i=112; i<=121 ; i++){
            plateau[i].setPion(Color.blue);
            plateau[i].setEtat(1);
        }
    }

    public void init_noir(){
        // intervalle [75] U [85;86] U [96;98] U [108;111]
        plateau[75].setPion(Color.black);plateau[75].setEtat(1);
        plateau[85].setPion(Color.black);plateau[86].setPion(Color.black);plateau[85].setEtat(1);plateau[86].setEtat(1);
        plateau[96].setPion(Color.black);plateau[97].setPion(Color.black);plateau[98].setPion(Color.black);plateau[96].setEtat(1);plateau[97].setEtat(1);plateau[98].setEtat(1);
        for(int i=108; i<=111; i++){
            plateau[i].setPion(Color.black);
            plateau[i].setEtat(1);
        }

    }

    public void init_violet(){
        // intervalle [66] U [76;77] U [87;89] U [99;102]
        plateau[66].setPion(Color.pink);plateau[66].setEtat(1);
        plateau[76].setPion(Color.pink);plateau[77].setPion(Color.pink);plateau[76].setEtat(1);plateau[77].setEtat(1);
        plateau[87].setPion(Color.pink);plateau[88].setPion(Color.pink);plateau[89].setPion(Color.pink);plateau[87].setEtat(1);plateau[88].setEtat(1);plateau[89].setEtat(1);
        for(int i=99; i<=102; i++){
            plateau[i].setPion(Color.pink);
            plateau[i].setEtat(1);
        }
    }

    public void init_vert(){
        // intervalle [47] U [36;37] U [24;26] U [11;14]
        plateau[47].setPion(Color.green);plateau[47].setEtat(1);
        plateau[36].setPion(Color.green);plateau[37].setPion(Color.green);plateau[36].setEtat(1);plateau[37].setEtat(1);
        plateau[24].setPion(Color.green);plateau[25].setPion(Color.green);plateau[26].setPion(Color.green);plateau[24].setEtat(1);plateau[25].setEtat(1);plateau[26].setEtat(1);
        for(int i=11; i<=14; i++){
            plateau[i].setPion(Color.green);
            plateau[i].setEtat(1);
        }
    }

    public void init_jaune(){
        // intervalle [56] U [45;46] U [33;35] U [20;23]
        plateau[56].setPion(Color.yellow);plateau[56].setEtat(1);
        plateau[45].setPion(Color.yellow);plateau[46].setPion(Color.yellow);plateau[45].setEtat(1);plateau[46].setEtat(1);
        plateau[33].setPion(Color.yellow);plateau[34].setPion(Color.yellow);plateau[35].setPion(Color.yellow);plateau[33].setEtat(1);plateau[34].setEtat(1);plateau[35].setEtat(1);
        for(int i=20; i<=23; i++){
            plateau[i].setPion(Color.yellow);
            plateau[i].setEtat(1);
        }
    }

    public boolean changePosition(Case orig, Case dest){
        boolean playAgain=false;
        if(modeJeu=="PRISE"){
            if(isSaut(orig, dest)){
                int idJumped = getIdPionSaute(orig, dest);
                Color origColor = orig.getPion().getCouleur();
                Color jumpedColor = plateau[idJumped].getPion().getCouleur();
                if(origColor != jumpedColor){
                    plateau[idJumped].getPion().setCouleur(null);
                    plateau[idJumped].setEtat(0);
                    if(sautPossible(orig,dest))
                        playAgain=true;
                    else
                        playAgain=false;

                }
            }
        }
        orig.setEtat(0);
        dest.getPion().setCouleur(orig.getPion().getCouleur());
        dest.setEtat(1);
        orig.getPion().setCouleur(null);
        return playAgain;
    }

    public int[] sauts_disponibles(Case c){
        int i=0;
        int dispo[] =new int[6]; //tableau des cases disponibles
        if (c.getEtat()== 0){
            return dispo;
        }

        //saut à droite
        if (c.getDroite() != null){
            if (c.getDroite().getDroite() != null && c.getDroite().getDroite().getEtat() == 0 && c.getDroite().getEtat()==1){
                (dispo)[i]=c.getDroite().getDroite().getId();
                i++;
            }
        }

        //saut à gauche
        if (c.getGauche() != null){
            if (c.getGauche().getGauche() != null && c.getGauche().getGauche().getEtat() == 0  && c.getGauche().getEtat()==1){
                (dispo)[i]=c.getGauche().getGauche().getId();
                i++;
            }
        }

        //saut haut droite
        if (c.getH_droite() != null){
            if (c.getH_droite().getH_droite() != null && c.getH_droite().getH_droite().getEtat() == 0 && c.getH_droite().getEtat()==1){
                (dispo)[i]=c.getH_droite().getH_droite().getId();
                i++;
            }
        }

        //saut haut gauche
        if (c.getH_gauche() != null){
            if (c.getH_gauche().getH_gauche()!= null && c.getH_gauche().getH_gauche().getEtat() == 0 && c.getH_gauche().getEtat()==1){
                (dispo)[i]=c.getH_gauche().getH_gauche().getId();
                i++;
            }
        }

        //saut bas droite
        if (c.getB_droite() != null){
            if (c.getB_droite().getB_droite() != null && c.getB_droite().getB_droite().getEtat() == 0 && c.getB_droite().getEtat()==1){
                (dispo)[i]=c.getB_droite().getB_droite().getId();
                i++;
            }
        }

        //saut bas gauche
        if (c.getB_gauche() != null){
            if (c.getB_gauche().getB_gauche() != null && c.getB_gauche().getB_gauche().getEtat() == 0 && c.getB_gauche().getEtat()==1){
                (dispo)[i]=c.getB_gauche().getB_gauche().getId();
                i++;
            }
        }
        return dispo;
    }

    public int[] deplacements_possibles(Case c){

        int i=0;
        int dispo[] = new int[6]; //tableau des sauts+deplacement simple

        if (c.getEtat() == 0){
            return dispo;
        }

        //mouvements à droite
        if (c.getDroite() != null){
            if (c.getDroite().getEtat() == 0){
                (dispo)[i]=c.getDroite().getId();
                i++;
            }
        else if (c.getDroite().getDroite() != null && c.getDroite().getDroite().getEtat() == 0){
                (dispo)[i]=c.getDroite().getDroite().getId();
                i++;
            }
        }

        //mouvements à gauche
        if (c.getGauche() != null){
            if (c.getGauche().getEtat() == 0){
                (dispo)[i]=c.getGauche().getId();
                i++;
            }
        else if (c.getGauche().getGauche() != null && c.getGauche().getGauche().getEtat() == 0){
                (dispo)[i]=c.getGauche().getGauche().getId();
                i++;
            }
        }

        //mouvements haut droite
        if (c.getH_droite() != null){
            if (c.getH_droite().getEtat() == 0){
                (dispo)[i]=c.getH_droite().getId();
                i++;
            }
        else if (c.getH_droite().getH_droite() != null && c.getH_droite().getH_droite().getEtat() == 0){
                (dispo)[i]=c.getH_droite().getH_droite().getId();
                i++;
            }
        }

        //mouvements haut gauche
        if (c.getH_gauche() != null){
            if (c.getH_gauche().getEtat() == 0){
                (dispo)[i]=c.getH_gauche().getId();
                i++;
            }
        else if (c.getH_gauche().getH_gauche() != null && c.getH_gauche().getH_gauche().getEtat() == 0){
                (dispo)[i]=c.getH_gauche().getH_gauche().getId();
                i++;
            }
        }

        //mouvements bas droite
        if (c.getB_droite() != null){
            if (c.getB_droite().getEtat() == 0){
                (dispo)[i]=c.getB_droite().getId();
                i++;
            }
        else if (c.getB_droite().getB_droite() != null && c.getB_droite().getB_droite().getEtat() == 0){
                (dispo)[i]=c.getB_droite().getB_droite().getId();
                i++;
            }
        }

        //mouvements bas gauche
        if (c.getB_gauche() != null){
            if (c.getB_gauche().getEtat() == 0){
                (dispo)[i]=c.getB_gauche().getId();
                i++;
            }
        else if (c.getB_gauche().getB_gauche() != null && c.getB_gauche().getB_gauche().getEtat() == 0){
                (dispo)[i]=c.getB_gauche().getB_gauche().getId();
                i++;
            }
        }

        return dispo;
    }

    public boolean isSaut(Case src, Case dest){
        int sautDispo[] = sauts_disponibles(src);
        for (int i=0 ; i<6; i++){
            if ((sautDispo)[i] == dest.getId()){
                return true;
            }
        }
        return false;
    }

    public int getIdPionSaute( Case src, Case dest){
        if(isSaut(src, dest)){
            if(dest.getId() < src.getId()) {

                if(src.getGauche() != null) {
                    if (src.getGauche().getGauche() != null) {
                        if (src.getGauche().getGauche().equals(dest)) {
                            return src.getGauche().getId();
                        }
                    }
                }
                if(src.getH_gauche() != null) {
                    if (src.getH_gauche().getH_gauche() != null) {
                        if (src.getH_gauche().getH_gauche().equals(dest)) {
                            return src.getH_gauche().getId();
                        }
                    }
                }
                if(src.getH_droite() != null) {
                    if (src.getH_droite().getH_droite() != null) {
                        if (src.getH_droite().getH_droite().equals(dest)) {
                            return src.getH_droite().getId();
                        }
                    }
                }
            }

            else{
                if(src.getDroite() != null) {
                    if (src.getDroite().getDroite() != null) {
                        if (src.getDroite().getDroite().equals(dest)) {
                            return src.getDroite().getId();
                        }
                    }
                }
                if(src.getB_gauche() != null) {
                    if (src.getB_gauche().getB_gauche() != null) {
                        if (src.getB_gauche().getB_gauche().equals(dest)) {
                            return src.getB_gauche().getId();
                        }
                    }
                }
                if(src.getB_droite() != null) {
                    if (src.getB_droite().getB_droite() != null) {
                        if (src.getB_droite().getB_droite().equals(dest)) {
                            return src.getB_droite().getId();
                        }
                    }
                }
            }
        }
        return 0;
    }

    public boolean deplacementDisponible(int src, int dest){
        int dispo[] = deplacements_possibles(plateau[src]);
        for(int i=0; i<6; i++){
            if(dispo[i] == dest){
                return true;
            }
        }
        return false;
    }

    public boolean sautPossible(Case orig, Case src){
        int sautDispo[] = sauts_disponibles(src);
        for (int i=0 ; i<6; i++){
            if ((sautDispo)[i] > 0){
                return true;
            }
        }
        return false;
    }

    public boolean isSautPossible(Case c){
        int sautDispo[] = sauts_disponibles(c);
        for (int i=0 ; i<6; i++){
            if ((sautDispo)[i] > 0){
                return true;
            }
        }
        return false;
    }

    public boolean isDeplacementPossible(Case c){
        int deplacementDispo[] = deplacements_possibles(c);
        for (int i=0 ; i<6; i++){
            if ((deplacementDispo)[i] > 0){
                return true;
            }
        }
        return false;
    }


    @Override
    public void affiche_plateau() {
        for (int i = 1; i <= plateau.length - 1; i++) {
            System.out.println("CASE :"+plateau[i].toString());
        }
    }

    public void afficher_voisins_console(Case c) {
        System.out.println(c.toString());
    }

    public void fillBases(){
        int i=0;
        for(i=1; i<=10; i++){
            plateau[i].setEtat(1);
        }
        plateau[47].setEtat(1);
        plateau[36].setEtat(1);plateau[37].setEtat(1);
        plateau[24].setEtat(1);plateau[25].setEtat(1);plateau[26].setEtat(1);
        for(i=11; i<=14; i++){
            plateau[i].setEtat(1);
        }
        plateau[66].setEtat(1);
        plateau[76].setEtat(1);plateau[77].setEtat(1);
        plateau[87].setEtat(1);plateau[88].setEtat(1);plateau[89].setEtat(1);
        for(i=99; i<=102; i++){
            plateau[i].setEtat(1);
        }
        plateau[75].setEtat(1);
        plateau[85].setEtat(1);plateau[86].setEtat(1);
        plateau[96].setEtat(1);plateau[97].setEtat(1);plateau[98].setEtat(1);
        for(i=108; i<=111; i++){
            plateau[i].setEtat(1);
        }
        plateau[75].setEtat(1);
        plateau[85].setEtat(1);plateau[86].setEtat(1);
        plateau[96].setEtat(1);plateau[97].setEtat(1);plateau[98].setEtat(1);
        for(i=108; i<=121; i++){
            plateau[i].setEtat(1);
        }
        plateau[56].setEtat(1);
        plateau[45].setEtat(1);plateau[46].setEtat(1);
        plateau[33].setEtat(1);plateau[34].setEtat(1);plateau[35].setEtat(1);
        for(i=20; i<=23; i++){
            plateau[i].setEtat(1);
        }
    }
}
