import java_cup.runtime.*;
%% //separador de area

/* opciones y declaraciones de jflex */

%class lexico2
%cup
%cupdebug
%line
%column

LineTerminator = [ \r|\n|\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* identifiers */
Letra = [a-zA-Z]
Signo = [-_.]
Numero = [0123456789]
Texto = ({Letra})({Letra}|{Signo}|{Numero})*

%{
  StringBuilder string = new StringBuilder();
  
  private Symbol symbol(int type) {
    return new Symbol(type, yyline+1, yycolumn+1);
  }
    private Symbol symbol(int type, Object value) {

    return new Symbol(type, yyline+1, yycolumn+1, value);
  }

%}


%% // separador de areas
/* reglas lexicas */
<YYINITIAL> {
        
        "<proyecto>"                                 {return symbol(sym2.EPROYECTO);}
        "</proyecto>"                                 {return symbol(sym2.EPROYECTOC);}
        "<nombre>"                                 {return symbol(sym2.ENOMBRE);}
        "</nombre>"                                 {return symbol(sym2.ENOMBREC);}
        "<creacion>"                                 {return symbol(sym2.ECREACION);}
        "</creacion>"                                 {return symbol(sym2.ECREACIONC);}
        "<ruta>"                                 {return symbol(sym2.ERUTA);}
        "</ruta>"                                 {return symbol(sym2.ERUTAC);}
        "<archivo>"                                 {return symbol(sym2.EARCHIVO);}
        "</archivo>"                                 {return symbol(sym2.EARCHIVOC);}
        "<paquete>"                                 {return symbol(sym2.EPAQUETE);}
        "</paquete>"                                 {return symbol(sym2.EPAQUETEC);}
        "<archs>"                                 {return symbol(sym2.EARCHS);}
        "</archs>"                                 {return symbol(sym2.EARCHSC);}
        ((" ")|"\n")+                                {}//ignoroamos
        ({Letra}|{Signo}|{Numero})+       {return symbol(sym2.TEXTO,new String(yytext()));}
        ({Letra}|{Signo}|{Numero}|"/")+   {return symbol(sym2.PATH,new String(yytext()));}
        .               {}//ignoramos            
}
