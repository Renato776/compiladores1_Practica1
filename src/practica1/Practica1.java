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
public class Practica1 {

    public static String path = "/home/renato/backup/";
    public static LinkedList<Tree> arboles = new LinkedList();
    public static LinkedList<Conjunto> conjuntos = new LinkedList();

    public static boolean compare(LinkedList<Integer> first, LinkedList<Integer> last) {
        boolean result = first.size() == last.size();
        if (result) {

            for (int i1 : first) {
                boolean existe = false;
                for (int i2 : last) {
                    if (i2 == i1) {
                        existe = true;
                    }
                }
                if (!existe) {
                    return false;
                }
            }
            return true;
        } else {
            return false;
        }
    }

    public static Hoja getLeaf(int i, Tree t) {
        for (Hoja h : t.hojas) {
            if (h.numero == i) {
                return h;
            }
        }
        return null;
    }
    public static boolean contiene(LinkedList<Integer> li,int r){
    for(int ren: li){
    if(ren==r){return true;}
    }
    return false;
    }
    public static boolean leafExists(LinkedList<Hoja> li, int i) {
        for (Hoja h : li) {
            if (h.numero == i) {
                return true;
            }
        }
        return false;
    }

    public static LinkedList<Hoja> getHojas(LinkedList<Integer> i, Tree t) {
        LinkedList<Hoja> result = new LinkedList();
        for (int num : i) {
            Hoja h = getLeaf(num,t);
            if(!h.symbol.equals("#")){
            result.add(h);
            }
        }
        return result;
    }
 public static rObject getRObject(String s, LinkedList<rObject> o){
 for(rObject obj: o){
 if(obj.symbol.equals(s))return obj;
 }
 return null;
 }
    public static LinkedList<Integer> union(LinkedList<Integer> p, LinkedList<Integer> u) {
        LinkedList<Integer> resultado = new LinkedList();
        p.forEach((i) -> {
            if (!contiene(resultado,i)) {
                resultado.add(i);
            }
        });
        u.forEach((i2) -> {
            if (!contiene(resultado,i2)) {
                resultado.add(i2);
            }
        });
        return resultado;
    }

    public static LinkedList<Character> getConjunto(String conj) {
        for (Conjunto conjunto : conjuntos) {
            if (conjunto.nombre.equals(conj)) {
                return conjunto.contenido;
            }
        }
        return null;
    }

    public static final String ruta = "/home/renato/compilers1";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

}
