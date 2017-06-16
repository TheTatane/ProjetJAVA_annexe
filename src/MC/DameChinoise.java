package MC;

import java.awt.*;
import java.util.ArrayList;

/**
 * Created by QUENTIN on 29/04/2017.
 */
public class DameChinoise extends Jeux {

    private int nbColorByPlayer;
    /*
    CONSTRUCTEUR
     */
    public DameChinoise(int nbJoueur, int nbColor, String mode){
        this.modeJeu=mode;
        this.score=new int[nbJoueur];
        this.joueur=new ArrayList<String>();
        this.jcolor = new ArrayList[nbJoueur];
        this.nbColorByPlayer=nbColor;
        for(int i=0; i<nbJoueur; i++){
            this.jcolor[i]=new ArrayList<Color>();
        }
        this.plateau=new PlateauDC(this.jcolor, nbColorByPlayer, nbJoueur, this.modeJeu);
    }

    public DameChinoise(){
        this.modeJeu="";
        this.score=new int[2];
        this.jcolor = new ArrayList[2];
        this.joueur=new ArrayList<String>();
        this.plateau=new PlateauDC(this.jcolor, 1, 2, this.modeJeu);
    }

    public PlateauDC getPlateau() {
        return (PlateauDC)plateau;
    }

    public void tourSuivant(){
        int indexOfSuivant = (this.joueur.indexOf(this.tourJoueur))+1;
        if(indexOfSuivant==this.joueur.size())
            indexOfSuivant=0;
        this.tourJoueur = this.joueur.get(indexOfSuivant);
        if(this.tourJoueur.equals("IA") && modeJeu == "IA") {
            ia();
            tourSuivant();
        }
    }

    @Override
    public int checkVictoire() {
        if(modeJeu.equals("PRISE")){
            // On compte le nombre de pion rouge & bleu
            int countRed=0, countBlue=0;
            for(int i=1; i<=121; i++){
                if(plateau.getCase(i).getPion().getCouleur()== Color.red)
                    countRed++;
                else if(plateau.getCase(i).getPion().getCouleur()== Color.blue)
                    countBlue++;
            }
            //on verifie si tous les pions d'une couleur on été mangé
            if(countBlue==0) //tous les pions bleu mangé --> victoire j1
                return 0;
            else if(countRed==0) // tous les pions rouge mangé --> victoire j2
                return 1;
            else                // personne n'a encore gagné
                return -1;
        }
        else {
            //Pour chaque joueur
            for (int i = 0; i < joueur.size(); i++) {
                int nbColorWinRequired = jcolor[i].size();
                int nbColorWin = 0;
                // on verifie si chaque couleur est dans la branche opposé
                for (Color color : jcolor[i]) {
                    if (color.equals(Color.red)) {
                        if (victoire_br4(plateau.getCase(121)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.blue)) {
                        if (victoire_br1(plateau.getCase(1)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.pink)) {
                        if (victoire_br6(plateau.getCase(23)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.yellow)) {
                        if (victoire_br3(plateau.getCase(99)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.black)) {
                        if (victoire_br2(plateau.getCase(11)))
                            nbColorWin++;
                    }
                    if (color.equals(Color.green)) {
                        if (victoire_br5(plateau.getCase(111)))
                            nbColorWin++;
                    }
                }
                if (nbColorWinRequired == nbColorWin)
                    return i; // retourne joueur 1 ou 2 ou ...
            }
            // 0 si aucun joueur a gagne
            return -1;
        }
    }

    //parcours sous graphe de racine 1
    public boolean victoire_br1(Case c){
        if(c.getId() > 10)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.red && c.getEtat() != 0) {
                return victoire_br1(c.getB_gauche()) && victoire_br1(c.getB_droite());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 11
    public boolean victoire_br2(Case c){
        if(c.getId() == 47 || c.getId() == 37 || c.getId() == 26 || c.getId() == 14)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.green && c.getEtat() != 0) {
                return victoire_br2(c.getDroite()) && victoire_br2(c.getB_droite());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 99
    public boolean victoire_br3(Case c){
        if(c.getId() == 66 || c.getId() == 77 || c.getId() == 89 || c.getId() == 102)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.pink && c.getEtat() != 0) {
                return victoire_br3(c.getDroite()) && victoire_br3(c.getH_droite());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 121
    public boolean victoire_br4(Case c){
        if(c.getId() < 112)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.blue && c.getEtat() != 0) {
                return victoire_br4(c.getH_droite()) && victoire_br4(c.getH_gauche());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 111
    public boolean victoire_br5(Case c){
        if(c.getId() == 108 || c.getId() == 96 || c.getId() == 85 || c.getId() == 75)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.black && c.getEtat() != 0) {
                return victoire_br5(c.getGauche()) && victoire_br5(c.getH_gauche());
            }
            else{
                return false;
            }
        }
    }

    //parcours sous graphe de racine 23
    public boolean victoire_br6(Case c){
        if(c.getId() == 20 || c.getId() == 33 || c.getId() == 45 || c.getId() == 56)
            return true;
        else{
            if(c.getPion().getCouleur() != Color.yellow && c.getEtat() != 0) {
                return victoire_br6(c.getB_gauche()) && victoire_br6(c.getGauche());
            }
            else{
                return false;
            }
        }
    }

    @Override
    public String getVictoriousName() {
        return joueur.get(checkVictoire());
    }

    @Override
    public String getJoueurFromColor(Color color) {
        for(int i=0; i<jcolor.length; i++){
            for(Color c : jcolor[i]){
                if(color.equals(c))
                    return joueur.get(i);
            }
        }
        return null;
    }

    public void resetJeu(int nbJoueur, int nbColor, String mode) {
        this.modeJeu=mode;
        this.score=new int[nbJoueur];
        this.joueur=new ArrayList<String>();
        this.jcolor = new ArrayList[nbJoueur];
        this.nbColorByPlayer=nbColor;
        for(int i=0; i<nbJoueur; i++){
            this.jcolor[i]=new ArrayList<Color>();
        }
        this.plateau=new PlateauDC(this.jcolor, nbColorByPlayer, nbJoueur, this.modeJeu);
    }

    public void ia(){
        System.out.println("_________________ IA \n");
        //IA est le J2
        for(Color color : jcolor[1]){
            if(tryPlay(color))
                break;
        }
        resetChecked();
        playByMark();
        resetMark();
    }

    public boolean tryPlay(Color color){
        if(color.equals(Color.blue)){
            return playBlue(plateau.getCase(121));
        }
        if(color.equals(Color.pink)){
            return playPink(plateau.getCase(99));
        }
        if(color.equals(Color.black)){
            return playBlack(plateau.getCase(111));
        }
        return false;
    }

    // TO-DO
    // RENAME METHOD --> MARK PAWN
    public boolean playBlue(Case c){
        if(c.getPion().getCouleur() == Color.blue){
            mark(c);
        }
        if(c.getH_droite() != null && c.getH_gauche() != null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playBlue(plateau.getCase(c.getH_gauche().getId())) || playBlue(plateau.getCase(c.getH_droite().getId()));
        }
        else if(c.getH_droite() == null && c.getH_gauche() != null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playBlue(plateau.getCase(c.getH_gauche().getId()));
        }
        else if(c.getH_droite() != null && c.getH_gauche() == null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playBlue(plateau.getCase(c.getH_droite().getId()));
        }
        else{
            plateau.getCase(c.getId()).setChecked(true);
        }
        return false;
    }

    public boolean playPink(Case c){
        if(c.getPion().getCouleur() == Color.pink){
            mark(c);
        }
        if(c.getH_droite() != null && c.getDroite() != null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playPink(plateau.getCase(c.getDroite().getId())) || playPink(plateau.getCase(c.getH_droite().getId()));
        }
        else if(c.getH_droite() == null && c.getDroite() != null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playPink(plateau.getCase(c.getDroite().getId()));
        }
        else if(c.getH_droite() != null && c.getDroite() == null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playPink(plateau.getCase(c.getH_droite().getId()));
        }
        else{
            plateau.getCase(c.getId()).setChecked(true);
        }
        return false; //je met un return pour supprimer les warning lors de la compilation
    }

    public boolean playBlack(Case c){
        if(c.getPion().getCouleur() == Color.black){
            mark(c);
        }
        if(c.getH_gauche() != null && c.getGauche() != null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playBlack(plateau.getCase(c.getGauche().getId())) || playBlack(plateau.getCase(c.getH_gauche().getId()));
        }
        else if(c.getH_gauche() == null && c.getGauche() != null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playBlack(plateau.getCase(c.getGauche().getId()));
        }
        else if(c.getH_gauche() != null && c.getGauche() == null && plateau.getCase(c.getId()).isChecked() == false) {
            plateau.getCase(c.getId()).setChecked(true);
            return playBlack(plateau.getCase(c.getH_gauche().getId()));
        }
        else{
            plateau.getCase(c.getId()).setChecked(true);
        }
        return false; //je met un return pour supprimer les warning lors de la compilation
    }

    public void mark(Case c){
        Case tmp=c;
        int distanceBranche=0;

        if(c.getPion().getCouleur() == Color.blue){
            // (30)
            if(c.getId() <= 46){
                if(this.getPlateau().isSautPossible(c)) {
                    int[] saut = this.getPlateau().sauts_disponibles(c);
                    for (int i = 0; i < 6; i++) {
                        if ((saut)[i] < c.getId() - 2 && saut[i] != 0) {
                            c.setMark(30);
                        }

                    }
                }
                else if(this.getPlateau().isDeplacementPossible(c)){
                    int[] deplacements = this.getPlateau().deplacements_possibles(c);
                    for (int i = 0; i < 6; i++) {
                        if ((deplacements)[i] <= c.getId()+2 && deplacements[i] != 0) {
                            c.setMark(20);
                        }
                    }
                }
            }
            // (20)
            else if(c.getId() < 86 && c.getId() >= 47){
                c.setMark(20);
            }
            // (10)
            else if(this.getPlateau().isDeplacementPossible(c)){
                c.setMark(10);
            }
            // (0)
            else{
                c.setMark(0);
            }
        }

        if(c.getPion().getCouleur() == Color.black){
            while(  tmp.getH_gauche().getId() != 7 &&
                    tmp.getH_gauche().getId() != 8 &&
                    tmp.getH_gauche().getId() != 9 &&
                    tmp.getH_gauche().getId() != 10&&
                    tmp.getH_droite() != null) {
                distanceBranche++;
                tmp=tmp.getH_gauche();
            }

            if(this.getPlateau().isSautPossible(c)) {
                if (distanceBranche < 5) c.setMark(30);
                else if (distanceBranche < 7) c.setMark(20);
                else if (distanceBranche >= 7) c.setMark(10);
                else c.setMark(0);
            }
            else {
                if (distanceBranche < 5) c.setMark(20);
                else if (distanceBranche < 7) c.setMark(10);
                else if (distanceBranche >= 7) c.setMark(10);
                else c.setMark(0);
            }

        }
        if(c.getPion().getCouleur() == Color.pink){
            while(  tmp.getH_droite().getId() != 7 &&
                    tmp.getH_droite().getId() != 8 &&
                    tmp.getH_droite().getId() != 9 &&
                    tmp.getH_droite().getId() != 10&&
                    tmp.getH_droite() != null) {
                distanceBranche++;
                tmp=tmp.getH_droite();
            }

            if(this.getPlateau().isSautPossible(c)) {
                if (distanceBranche < 5) c.setMark(30);
                else if (distanceBranche < 7) c.setMark(20);
                else if (distanceBranche >= 7) c.setMark(10);
                else {c.setMark(0);}
            }
            else {
                if (distanceBranche < 5) c.setMark(20);
                else if (distanceBranche < 7) c.setMark(10);
                else if (distanceBranche >= 7) c.setMark(10);
                else {c.setMark(0);}
            }
        }
        System.out.println("CASE:"+c.getId()+", mark="+c.getMark());
    }

    public void printMark(){
        for(int i=1; i<=121; i++){
            System.out.println("ID : "+i+" -> "+plateau.getCase(i).getMark());
        }
    }

    public void resetMark(){
        for(int i=1; i<=121; i++)
            plateau.getCase(i).setMark(0);
    }

    public void playByMark(){
        boolean played=false;
        for (int i=1; i<=121; i++){
            // Si c'est 30, on sais que c'est forcement un saut
            if(plateau.getCase(i).getMark()==30){
                int [] saut = this.getPlateau().sauts_disponibles(plateau.getCase(i));
                for(int s=0; s<6; s++){
                    System.out.println("////////////////////////////////// pour "+plateau.getCase(i).getId()+" -> "+saut[s]);
                    if(saut[s] > 0 && !played) {
                        this.getPlateau().changePosition(plateau.getCase(i), plateau.getCase(saut[s]));
                        System.out.println("\t played "+i+" to "+saut[s]);
                        played=true;
                    }
                }
            }
            else if(plateau.getCase(i).getMark()==20){
                int [] move = this.getPlateau().deplacements_possibles(plateau.getCase(i));
                for(int s=0; s<6; s++){
                    if(move[s] > 0 && move[s] < plateau.getCase(i).getId()-2 && !played){
                        this.getPlateau().changePosition(plateau.getCase(i), plateau.getCase(move[s]));
                        System.out.println("\t played "+i+" to "+move[s]);
                        played=true;
                    }
                }
            }
            else if(plateau.getCase(i).getMark()==10){
                int [] move = this.getPlateau().deplacements_possibles(plateau.getCase(i));
                int max=121;
                for(int s=0; s<6; s++){
                    if(move[s] < max && move[s]!=0) {
                        max=move[s];
                    }
                }
                if (!played) {
                    this.getPlateau().changePosition(plateau.getCase(i), plateau.getCase(max));
                    System.out.println("\t played "+i+" to "+plateau.getCase(max).getId());
                    played=true;
                }
            }
        }
    }

    public void resetChecked(){
        for(int i=1; i<=121; i++){
            plateau.getCase(i).setChecked(false);
        }
    }


}
