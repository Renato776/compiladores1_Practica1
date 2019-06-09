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
public class Estado {

    public String name;
    public static int c = 0;
    public static int l = 65;
    public boolean aceptacion;
    public LinkedList<Edge> transiciones;
    public LinkedList<Integer> contenido;

    public Estado(LinkedList<Integer> i,boolean a) {
        this.contenido = i;
        this.name = "" + (char) l + c;
        this.transiciones = new LinkedList();
        this.aceptacion = a;
        //this.contenido = new LinkedList();
        c++;
        if (l == 90) {
            l = 65;
        } else {
            l++;
        }
    }

    public boolean hasLeaf(String s) {
        for (Edge edge : this.transiciones) {
            if (edge.symbol.equals(s)) {
                return true;
            }
        }
        return false;
    }

    public String getDestiny(String s) {
        for (Edge ed : this.transiciones) {
            if (ed.symbol.equals(s)) {
                return ed.destino.name;
            }
        }
        return "";
    }

    public String getRow(Tree t) {
        String result = "";
        LinkedList<Hoja> leafs = t.getUniqueLeafs();
        for (Hoja hoja : leafs) {
            if(!hoja.symbol.equals("#")){
              result = result + "<td>" + this.getDestiny(hoja.symbol) + "</td>" + "\n";
            }
            
        }
        return result;
    }

}
