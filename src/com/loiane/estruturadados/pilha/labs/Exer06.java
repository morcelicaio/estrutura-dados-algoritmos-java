package com.loiane.estruturadados.pilha.labs;

import com.loiane.estruturadados.pilha.Pilha;

public class Exer06 {

	public static void main(String[] args) {
		
		imprimeResultado("A + B");
		imprimeResultado("A + B + (C - D)");
		imprimeResultado("{[()]}[](){()}");
		imprimeResultado("{[(]}[](){()}");
		imprimeResultado("A + B + C - D)");
	}
	
	public static void imprimeResultado(String expressao){
		System.out.println(expressao + " está balanceado? " + 
				verificaSimbolosBalanceados(expressao));
	}
	
	final static String ABRE = "([{";
	final static String FECHA = ")]}";

	public static boolean verificaSimbolosBalanceados(String expressao){
		
		Pilha<Character> pilha = new Pilha<Character>();
		int index = 0;
		char simbolo, topo; // casos ñ balanceados como (((( estavam retornando true. A variável controle corrige isso.
		int controle = 0;     // Irá validar casos em que apenas foram abertos as chaves ou parenteses.
		
		while (index < expressao.length()){
			simbolo = expressao.charAt(index);
			
			if (ABRE.indexOf(simbolo) > -1){
				pilha.empilha(simbolo);
				
			} else if (FECHA.indexOf(simbolo) > -1){
				
				if (pilha.estaVazia()){
					return false;
				} else {
					topo = pilha.desempilha();
					controle++;
					
					if (ABRE.indexOf(topo) != FECHA.indexOf(simbolo)){
						return false;
					}
				}
			}
			
			index++;
		}
		
		if(controle == 0){     // faz a validação em entradas tipo  '((('  onde só são abertas as chaves.
		    return false;
		}
		
		return true;
	}
}
