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
public interface Operation  {
    float execute(float a, float b) throws ExceptionDivisionParZero;
}
