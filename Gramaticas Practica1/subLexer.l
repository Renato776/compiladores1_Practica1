// JFlex example from the user Manual

package subParser;

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
%}

anyCharacter = [^{}]+
LineTerminator = \r|\n|\r\n
WhiteSpace     = {LineTerminator} | [ \t\f]
InputCharacter = [^\r\n]
COMMENT     = "//" {InputCharacter}* {LineTerminator}
TraditionalComment   = "<!" [^*] ~"!>"
RCOMMENT = {COMMENT}|{TraditionalComment}

%%


/* keywords */
<YYINITIAL> "{"           { System.out.println(sym.OPENBRACKET+" "+yytext()); return new Symbol(sym.OPENBRACKET,yycolumn,yyline,yytext()); }
<YYINITIAL> "}"           { System.out.println(sym.CLOSINGBRACKET+" "+yytext()); return new Symbol(sym.CLOSINGBRACKET,yycolumn,yyline,yytext()); }
<YYINITIAL> {anyCharacter}           { System.out.println(sym.ESPECIAL+" "+yytext());return new Symbol(sym.ESPECIAL,yycolumn,yyline,yytext()); }

<YYINITIAL> {  
  /* comments */
  {RCOMMENT}                      { /* ignore */ }
 
  /* whitespace */
  {WhiteSpace}                   { /* ignore */ }
}
