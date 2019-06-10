/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.LinkedList;
import javax.swing.JTable;
import static practica1.interfaz.guardar;

/**
 *
 * @author renato
 */
public class Tree {

    public int c = 1;
    public String name;
    public Node root;
    public Estado estadoInicial;
    public LinkedList<Siguiente> siguientes;
    public LinkedList<Estado> estados;
    public LinkedList<Hoja> hojas;

    public Estado getEstado(LinkedList<Integer> i) {
        for (Estado e : this.estados) {
            if (Practica1.compare(e.contenido, i)) {
                return e;
            }
        }
        return null;
    }
    public boolean aceptacion(LinkedList<Integer>l){
    for(int renato:l){
        Hoja h = Practica1.getLeaf(renato, this);
    if(h==null)return false;
    if(h.symbol.equals("#"))return true;
    }
    return false;
    }
    public Estado generateEstado(LinkedList<Integer> li) {
        Estado es;
        if(this.aceptacion(li)){
        es = new Estado(li,true);
        }else{
        es = new Estado(li,false);
        }
        this.estados.add(es);
        LinkedList<Hoja> leafs = Practica1.getHojas(li, this);
        LinkedList<rObject> objetos = new LinkedList();
        for (Hoja h : leafs) {
            rObject old = Practica1.getRObject(h.symbol, objetos);
            if (old == null) {
                objetos.add(new rObject(h.symbol, this.getSiguiente(h.numero).contenido, h.caracteres));
            } else {
                old.estado = Practica1.union(old.estado, this.getSiguiente(h.numero).contenido);
            }
        }
        for (rObject alex : objetos) {
            Estado est = this.getEstado(alex.estado);
            if (est == null) {
                es.transiciones.add(new Edge(es, this.generateEstado(alex.estado), alex.caracteres, alex.symbol));
            } else {
                es.transiciones.add(new Edge(es, est, alex.caracteres, alex.symbol));
            }
        }
        return es;
    }

    public void getSiguientes() {
        String resultado = "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "table {\n"
                + "  font-family: arial, sans-serif;\n"
                + "  border-collapse: collapse;\n"
                + "  width: 100%;\n"
                + "}\n"
                + "\n"
                + "td, th {\n"
                + "  border: 1px solid #dddddd;\n"
                + "  text-align: left;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even) {\n"
                + "  background-color: #dddddd;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<h2>HTML Table</h2>" + "\n";
        resultado = resultado + "<table>\n"
                + "  <tr>\n"
                + "    <th>codigo</th>\n"
                + "    <th>siguientes</th>\n"
                + "  </tr>";
        for (Siguiente rSig : this.siguientes) {
            resultado = resultado + "<tr>";
            resultado = resultado + "<td>" + rSig.hoja + "</td>" + "<td>" + rSig.getContenido() + "</td>";
            resultado = resultado + "</tr>";
        }
        resultado = resultado + "</table></body>\n"
                + "</html>";
        //return resultado;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Practica1.path + this.name + "_siguientes.html"), false));
            //FileWriter fw = new FileWriter(guardar);
            writer.write(resultado);
            writer.close();
            //console.setText(console.getText()+"\n"+"intentando imprimir: "+texto.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String print() {
        LinkedList<String> result = new LinkedList();
        print(root, result);
        String r = "digraph AVL { node [shape=record fontname=\"Arial\"];";
        for (String s : result) {
            r = r + s;
        }
        r = r + "}";

        String p = Practica1.path;
        String name = this.name + "_arbol";
        String error = "";
        try {
            PrintWriter writer = new PrintWriter(p + name + ".dot", "UTF-8");
            writer.println(r);
            writer.close();
        } catch (Exception e) {
            error = error + "Ocurrio un error al crear el archivo";
        }
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("/usr/local/bin/dot -Tsvg " + p + name + ".dot" + " -o " + p + name + ".svg");
        } catch (Exception ex) {
            error = error + "Error al crear grafica: " + ex.getMessage();
        }

        return name + ".svg";
    }
//leaf example:     a = a + "U" + n.id + " [label = \"" + n.getSymbol() + "\n" + n.data.getString("nombre") + "\"];" + "\n";
    public void printAutomata(){
      String a = "digraph AUTOMATA { node [shape=oval fontname=\"Arial\"];";
      for(Estado state: this.estados){
          if(state.aceptacion){
       a = a + "U" + state.name + " [label = \"" + state.name + "\" fillcolor=yellow,style=filled];" + "\n";
          }else{
       a = a + "U" + state.name + " [label = \"" + state.name + "\" ];" + "\n";
          }
          
          for(Edge ed: state.transiciones){
          a = a + "U" + state.name + "->" + "U" + ed.destino.name +"[label=\""+ed.symbol+"\"]"+ ";" + "\n";
          }
      }
      a = a+"}";
       String p = Practica1.path;
        String rName = this.name + "_automata";
        String error = "";
        try {
            PrintWriter writer = new PrintWriter(p + rName + ".dot", "UTF-8");
            writer.println(a);
            writer.close();
        } catch (Exception e) {
            error = error + "Ocurrio un error al crear el archivo";
        }
        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("/usr/local/bin/dot -Tsvg " + p + rName + ".dot" + " -o " + p + rName + ".svg");
        } catch (Exception ex) {
            error = error + "Error al crear grafica: " + ex.getMessage();
        }

        //return rName + ".svg";
    }
    public void print(Node n, LinkedList<String> li) {
        String a = "";
        if (n == this.root) {
            a = a + "U" + n.id + " [label = \"" + n.getFirst() + "|" + n.getSymbol() + "|" + n.getLast() + "\" xlabel=\"" + n.getAnulable() + "\"];" + "\n";
        }
        if (n.left != null) {
            a = a + "U" + n.left.id + " [label = \"" + n.left.getFirst() + "|" + n.left.getSymbol() + "|" + n.left.getLast() + "\" xlabel=\"" + n.left.getAnulable() + "\"];" + "\n";
        } else {
            // a = a + "null" + n.id + "[shape=point]";
        }
        if (n.right != null) {
            a = a + "U" + n.right.id + " [label = \"" + n.right.getFirst() + "|" + n.right.getSymbol() + "|" + n.right.getLast() + "\" xlabel=\"" + n.right.getAnulable() + "\"];" + "\n";
        } else {
            //  a = a + "nullr" + n.data.getID() + "[shape=point]";
        }

        li.add(a);

        if (n.left == null) {
            //li.insert(new Usuario("U" + n.data.getID() + "->" + "null" + n.data.getID() + ";" + "\n"));
        } else {
            li.add("U" + n.id + "->" + "U" + n.left.id + ";" + "\n");
        }
        if (n.right == null) {
            // li.insert(new Usuario("U" + n.data.getID() + "->" + "nullr" + n.data.getID() + ";" + "\n"));
        } else {
            li.add("U" + n.id + "->" + "U" + n.right.id + ";" + "\n");
        }
        if (n.left != null) {
            print(n.left, li);
        }
        if (n.right != null) {
            print(n.right, li);
        }
    }

    public LinkedList<Hoja> getUniqueLeafs() {
        LinkedList<Hoja> result = new LinkedList();
        for (Hoja h : this.hojas) {
            if (!this.leafAlreadyExists(h, result)) {
                result.add(h);
            }
        }
        return result;
    }

    public boolean leafAlreadyExists(Hoja leaf, LinkedList<Hoja> li) {
        for (Hoja gg : li) {
            if (gg.symbol.equals(leaf.symbol)) {
                return true;
            }
        }
        return false;
    }

    public void getTablaTransiciones() {
        this.estadoInicial = this.generateEstado(this.root.primeros);
        LinkedList<Hoja> leafs = this.getUniqueLeafs();
        String cabecera = "";
        
        for(Hoja h:leafs){
            if(!h.symbol.equals("#")){
        cabecera = cabecera+"<th>"+h.symbol+"</th>";
            }
        }
        String stateTag;
        String resultado = "<html>\n"
                + "<head>\n"
                + "<style>\n"
                + "table {\n"
                + "  font-family: arial, sans-serif;\n"
                + "  border-collapse: collapse;\n"
                + "  width: 100%;\n"
                + "}\n"
                + "\n"
                + "td, th {\n"
                + "  border: 1px solid #dddddd;\n"
                + "  text-align: left;\n"
                + "  padding: 8px;\n"
                + "}\n"
                + "\n"
                + "tr:nth-child(even) {\n"
                + "  background-color: #dddddd;\n"
                + "}\n"
                + "</style>\n"
                + "</head>\n"
                + "<body>\n"
                + "\n"
                + "<h2>Tabla de Transiciones</h2>" + "\n";
        resultado = resultado + "<table>\n"
                + "  <tr>\n"
                + "    <th>Estado</th>\n"
                + cabecera
                + "  </tr>";
        for (Estado state : this.estados) {
            if(state.aceptacion){
                stateTag = "<td style=\"background-color: yellow\">";
            } else {stateTag = "<td>";}
            resultado = resultado + "<tr>";
            resultado = resultado + stateTag + state.name + "</td>";
            resultado = resultado + state.getRow(this);
            resultado = resultado + "</tr>";
        }
        resultado = resultado + "</table></body>\n"
                + "</html>";
        //return resultado;
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(new File(Practica1.path + this.name + "_transiciones.html"), false));
            //FileWriter fw = new FileWriter(guardar);
            writer.write(resultado);
            writer.close();
            //console.setText(console.getText()+"\n"+"intentando imprimir: "+texto.getText());
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Tree(String n, Node r) {
        this.name = n;
        LinkedList<Character> li = new LinkedList();
        li.add('#');
        Node trueRoot = new Node("y", r, new Node("hoja", li));
        this.root = trueRoot;
        this.siguientes = new LinkedList();
        this.hojas = new LinkedList();
        this.estados = new LinkedList();
    }

    public Siguiente getSiguiente(int ren) {
        if (this.siguientes == null) {
            return null;
        }
        for (Siguiente s : this.siguientes) {
            if (s.hoja == ren) {
                return s;
            }
        }
        return null;
    }
    public boolean siguienteAlreadyExists(LinkedList<Integer>li, int i){
        for(int renato:li){
        if(renato==i){return true;}
        }
    return false;
    }
    public void generarSiguientes() {
        int counter = 1;
        while (counter < this.c) {
            Siguiente rSig = new Siguiente(counter);
            this.siguientes.add(rSig);
            counter++;
        }
    }

    public void llenar(Node node) {
        if (node == null) {
            return;
        }

        // first recur on left subtree 
        llenar(node.left);

        // then recur on right subtree 
        llenar(node.right);

        // now deal with the node 
        switch (node.tipo) {
            case "hoja":
                break;
            case "y":
                node.anulable = node.left.anulable && node.right.anulable;
                if (node.left.anulable) {
                    node.primeros = Practica1.union(node.left.primeros, node.right.primeros);
                } else {
                    node.primeros = node.left.primeros;
                }
                if (node.right.anulable) {
                    node.ultimos = Practica1.union(node.left.ultimos, node.right.ultimos);
                } else {
                    node.ultimos = node.right.ultimos;
                }
                //llenar siguientes
                for (int r : node.left.ultimos) {
                    Siguiente sig = this.getSiguiente(r);
                    for (int javi : node.right.primeros) {
                        if (sig != null) {
                            if(!this.siguienteAlreadyExists(sig.contenido, javi)){
                            sig.contenido.add(javi);
                            }
                        }
                    }
                }
                break;
            case "o":
                node.anulable = node.left.anulable || node.right.anulable;
                node.primeros = Practica1.union(node.left.primeros, node.right.primeros);
                node.ultimos = Practica1.union(node.left.ultimos, node.right.ultimos);
                break;
            case "kleen":
                node.primeros = node.left.primeros;
                node.ultimos = node.left.ultimos;
                node.anulable = true;
                for (int r : node.left.ultimos) {
                    Siguiente sig = this.getSiguiente(r);
                    for (int javi : node.left.primeros) {
                        if (sig != null) {
                            if(!this.siguienteAlreadyExists(sig.contenido, javi)){
                            sig.contenido.add(javi);
                            }
                        }
                    }
                }
                break;
            case "positiva":
                node.primeros = node.left.primeros;
                node.ultimos = node.left.ultimos;
                node.anulable = false;
                for (int r : node.left.ultimos) {
                    Siguiente sig = this.getSiguiente(r);
                    for (int javi : node.left.primeros) {
                        if (sig != null) {
                            if(!this.siguienteAlreadyExists(sig.contenido, javi)){
                            sig.contenido.add(javi);
                            }
                        }
                    }
                }
                break;
            case "condicional":
                node.primeros = node.left.primeros;
                node.ultimos = node.left.ultimos;
                node.anulable = true;
                break;
        }

    }

    public void llenarHojas (Node node) throws Exception {
        if (node == null) {
            return;
        }

        // first recur on left subtree 
        llenarHojas(node.left);

        // then recur on right subtree 
        llenarHojas(node.right);

        // now deal with the node 
        if (node.tipo.equals("hoja")) {
            node.numero = this.c;
            node.primeros.add(node.numero);
            node.ultimos.add(node.numero);
            this.c++;
            if (!node.completo) {
                LinkedList<Character> rConjunto = Practica1.getConjunto(node.conjunto_nombre);
                if(rConjunto==null){
                throw new Exception("Error fatal. El conjunto nombrado: "+node.conjunto_nombre+" no existe");
                }
                node.contenido = rConjunto;
                node.completo = true;
                node.siguientes = new LinkedList();
                node.anulable = false;
                this.hojas.add(new Hoja(node.getSymbol(), node.numero, node.contenido, true));
            } else {
                node.siguientes = new LinkedList();
                node.anulable = false;
                this.hojas.add(new Hoja(node.getSymbol(), node.numero, node.contenido, false));
            }
        }
    }

    public void printPostorder(Node node) {

        if (node == null) {
            return;
        }

        // first recur on left subtree 
        printPostorder(node.left);

        // then recur on right subtree 
        printPostorder(node.right);

        // now deal with the node 
        System.out.print(node.tipo + " ");

    }

}
