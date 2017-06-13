package com.teste.buscape.main;

import com.teste.buscape.exceptions.ComandoInvalidoException;
import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.exceptions.SubmarinoNaoExistenteException;
import com.teste.buscape.model.ControleSubmarino;
import com.teste.buscape.model.Submarino;

public class Main {
	public static void main(String[] args) throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException {
		String[] comandos = args[0].split("");
		Submarino submarino = new Submarino();
		
		for(String comando : comandos){
			ControleSubmarino.controlarSubmarino(comando, submarino);
		}
		
		System.out.print(submarino);
	}
}
