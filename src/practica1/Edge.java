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
public class Edge {
    public Estado origen;
    public Estado destino;
    public LinkedList<Character> contenido;
    public String symbol;
    public Edge(Estado o, Estado d,LinkedList<Character> c,String s){
    this.origen = o;
    this.destino = d;
    this.contenido = c;
    this.symbol = s;
    }
    
    
    public boolean avanza(char c){
    for(char rChar:this.contenido){
    if(rChar==c){
    return true;
    }
    }
    return false;
    }
}
