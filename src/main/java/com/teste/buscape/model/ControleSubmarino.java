package com.teste.buscape.model;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Consumer;

import com.teste.buscape.exceptions.ComandoInvalidoException;
import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.exceptions.SubmarinoNaoExistenteException;
import com.teste.buscape.validadores.ValidadorSubmarino;

public class ControleSubmarino {
	private static final Map<String,Consumer<Submarino>> ACOES;
	
	static{
		ACOES = new HashMap<String, Consumer<Submarino>>();
		ACOES.put("L", ControleSubmarino::virarParaEsquerda);
		ACOES.put("R", ControleSubmarino::virarParaDireita);
		ACOES.put("U", ControleSubmarino::subir);
		ACOES.put("D", ControleSubmarino::descer);
		ACOES.put("M", ControleSubmarino::mover);
	}
	
	public static void controlarSubmarino(String comando, Submarino submarino) throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		if(submarino == null)
			throw new SubmarinoNaoExistenteException();
			
		Consumer<Submarino> acao = ACOES.get(comando);
		
		if(acao == null)
			throw new ComandoInvalidoException();
		
		submarino.mover(acao);
		
		ValidadorSubmarino.valida(submarino);
	}
	
	public static void subir(Submarino submarino){
		submarino.posicao.z++;
	}
	
	public static void descer(Submarino submarino){
		submarino.posicao.z--;
	}
	
	public static void mover(Submarino submarino){
		submarino.direcao.mover(submarino);
	}
	
	public static void virarParaEsquerda(Submarino submarino){
		submarino.direcao = submarino.direcao.virarParaEsquerda();
	}
	
	public static void virarParaDireita(Submarino submarino){
		submarino.direcao = submarino.direcao.virarParaDireita();
	}
}
