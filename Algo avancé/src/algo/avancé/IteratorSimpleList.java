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
public class IteratorSimpleList implements Iterator<String> {
    SimpleList sl;
    Noeud noeud;
		
    public IteratorSimpleList(SimpleList sl) {
	this.sl = sl;
        this.noeud = sl.getContenu();
    }

    @Override
    public boolean hasNext() {
	return this.noeud != null;
    }

    @Override
    public String next() {
	String s = this.noeud.getData();
        this.noeud = this.noeud.getSuivant();
        return s;
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
