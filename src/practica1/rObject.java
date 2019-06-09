/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.LinkedList;

/**
 *
 * @author renato
 */
public class rObject {
    String symbol;
    LinkedList<Integer> estado;
    LinkedList<Character> caracteres;
    public rObject(String s, LinkedList<Integer> es, LinkedList<Character> c){
    this.symbol=s;
    this.estado = es;
    this.caracteres = c;
    }
}
