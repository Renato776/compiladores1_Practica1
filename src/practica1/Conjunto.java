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
public class Conjunto {
    public String nombre;
    public LinkedList<Character> contenido;
    public Conjunto(String n, LinkedList<Character> c){
    this.contenido= c;
    this.nombre=n;
    }
}
