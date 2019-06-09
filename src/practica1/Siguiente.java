/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.util.LinkedList;
import javax.swing.JTable;

/**
 *
 * @author renato
 */
public class Siguiente {
    public int hoja;
    public String nombre;
    public LinkedList<Integer> contenido;
    public Siguiente(int i){
    this.hoja = i;
    this.contenido = new LinkedList();
    }
    public String getContenido(){
        if(this.contenido==null)return "";
        if(this.contenido.size()==0)return "";
    String r = ""+this.contenido.get(0);
    int con = 1;
    while(con<this.contenido.size()){
        r=r+","+this.contenido.get(con);
        con++;
    }
    return r;
    }
}
