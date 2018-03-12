/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatricemvc;
import calculatrice.Exceptions.ExceptionOperationExistante;
import calculatrice.Exceptions.ExceptionDivisionParZero;
import calculatrice.Exceptions.ExceptionOperationInconnu;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

/**
 *
 * @author Nguye
 */
public class Calculatrice {
    private Map<String,Operation> operations;
    /*private float v1;
    private float v2;*/
   //private String op;
    
    public Calculatrice(){
        operations = new HashMap<String,Operation>();
    }
    
    /*public void init(float v1, float v2, String op){
        this.v1 = v1;
        this.v2=v2;
        this.op=op;
    }*/
    
    public void addOperation(String sym, Operation op) throws ExceptionOperationExistante{  
        if(operations.containsKey(sym) == true){
            throw new ExceptionOperationExistante();
    }
        this.operations.put(sym, op);
    }
    
    public float calculer(float v1,float v2, String op)throws ExceptionOperationInconnu ,ExceptionDivisionParZero{
        Operation o = this.operations.get(op);
                    System.out.println(o);

        if(o==null){
            throw new ExceptionOperationInconnu();
        }
        return o.execute(v1,v2);
    }
}