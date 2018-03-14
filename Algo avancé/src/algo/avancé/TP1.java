/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algo.avancé;

/**
 *
 * @author nguye
 */
public class TP1 {
        /**
     * @param args the command line arguments
     */
public static void main(String[] args) {
    //System.out.println(factoriel(3));
    //System.out.println(puissance(2,3));
    //descente(3);
    //montee(3);
    //rebond(5);
    System.out.println(auxfibo3(5));
    //System.out.println(fibo(20));  
    //triFus([3,2,41,1]);
    }

    public static int factoriel(int n){
        if(n==0)
            return 1;
        return factoriel(n-1)*n;
    }
    
    public static int puissance(int x, int p){
        if(p==0)
            return 1;
        return puissance(x,p-1)*x;
    }
    
    public static void descente(int n){
        System.out.println(n);
        if(n<=0)
            return;
        descente(--n);
        }
    
    public static void montee(int n){
        aux2(n,0);
    }
    
    public static void aux2(int n, int i){
        System.out.println(i);
        if(i>=n)
            return;
        aux2(n,++i);
    }
    
    /*public static void rebond(int n){
        aux1(n,n,false);
    }
    
   public static void aux1(int n, int i, boolean b){
        System.out.println(i);
        if(i==0)
            b = true;
        if(!b){
            aux1(n, --i,b);
       }
        
        else if(i<n){
            
            aux1(n,++i,b);
        }
        
       
   }*/
   public static void rebond(int n){
        auxRebond(n,-1,n);
    }
    
  public static void auxRebond(int i, int p, int n){
        if(i==n && p==1) { //Le cas limite 
            System.out.println(n);
        }
        else {
            if(i==0) {
                System.out.println(0);
                auxRebond(1,1,n);
            }
            else { // le cas ou on descend 
                System.out.println(i);
                auxRebond(--i,p,n);
            }
        }
}
    
    
    
    public static int fibo(int n){
        if(n==0)
            return 0;
        else if(n==1)
            return 1;
        
        return fibo(n-1)+fibo(n-2);  
    }
    
    public static long[] auxfibo3(int n) { //SAVOIRle faire par coeur
        if (n == 0) {
            long[] x = {0, 0};
            return x;
        }
        if (n == 1) {
            long[] x = {0, 1};
            return x;
        } else {
            long[] x = auxfibo3(n - 1);
            long[] y = {x[1], x[0] + x[1]};
            return y;
        }
        
        
    }
    
    public static int[] triFusion(int[]t){
        return auxFus(t,0,t.length-1, new int[t.length]);
        
    }
    
    public static int[] auxFus(int []t,int deb,int fin,int[] taux){
        if(deb <= fin){ //cas limite
            return t;
        }
        
        int mil=(deb+fin)/2;
        auxFus(t, deb, fin, taux);
        auxFus(t,mil,fin,taux);
        int i=deb;
        int j=mil+1;
        int k = deb;
        
        
        
        
        int []aux1 = auxFus(t,deb,fin/2);
        int []aux2 = auxFus(t,mil,fin);
        int []aux3;
            
        while(i <=aux1.length && j <= aux2.length){
            if(aux1[i]<aux2[i]){
                aux3[k]=aux1[i++];
                
            }
            else{
                aux3[k]=aux2[j++];   
            }
            k++;
            while (i <= mil) {
            taux[k++] = t[i++];
        }
        while (j <= fin) {
            taux[k++] = t[j++];
        }
        }
        else
    }
    
    
    
   // new int t.lenght est un tableau vide mais dela même taille

    private static void triFusion(int[] t, int deb, int fin, int[] taux) {
        if (deb >= fin) {
            return;
        }
        int mil = (deb + fin) / 2;
        triFusion(t, deb, mil, taux);
        triFusion(t, mil + 1, fin, taux);
        int i = deb; 
        int j = mil + 1;
        int k = deb;
        while (i <= mil && j <= fin) {
            if (t[i] <= t[j]) {
                taux[k++] = t[i++];
            } else {
                taux[k++] = t[j++];
            }
        }
        while (i <= mil) {
            taux[k++] = t[i++];
        }
        while (j <= fin) {
            taux[k++] = t[j++];
        }
        for(i = deb; i <= fin; i++)
            t[i] = taux[i];
        return;
    }
     
}



        
    
    
