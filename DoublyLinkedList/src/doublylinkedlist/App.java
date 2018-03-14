/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doublylinkedlist;
import java.util.ListIterator;

/**
 *
 * @author Nguye
 */
public class App {

    /**
     *
     * @param args
     */
    public static void main(String[] args){
        
        DoublyLinkedList<String> l1 = new DoublyLinkedList();
        //l.add("Je");
        //l.add("suis");
        l1.add("Thomas");
        l1.push("Hello");
        //l.afficher();  
        //System.out.println(l.contains("suis"));    
        //System.out.println(l.contains("Aurevoir"));    
        //l.insert(2, "ne");
        //l.insert(4, "pas");
        //l.afficher();   
        //l.remove(2);
        //l.afficher();   
  
        DoublyLinkedList l2 = new DoublyLinkedList();
        l2.add("En");
        l2.add("faites");
        l2.add("si");
        l1.addAll(l2);
        l1.afficher();   
          
        System.out.println("peek");
        System.out.println(l1.peek());      
        System.out.println("poll");
        System.out.println(l1.poll());           
        l1.afficher();                        
        
        ListIterator it = l1.iterator();
        
        while(it.hasNext()){
            System.out.print(it.next()+" ");         
        }
        System.out.println("");
        
        while(it.hasPrevious()){
            System.out.print(it.previous()+" ");
        }
        System.out.println("");
    }
}

