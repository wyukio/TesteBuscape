package com.teste.buscape.model;

import java.util.HashMap;
import java.util.Map;

import com.teste.buscape.exceptions.ComandoInvalidoException;
import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.validadores.ValidadorSubmarino;

public class ControleSubmarino {
	private static final Map<String,Acao> ACOES;
	
	static{
		ACOES = new HashMap<String, Acao>();
		ACOES.put("L", new VirarParaEsquerda());
		ACOES.put("R", new VirarParaDireita());
		ACOES.put("U", new Subir());
		ACOES.put("D", new Descer());
		ACOES.put("M", new Mover());
	}
	
	public static void controlarSubmarino(String comando, Submarino submarino) throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		Acao acao = ACOES.get(comando);
		
		if(acao == null)
			throw new ComandoInvalidoException();
		
		acao.realizarMovimento(submarino);
		
		ValidadorSubmarino.valida(submarino);
	}
}
