// JFlex example from the user Manual

package evaluacion;

import java_cup.runtime.Symbol;

/** Lexer of a very minimal version of the Java programming language. */

%%


%class scanner
%unicode
%cup
%line
%column
%caseless
%8bit
%full

%{
  StringBuffer string = new StringBuffer();

  private Symbol symbol(int type) {
    return new Symbol(type, yyline, yycolumn);
  }
  private Symbol symbol(int type, Object value) {
    return new Symbol(type, yyline, yycolumn, value);
  }
  public static void evaluate(String es){
scanner lexico = new scanner(new BufferedReader(new StringReader(es)));
            parser sin = new parser(lexico);
            try {
                sin.parse();
            } catch (Exception eret) {
                System.out.println(eret);
            }
}
%}

IDENTIFIER = [a-zA-Z_][0-9a-zA-Z_]*
STRINGLITERAL = \"[^\n\r\"\\]+\"
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
InputCharacter = [^\r\n]
COMMENT     = "//" {InputCharacter}* {LineTerminator}
TraditionalComment   = "<!" [^*] ~"!>"
RCOMMENT = {COMMENT}|{TraditionalComment}
%%


/* keywords */
<YYINITIAL> ":"           { System.out.println(sym.DOSPUNTOS+" "+yytext()); return new Symbol(sym.DOSPUNTOS,yycolumn,yyline,yytext()); }
<YYINITIAL> ";"           { System.out.println(sym.PUNTOCOMA+" "+yytext()); return new Symbol(sym.PUNTOCOMA,yycolumn,yyline,yytext()); }
<YYINITIAL> {STRINGLITERAL}           { System.out.println(sym.STRINGLITERAL+" "+yytext()); return new Symbol(sym.STRINGLITERAL,yycolumn,yyline,yytext()); }
<YYINITIAL> {IDENTIFIER}           { System.out.println(sym.IDENTIFIER+" "+yytext());return new Symbol(sym.IDENTIFIER,yycolumn,yyline,yytext()); }

<YYINITIAL> {  
  /* comments */
  {RCOMMENT}                      { /* ignore */ }
 
  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}
