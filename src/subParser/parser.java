
//----------------------------------------------------
// The following code was generated by CUP v0.11b 20160615 (GIT 4ac7450)
//----------------------------------------------------

package subParser;

import java_cup.runtime.*;
import java.util.*;
import java_cup.runtime.XMLElement;

/** CUP v0.11b 20160615 (GIT 4ac7450) generated parser.
  */
@SuppressWarnings({"rawtypes"})
public class parser extends java_cup.runtime.lr_parser {

 public final Class getSymbolContainer() {
    return sym.class;
}

  /** Default constructor. */
  @Deprecated
  public parser() {super();}

  /** Constructor which sets the default scanner. */
  @Deprecated
  public parser(java_cup.runtime.Scanner s) {super(s);}

  /** Constructor which sets the default scanner. */
  public parser(java_cup.runtime.Scanner s, java_cup.runtime.SymbolFactory sf) {super(s,sf);}

  /** Production table. */
  protected static final short _production_table[][] = 
    unpackFromStrings(new String[] {
    "\000\006\000\002\002\004\000\002\002\006\000\002\002" +
    "\002\000\002\003\004\000\002\003\006\000\002\003\002" +
    "" });

  /** Access to production table. */
  public short[][] production_table() {return _production_table;}

  /** Parse-action table. */
  protected static final short[][] _action_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\006\002\uffff\004\004\001\002\000\010\004" +
    "\007\005\ufffc\006\010\001\002\000\004\002\006\001\002" +
    "\000\004\002\001\001\002\000\010\004\007\005\ufffc\006" +
    "\010\001\002\000\010\004\007\005\ufffc\006\010\001\002" +
    "\000\004\005\012\001\002\000\006\002\uffff\004\004\001" +
    "\002\000\004\002\000\001\002\000\004\005\ufffe\001\002" +
    "\000\004\005\016\001\002\000\010\004\007\005\ufffc\006" +
    "\010\001\002\000\004\005\ufffd\001\002" });

  /** Access to parse-action table. */
  public short[][] action_table() {return _action_table;}

  /** <code>reduce_goto</code> table. */
  protected static final short[][] _reduce_table = 
    unpackFromStrings(new String[] {
    "\000\015\000\004\002\004\001\001\000\004\003\010\001" +
    "\001\000\002\001\001\000\002\001\001\000\004\003\014" +
    "\001\001\000\004\003\013\001\001\000\002\001\001\000" +
    "\004\002\012\001\001\000\002\001\001\000\002\001\001" +
    "\000\002\001\001\000\004\003\016\001\001\000\002\001" +
    "\001" });

  /** Access to <code>reduce_goto</code> table. */
  public short[][] reduce_table() {return _reduce_table;}

  /** Instance of action encapsulation class. */
  protected CUP$parser$actions action_obj;

  /** Action encapsulation object initializer. */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions(this);
    }

  /** Invoke a user supplied parse action. */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** Indicates start state. */
  public int start_state() {return 0;}
  /** Indicates start production. */
  public int start_production() {return 0;}

  /** <code>EOF</code> Symbol index. */
  public int EOF_sym() {return 0;}

  /** <code>error</code> Symbol index. */
  public int error_sym() {return 1;}


  
     //Metodo al que se llama automaticamente ante algun error sintactico
    public void syntax_error(Symbol s)
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        practica1.Practica1.log("!!!!!!! Error Sintactico Recuperado !!!!!!!");
       practica1.Practica1.log("\t\tLexema: "+lexema);
        practica1.Practica1.log("\t\tFila: "+fila);
        practica1.Practica1.log("\t\tColumna: "+columna);
       
        }

    //Metodo al que se llama en el momento en que ya no es posible una recuperacion de errores
    public void unrecovered_syntax_error(Symbol s) throws java.lang.Exception
    {        
        String lexema = s.value.toString();
        int fila = s.right;
        int columna = s.left;
        
        practica1.Practica1.log("!!!!!!! Error Sintactico, Error Fatal !!!!!!! ");
        practica1.Practica1.log("\t\tLexema: "+lexema);
        practica1.Practica1.log("\t\tFila: "+fila);
        practica1.Practica1.log("\t\tColumna: "+columna);

    }
   

/** Cup generated class to encapsulate user supplied action code.*/
@SuppressWarnings({"rawtypes", "unchecked", "unused"})
class CUP$parser$actions {
  private final parser parser;

  /** Constructor */
  CUP$parser$actions(parser parser) {
    this.parser = parser;
  }

  /** Method 0 with the actual generated action code for actions 0 to 300. */
  public final java_cup.runtime.Symbol CUP$parser$do_action_part00000000(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // $START ::= INICIO EOF 
            {
              Object RESULT =null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String start_val = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = parser.getSymbolFactory().newSymbol("$START",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // INICIO ::= OPENBRACKET S1 CLOSINGBRACKET INICIO 
            {
              String RESULT =null;
		int rStringleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int rStringright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String rString = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		 practica1.Practica1.bloques.add(rString); 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // INICIO ::= 
            {
              String RESULT =null;

              CUP$parser$result = parser.getSymbolFactory().newSymbol("INICIO",0, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // S1 ::= ESPECIAL S1 
            {
              String RESULT =null;
		int c1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int c1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String c1 = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int currentleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int currentright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String current = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = c1+" "+current; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("S1",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // S1 ::= OPENBRACKET S1 CLOSINGBRACKET S1 
            {
              String RESULT =null;
		int rResultleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int rResultright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		String rResult = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int currentleft = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).left;
		int currentright = ((java_cup.runtime.Symbol)CUP$parser$stack.peek()).right;
		String current = (String)((java_cup.runtime.Symbol) CUP$parser$stack.peek()).value;
		 RESULT = "{"+rResult+"}"+" "+current; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("S1",1, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)), ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // S1 ::= 
            {
              String RESULT =null;
		 RESULT = ""; 
              CUP$parser$result = parser.getSymbolFactory().newSymbol("S1",1, ((java_cup.runtime.Symbol)CUP$parser$stack.peek()), RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number "+CUP$parser$act_num+"found in internal parse table");

        }
    } /* end of method */

  /** Method splitting the generated action code into several parts. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
              return CUP$parser$do_action_part00000000(
                               CUP$parser$act_num,
                               CUP$parser$parser,
                               CUP$parser$stack,
                               CUP$parser$top);
    }
}

}
