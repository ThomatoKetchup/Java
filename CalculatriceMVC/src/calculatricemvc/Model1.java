/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatricemvc;

import calculatrice.Exceptions.ExceptionOperationExistante;

/**
 *
 * @author Nguye
 */
public class Model1 implements IModel{

    @Override
    public Calculatrice init() {
        Calculatrice c = new Calculatrice();
        try {
            c.addOperation("+", new Addition());
            c.addOperation("-", new Soustraction());
            c.addOperation("/", new Division()); //Il faut necessairement que Division implément opération, sinon il ne peut pas $etre de type operation
            c.addOperation("*", new Multiplication());

        } catch (ExceptionOperationExistante e) {
            System.out.println("Cette opération existe déjà.");
        }
        return c;
    }
    
}
