/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.avancé;

import java.util.Iterator;

/**
 *
 * @author Nguye
 */
public class SimpleList implements Iterable<String> {

    private Noeud contenu;
    private Noeud premier;

    public Noeud getContenu() {
        return contenu;
    }

    public void setContenu(Noeud contenu) {
        this.contenu = contenu;
    }

    public SimpleList() { // crée une liste vide
        this.contenu = null;
    }

    public void addEnTete(String s) {
        this.contenu = new Noeud(s, contenu);
        this.premier = this.contenu;

    }

    public void add(String s) { //en queue 
        this.contenu.addEnFin(s);
    }

    public boolean contains(String s) {
        if (this.contenu == null) {
            this.contenu = this.premier;
            return false;
        }
        if (this.contenu.getData() == s) {
            this.contenu = this.premier;
            return true;
        } else {
            this.contenu = this.contenu.getSuivant();
            return contains(s);
        }
    }

    public void insert(int i, String s) {
        if (i == 0) {
            addEnTete(s);
        } else {
            Noeud n = new Noeud(s);
            this.contenu.insertDeNoeud(i, n);
        }
    }

    public void remove(int i) {
        this.contenu.removeDeNoeud(i, this);

    }

    public void afficher() {
        System.out.println(this.contenu.getData());
        if (this.contenu.getSuivant() == null) {
            this.contenu=this.premier;
            return;
        } else {
            this.contenu = this.contenu.getSuivant();
        }
        afficher();
    }

    // ajoute tous les éléments de la liste l à la fin de this
    public void addAll(SimpleList sl) {
        Noeud n = sl.getContenu();
        this.contenu.addAlldeNoeud(sl, n);

    }

    // retourne un itérateru qui énumère les String contenus dans la liste
    @Override
    public Iterator<String> iterator() {
        return new IteratorSimpleList(this);
    }

}

