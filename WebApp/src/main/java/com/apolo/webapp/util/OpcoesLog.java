package com.apolo.webapp.util;

/**
 *
 * @author raybm
 */
public enum OpcoesLog {    
       ERRO(1), ERROLOGIN(2), INCLUSAOUSUARIO(3), EDICAOUSUARIO(4), EXCLUSAOUSUARIO(5),
       INCLUSAORASTREADOR(6), EDICAORASTREADOR(7), EXCLUSAORASTREADOR(8), RASTREADORDESCONHECIDO(9), SQLINJECT(10);

       private final int valor;
       OpcoesLog(int valorOpcao){
           valor = valorOpcao;
       }
       public int getValor(){
           return valor;
       }
}
