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
public class Evaluacion {

    public static LinkedList<Character> palabra;
    public String expresion;
    public String contenido;

    public Evaluacion(String exp, String cont) {
        this.expresion = exp;
        this.contenido = cont.split("\"")[1];
    }

    public boolean evaluate() {
        Tree regex = Practica1.getTree(this.expresion);
        if (regex == null) {
            Practica1.log("Error al evaluar, la expresion: " + this.expresion + " NO esta definida.");
            return false;
        } else {
            palabra = new LinkedList();
            Estado inicio = regex.estadoInicial;
            for (Character c : this.contenido.toCharArray()) {
                palabra.add(c);
            }
            char begin = palabra.pollFirst();
            System.out.println("Comenzando a evaluar: con character: "+begin);
            return evaluate(inicio, begin);
        }
    }

    public boolean evaluate(Estado e, char c) {
        for (Edge t : e.transiciones) {
            if (t.contains(c)) {
                //char sigChar = palabra.pollFirst();
                if (palabra.isEmpty()) {
                    return t.destino.aceptacion;
                } else {
                    return evaluate(t.destino, palabra.pollFirst());
                }
            }
        }
        return false;
    }
}
