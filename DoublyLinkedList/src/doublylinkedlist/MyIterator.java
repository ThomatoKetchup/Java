/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;


import java.util.ListIterator;


public class MyIterator<T> implements ListIterator<T>{
    Noeud<T> n;
    Noeud<T> p;
		
    public MyIterator(DoublyLinkedList l) {
        this.n = l.getTete();
        this.p = l.getQueue();
    }

    @Override
    public boolean hasNext() {
	return this.n != null;
    }

    @Override
    public T next(){
	T s = this.n.getData();
        this.n = this.n.getSuivant();
        return s;
    }
    
    @Override
    public boolean hasPrevious() {
        return this.p != null;
    }

    @Override
    public T previous() {
        T s = this.p.getData();
        this.p = this.p.getPrecedent();
        return s;
    }

    @Override
    public int nextIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int previousIndex() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void set(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void add(T e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
		
}
	