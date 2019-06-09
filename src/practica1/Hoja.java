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
public class Hoja {
    public String symbol;
    public int numero;
    public LinkedList<Character> caracteres;
    public boolean esConjunto;
    public Hoja(String s, int c, LinkedList<Character> sig,boolean conj){
    this.symbol = s;
    this.numero = c;
    this.caracteres = sig;
    this.esConjunto = conj;
    }
    public boolean exists(LinkedList<Hoja> h, String s){
    for(Hoja hoja:h){
    if(hoja.symbol.equals(s))return true;
    }
    return false;
    }
}
