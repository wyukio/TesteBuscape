package com.teste.buscape.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.teste.buscape.exceptions.ComandoInvalidoException;
import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.model.ControleSubmarino;
import com.teste.buscape.model.Descer;
import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Mover;
import com.teste.buscape.model.Subir;
import com.teste.buscape.model.Submarino;
import com.teste.buscape.model.VirarParaDireita;
import com.teste.buscape.model.VirarParaEsquerda;

public class TestControleSubmarino {
	
	private static final String SUBIR = "U";
	private static final String DESCER = "D";
	private static final String VIRAR_PARA_DIREITA = "R";
	private static final String VIRAR_PARA_ESQUERDA = "L";
	private static final String MOVER = "M";
	private static final String COMANDO_INVALIDO = "XPTO";
	private final Submarino SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE = new Submarino(3,4,-10,Direcao.NORTE);
	private final Submarino SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY = new Submarino(3,4,-10,Direcao.NORTE);
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testControleSubir() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		ControleSubmarino.controlarSubmarino(SUBIR, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		new Subir().realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
		
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}

	@Test
	public void testControleDescer() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		ControleSubmarino.controlarSubmarino(DESCER, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		new Descer().realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
		
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}

	@Test
	public void testControleVirarParaEsquerda() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		ControleSubmarino.controlarSubmarino(VIRAR_PARA_ESQUERDA, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		new VirarParaEsquerda().realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
		
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}

	@Test
	public void testControleVirarParaDireita() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		ControleSubmarino.controlarSubmarino(VIRAR_PARA_DIREITA, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		new VirarParaDireita().realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
		
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}
	
	@Test
	public void testControleMover() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		ControleSubmarino.controlarSubmarino(MOVER, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		new Mover().realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
		
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}
	
	@Test
	public void testControleInvalido() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		thrown.expect(ComandoInvalidoException.class);
		ControleSubmarino.controlarSubmarino(COMANDO_INVALIDO, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
	}
	
	@Test
	public void testControleSubmarinoAcimaNivelDoMar() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException{
		thrown.expect(SubmarinoAcimaDoNivelDoMarException.class);
		ControleSubmarino.controlarSubmarino(SUBIR, new Submarino());
	}
}
