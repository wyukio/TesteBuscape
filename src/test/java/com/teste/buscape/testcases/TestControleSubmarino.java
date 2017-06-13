package com.teste.buscape.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.teste.buscape.exceptions.ComandoInvalidoException;
import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.exceptions.SubmarinoNaoExistenteException;
import com.teste.buscape.model.ControleSubmarino;
import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Submarino;

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
	public void testControleSubir() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		ControleSubmarino.controlarSubmarino(SUBIR, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.mover(ControleSubmarino::subir);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}

	@Test
	public void testControleDescer() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		ControleSubmarino.controlarSubmarino(DESCER, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.mover(ControleSubmarino::descer);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}

	@Test
	public void testControleVirarParaEsquerda() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		ControleSubmarino.controlarSubmarino(VIRAR_PARA_ESQUERDA, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.mover(ControleSubmarino::virarParaEsquerda);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}

	@Test
	public void testControleVirarParaDireita() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		ControleSubmarino.controlarSubmarino(VIRAR_PARA_DIREITA, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.mover(ControleSubmarino::virarParaDireita);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}
	
	@Test
	public void testControleMover() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		ControleSubmarino.controlarSubmarino(MOVER, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.mover(ControleSubmarino::mover);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}
	
	@Test
	public void testControleInvalido() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		thrown.expect(ComandoInvalidoException.class);
		ControleSubmarino.controlarSubmarino(COMANDO_INVALIDO, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
	}
	
	@Test
	public void testControleSubmarinoAcimaNivelDoMar() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		thrown.expect(SubmarinoAcimaDoNivelDoMarException.class);
		ControleSubmarino.controlarSubmarino(SUBIR, new Submarino());
	}
	
	@Test
	public void testControleSubmarinoNulo() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		thrown.expect(SubmarinoNaoExistenteException.class);
		ControleSubmarino.controlarSubmarino(SUBIR, null);
	}
}
