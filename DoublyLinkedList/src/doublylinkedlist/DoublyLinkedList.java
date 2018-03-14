/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;


import java.util.ListIterator;


public class DoublyLinkedList<G> implements Iterable<G>{
    private Noeud<G> tete;
    private Noeud<G> queue;
    private int taille;
    
    public DoublyLinkedList(){ //crée une liste vide
        this.tete = null;
        this.queue = null;
        this.taille = 0;
    }
    
    public Noeud<G> getTete(){
        return this.tete;
    }
    
    public void setTete(Noeud<G> tete) {
	this.tete = tete;
    }
    
    public Noeud<G> getQueue(){
        return this.queue;
    }
    
    public void setQueue(Noeud<G> queue) {
	this.queue = queue;
    }
    
    public int getTaille() {
	return this.taille;
    }
    
    public void setTaille(int x) {
	this.taille = x;
    }
   
    public void push(G s){    //ajoute au début
        this.tete = new Noeud(s, tete, null);
        if(taille != 0) this.tete.getSuivant().setPrecedent(tete);
        else this.queue = this.tete;
        this.taille++;
    }
    
    public void add(G s){  //ajoute à la fin
        this.queue = new Noeud(s, null, queue);
        if(taille != 0) this.queue.getPrecedent().setSuivant(queue);
        else this.tete = this.queue;
        this.taille++;
    }
    
    public boolean contains(G s){
        return this.tete.containsAux(s);
    }
    
    public void insert(int i, G s){
        if(i==0) push(s);
        else {
            Noeud<G> n = new Noeud(s);
            this.tete.insertAux(i, n);
            this.taille++;
        }
    }
    
    public void remove(int i){
        this.tete.removeAux(i, this);
    }
    
    public void addAll(DoublyLinkedList l) { // ajoute tous les éléments de la liste l à la fin de this
        Noeud<G> n = l.getTete();
        this.queue.addAllAux(l,n);
        this.queue = l.getQueue();
        this.taille += l.taille;
    }
    
    public void afficher(){
        this.tete.afficherAux();
    }
    
    public G getFirst() {
	return this.tete.getData();
    }
    
    public G getLast(){
        return this.queue.getData();
    }
    
    public G removeFirst(){
        G s = this.tete.getData();
        this.tete = this.tete.getSuivant();
        this.tete.setPrecedent(null);
        this.taille--;
        return s;
    }
    
    public G removeLast(){
        G s = this.queue.getData();
        this.queue = this.queue.getPrecedent();
        this.queue.setSuivant(null);
        this.taille--;
        return s;
    }
    
    public G peek() {
	return this.tete.getData();
    }
    
    public G poll(){
        G s = this.tete.getData();
        this.tete = this.tete.getSuivant();
        this.tete.setPrecedent(null);
        this.taille--;
        return s;
    }
    
    public ListIterator<G> iterator(){ // retourne un itérateur qui énumère les éléments de type T contenus dans la liste
        return new MyIterator<G>(this);
    }   
    
}

	
	
	
	
	
	
	

