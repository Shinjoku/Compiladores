/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package my.compilador;

/**
 *
 * @author Felipe
 */
public class InvalidCharacterException extends Exception  {
    public InvalidCharacterException(String message){
        super(message);
    }
}
