/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.avancé;

/**
 *
 * @author Nguye
 */
public class Noeud {

    private String data;
    private Noeud suivant;

    public Noeud(String data, Noeud suivant) {
        this.data = data;
        this.suivant = suivant;
    }

    public Noeud(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Noeud getSuivant() {
        return suivant;
    }

    public void setSuivant(Noeud suivant) {
        this.suivant = suivant;
    }

    public void addEnFin(String s) {
        if (this.suivant == null) {
            this.suivant = new Noeud(s);
        } else {
            this.suivant.addEnFin(s);
        }
    }

    public void insertDeNoeud(int i, Noeud n) {
        Noeud n2 = this;
        for (int j = 1; j < i; j++) {
            n2 = n2.suivant;
        }
        n.suivant = n2.suivant;
        n2.suivant = n;
    }

    public void removeDeNoeud(int i, algo.avancé.SimpleList sl) {
        if (i == 0) {
            sl.setContenu(this.suivant);
        } else {
            Noeud n = this;
            for (int j = 1; j < i; j++) {
                n = n.suivant;
            }
            n.suivant = n.suivant.suivant;
        }
    }

    public void addAlldeNoeud(SimpleList l, Noeud n) {
        if (this.suivant == null) {
            this.suivant = n;
        } else {
            this.suivant.addAlldeNoeud(l, n);
        }
    }

}
