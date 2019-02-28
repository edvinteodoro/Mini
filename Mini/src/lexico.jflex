import java_cup.runtime.*;
%% //separador de area

/* opciones y declaraciones de jflex */
%public
%class lexico
%cup
%cupdebug
%line
%column

LineTerminator = [ \r|\n|\r\n]

WhiteSpace = {LineTerminator} | [ \t\f]

/* identifiers */
Letra = [a-zA-Z]
Signo = [-_.!@#%&*|/]
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


	//dato primitivos

        "entero"                                 {return symbol(sym.ENTERO,new String(yytext()));}
	"decimal"                                {return symbol(sym.DECIMAL,new String(yytext()));}
        "cadena"                             {return symbol(sym.CADENA,new String(yytext()));}
	"booleano"                                {return symbol(sym.BOOLEANO,new String(yytext()));}
        "vacio"                             {return symbol(sym.VACIO,new String(yytext()));}
        
        "falso"                             {return symbol(sym.FALSO,new String(yytext()));}
        "verdadero"                             {return symbol(sym.VERDADERO,new String(yytext()));}
	
	//Operadores aritméticos
        "++"                             {return symbol(sym.AUMENTO);}
        "--"                             {return symbol(sym.DISMINUCION);}
        "+"                                {return symbol(sym.SUM);}
        "-"                                {return symbol(sym.RES);}
        "*"                                 {return symbol(sym.MUL);}
        "/"                                {return symbol(sym.DIV);}

	//Operadores relacionales

        ">"                                 {return symbol(sym.MAYOR);}
        "<"                                 {return symbol(sym.MENOR);}
        ">=" 				{return symbol(sym.MAYORIGUAL);}
        "<="                           {return symbol(sym.MENORIGUAL);}
        "=="                           {return symbol(sym.IGUAL);}
        "!="                           {return symbol(sym.DIFERENTE);}
	
	//Operadores lógicos

        "||"                             {return symbol(sym.OR);}
        "&&"                             {return symbol(sym.AND);}
        "!!"                             {return symbol(sym.NEGACION);}

	//Signos de agrupación

        "("                             {return symbol(sym.PARA);}
        ")"			         {return symbol(sym.PARC);}
        "["			         {return symbol(sym.CORA);}
        "]"			         {return symbol(sym.CORC);}
	//Asignación y fin de sentencia
 
        ":="                             {return symbol(sym.ASIGNAR);}
        ";"                             {return symbol(sym.FINL);}
	","                             {return symbol(sym.COMA);}
	//Palabras reservadas de visibilidad

	"publico"                            {return symbol(sym.PUBLICO,new String(yytext()));}
        "protegido"                           {return symbol(sym.PROTEGIDO,new String(yytext()));}
        "privado"                             {return symbol(sym.PRIVADO,new String(yytext()));}

	//importación

        "importar"                            {return symbol(sym.IMPORTAR);}

	//clase y herencia

        "clase"                            {return symbol(sym.CLASE);}	
        "extiende"                            {return symbol(sym.EXTIENDE);}	
	//Sentencias de control

        "SI"                            {return symbol(sym.SI);}	
        "SINO_SI"                            {return symbol(sym.SINO_SI);}	
        "SINO"                            {return symbol(sym.SINO);}	
        "MIENTRAS"                            {return symbol(sym.MIENTRAS);}	
        "HACER"                            {return symbol(sym.HACER);}	
        "DESDE"                            {return symbol(sym.DESDE);}	
        "HASTA"                            {return symbol(sym.HASTA);}	
        "INCREMENTO"                            {return symbol(sym.SINCREMENTO);}

	//Imprimir

        "imprimir"                            {return symbol(sym.IMPRIMIR);}
        //otros simbolos
       //Simbolo de entrada Pendiente         {return symbol(sym.COMILLA);}
        "\n"                         {}//ignoramos
        ("-")? ({Numero})+ {return symbol(sym.ENTEROVAL,new String(yytext()));}
        ("-")? ({Numero})+(".")({Numero})+  {return symbol(sym.DECIMALVAL,new String(yytext()));}
        ("//")({Letra}|{Signo}|{Numero}|" ")*("\n")                   {return symbol(sym.DDIAGCOM,new String(yytext()));}
        ("$*")({Letra}|{Signo}|{Numero}|" "|"\n")*("*$")                  {return symbol(sym.COMVA,new String(yytext()));}
        ("\"")({Letra}|{Signo}|{Numero}|" "|"/")*("\"")                         {return symbol(sym.LITERAR,new String(yytext()));}
        ({Letra})({Letra}|{Signo}|{Numero})*                    {return symbol(sym.ID,new String(yytext()));}
//({Letra}|{Signo}|{Numero})+(" ")(" "|{Letra}|{Signo}|{Numero})+     {return symbol(sym.TEXTO,new String(yytext()));}
        //("/")? ({Letra}|{Signo}|{Numero})+  {return symbol(sym.PATH,new String(yytext()));}
        .               {}//ignoramos            
}
