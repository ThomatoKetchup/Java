/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;


public class Noeud<T>{
    private T data;
    private Noeud<T> suivant;
    private Noeud<T> precedent;
    
    public Noeud(T data, Noeud suivant, Noeud precedent){
        this.data = data;
        this.suivant = suivant;
        this.precedent = precedent;
    }
    
    public Noeud(T data) {
	this.data = data;
    }
    
    public T getData() {
	return data;
    }
    
    public void setData(T data) {
	this.data = data;
    }

    public Noeud getSuivant() {
	return this.suivant;
    }

    public void setSuivant(Noeud suivant) {
	this.suivant = suivant;
    }
    
    public Noeud getPrecedent() {
	return precedent;
    }

    public void setPrecedent(Noeud precedent) {
	this.precedent = precedent;
    }
    
    public boolean containsAux(T s){
        if(this.data.equals(s)) return true;
        else if(this.suivant == null) return false;
        else return this.suivant.containsAux(s);
    }
    
    public void insertAux(int i, Noeud n){
        Noeud m = this;
        for(int j=1; j<i; j++){
            m = m.suivant;
        }
        n.suivant = m.suivant;
        n.precedent = m;
        n.suivant.precedent = n;
        m.suivant = n;
    }
    
    public void removeAux(int i, doublylinkedlist.DoublyLinkedList l){
        if(i == 0) l.removeFirst();
        else if(i == l.getTaille()-1) l.removeLast();
        else{
            Noeud p = this;
            for(int j=1; j<i; j++){
                p = p.suivant;
            }
            p.suivant = p.suivant.suivant;
            p.suivant.setPrecedent(p);
            l.setTaille(l.getTaille()-1);
        }
    }
    
    public void addAllAux(DoublyLinkedList l, Noeud n){
        this.suivant = n;
        n.precedent = this;
    }
    
    public void afficherAux(){
        if(this.suivant == null) System.out.println(this.data);
        else{
            System.out.print(this.data+" ");
            this.suivant.afficherAux();
        }   
    }
	
}

