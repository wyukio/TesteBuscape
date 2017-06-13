package com.teste.buscape.testcases;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.teste.buscape.exceptions.ComandoInvalidoException;
import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Submarino;
import com.teste.buscape.validadores.ValidadorSubmarino;

public class TestValidadorSubmarino {
	
	private static final Submarino SUBMARINO_ACIMA_NIVEL_DO_MAR = new Submarino(-5,1,4,Direcao.NORTE);
	private static final Submarino SUBMARINO_NO_NIVEL_DO_MAR = new Submarino(5,-5,0,Direcao.NORTE);
	private static final Submarino SUBMARINO_ABAIXO_NIVEL_DO_MAR = new Submarino(0,12,-5,Direcao.NORTE);
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testAcimaDoNivelDoMar() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		thrown.expect(SubmarinoAcimaDoNivelDoMarException.class);
		ValidadorSubmarino.valida(SUBMARINO_ACIMA_NIVEL_DO_MAR);
	}
	
	@Test
	public void testNoNivelDoMar() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		ValidadorSubmarino.valida(SUBMARINO_NO_NIVEL_DO_MAR);
	}
	
	@Test
	public void testAbaixoDoNivelDoMar() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		ValidadorSubmarino.valida(SUBMARINO_ABAIXO_NIVEL_DO_MAR);
	}
}
