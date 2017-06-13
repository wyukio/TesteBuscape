package com.teste.buscape.validadores;

import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.model.Submarino;

public class ValidadorSubmarino {
	public static void valida(Submarino submarino) throws SubmarinoAcimaDoNivelDoMarException{
		if(submarino.getPosicao().getZ() > 0)
			throw new SubmarinoAcimaDoNivelDoMarException();
	}
}
