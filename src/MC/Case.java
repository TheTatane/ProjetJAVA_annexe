package MC;

import java.awt.*;

public class Case {
    private Pion pion;

    private int id;     //numero case
    private boolean checked;    //attribut pour parcours recursif
    private int etat;   //vide (0) , pas vide (1), interdit (-1)
    private int mark;  // (0) impossible, (10) peu utile, (20) cool, (30) prioritaire

    // cases voisines
    private Case droite;
    private Case gauche;
    private Case H_gauche;
    private Case H_droite;
    private Case B_gauche;
    private Case B_droite;

    public Case(int id, int etat, Case droite, Case gauche, Case h_gauche, Case b_gauche, Case h_droite, Case b_droite) {
        pion=new Pion();
        checked=false;
        this.id = id;
        this.etat = etat;
        this.droite = droite;
        this.gauche = gauche;
        H_gauche = h_gauche;
        B_gauche = b_gauche;
        H_droite = h_droite;
        B_droite = b_droite;
    }

    public Case getB_droite() {
        return B_droite;
    }

    public void setB_droite(Case b_droite) {
        B_droite = b_droite;
    }

    public Case getB_gauche() {
        return B_gauche;
    }

    public void setB_gauche(Case b_gauche) {
        B_gauche = b_gauche;
    }

    public Case getH_droite() {
        return H_droite;
    }

    public void setH_droite(Case h_droite) {
        H_droite = h_droite;
    }

    public Case getH_gauche() {
        return H_gauche;
    }

    public void setH_gauche(Case h_gauche) {
        H_gauche = h_gauche;
    }

    public Case getGauche() {
        return gauche;
    }

    public void setGauche(Case gauche) {
        this.gauche = gauche;
    }

    public Case getDroite() {
        return droite;
    }

    public void setDroite(Case droite) {
        this.droite = droite;
    }

    public Pion getPion() {
        return pion;
    }

    public void setPion(Color c) {
        this.pion.setCouleur(c);
    }

    public boolean isChecked() {
        return checked;
    }

    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public int getId() {
        return id;
    }

    public void enleverPion(){
        this.pion=new Pion();
    }

    public void setMark(int m){
        mark=m;
    }

    public int getMark(){
        return mark;
    }

    @Override
    public String toString() {
        String str="Case "+id+"\n";
        str+= "\t checked "+checked+"\n";
        str+= "\t etat"+etat+"\n";
        if(droite!=null)
            str+= "\t droite :"+droite.getId()+"\n";
        if(gauche!=null)
            str+= "\t gauche :"+gauche.getId()+"\n";
        if(H_droite!=null)
            str+= "\t H_droite :"+H_droite.getId()+"\n";
        if(H_gauche!=null)
            str+= "\t H_gauche :"+H_gauche.getId()+"\n";
        if(B_droite!=null)
            str+= "\t B_droite :"+B_droite.getId()+"\n";
        if(B_gauche!=null)
            str+= "\t B_gauche :"+B_gauche.getId()+"\n";
        return str;
    }
}
