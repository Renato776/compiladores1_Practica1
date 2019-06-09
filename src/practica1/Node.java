/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.*;

/**
 *
 * @author renato
 */
public class Node {

    public static int rID = 0;
    public int id;
    public LinkedList<Integer> primeros;
    public LinkedList<Integer> ultimos;
    public LinkedList<Integer> siguientes;
    public int numero;
    public String conjunto_nombre;
    public boolean anulable;
    public LinkedList<Character> contenido;
    public String tipo;
    public Node left;
    public Node right;
    public boolean completo;
    public String getFirst(){
    String r = ""+this.primeros.get(0);
    int con = 1;
    while(con<this.primeros.size()){
        r=r+","+this.primeros.get(con);
        con++;
    }
    return r+"\n";
    }
    public String getLast(){
    String r = ""+this.ultimos.get(0);
    int con = 1;
    while(con<this.ultimos.size()){
        r=r+","+this.ultimos.get(con);
        con++;
    }
    return r+"\n";
    }
    public String getAnulable(){
    if(this.anulable)return "V";
    return "F";
    }
    public String getSymbol() {
        if (this.tipo.equals("hoja")) {
            if (this.getContentSize() == 1) {
                return "" + this.contenido.getFirst();
            } else {
                return this.conjunto_nombre;
            }
        } else {
            switch (this.tipo) {
                case "kleen":
                    return "*";
                case "y":
                    return ".";
                case "o":
                    return "I";
                case "positiva":
                    return "+";
                case "condicional":
                    return "?";
                default:
                    return this.tipo;
            }
        }

    }

    public int getContentSize() {
        if (this.contenido != null) {
            return this.contenido.size();
        } else {
            return 0;
        }
    }

    public Node(String t, LinkedList<Character> c) {
        this.tipo = t;
        this.contenido = c;
        completo = true;
        this.primeros = new LinkedList();
        this.ultimos = new LinkedList();
        this.id = rID;
        rID++;
    }

    public Node(String t, String rConj, boolean terminado) {
        this.tipo = t;
        this.conjunto_nombre = rConj;
        completo = false;
        this.primeros = new LinkedList();
        this.ultimos = new LinkedList();
        this.id = rID;
        rID++;
    }

    public Node(String t, Node n) {
        this.tipo = t;
        this.left = n;
        this.primeros = new LinkedList();
        this.ultimos = new LinkedList();
        this.id = rID;
        rID++;
    }

    public Node(String t, Node rLeft, Node rRight) {
        this.tipo = t;
        this.left = rLeft;
        this.right = rRight;
        this.primeros = new LinkedList();
        this.ultimos = new LinkedList();
        this.id = rID;
        rID++;
    }

    public void completar() {
        LinkedList<Character> rConjuntos = Practica1.getConjunto(this.conjunto_nombre);
        if (rConjuntos == null) {
            //throw exception;
        };
        this.contenido = rConjuntos;
        this.completo = true;
    }
}
