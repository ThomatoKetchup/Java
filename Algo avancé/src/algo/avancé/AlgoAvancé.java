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
public class AlgoAvancé {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        SimpleList sl = new SimpleList();
        sl.addEnTete("Salut");
        sl.add("Je");
        sl.add("Suis");
        sl.add("Thomas");
        System.out.println(sl.contains("Thomas"));
        //sl.afficher();
        //sl.remove(2);
        //sl.afficher();
        sl.insert(2, "Ne");
        sl.insert(4, "Pas");
        
        SimpleList sl2 = new SimpleList();
        sl2.addEnTete("En");
        sl2.add("Faites");
        sl2.add("Si");
        
        sl.addAll(sl2);
        
        sl.remove(7);

        
        Iterator it = sl.iterator();
        
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
    
}
