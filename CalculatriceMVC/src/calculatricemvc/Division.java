/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculatricemvc;

import calculatrice.Exceptions.ExceptionDivisionParZero;

/**
 *
 * @author nguye
 */
public class Division implements Operation {
        @Override
        public float execute(float v1,float v2) throws ExceptionDivisionParZero {
            if(v2 ==0){
                throw new ExceptionDivisionParZero();
            }
            return v1/v2;
    }
}
