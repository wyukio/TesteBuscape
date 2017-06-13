package com.teste.buscape.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.teste.buscape.model.Acao;
import com.teste.buscape.model.Descer;
import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Mover;
import com.teste.buscape.model.Subir;
import com.teste.buscape.model.Submarino;
import com.teste.buscape.model.VirarParaDireita;
import com.teste.buscape.model.VirarParaEsquerda;

public class TestAcoes {
	
	private final Submarino SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE = new Submarino(3,4,-10,Direcao.NORTE);
	private final Submarino SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY = new Submarino(3,4,-10,Direcao.NORTE);
	private static final Acao ACAO_DESCER = new Descer(); 
	private static final Acao ACAO_SUBIR = new Subir(); 
	private static final Acao ACAO_MOVER = new Mover(); 
	private static final Acao ACAO_VIRAR_ESQUERDA = new VirarParaEsquerda(); 
	private static final Acao ACAO_VIRAR_DIREITA = new VirarParaDireita(); 
	
	@Test
	public void testAcaoDescer(){
		int eixoZAnterior = SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ();
		ACAO_DESCER.realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		assertEquals(eixoZAnterior-1, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ());
	}
	
	@Test
	public void testAcaoSubir(){
		int eixoZAnterior = SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ();
		ACAO_SUBIR.realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		assertEquals(eixoZAnterior+1, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ());
	}
	
	@Test
	public void testAcaoMover(){
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getDirecao().mover(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		ACAO_MOVER.realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}
	
	@Test
	public void testAcaoVirarParaEsqueda(){
		ACAO_VIRAR_ESQUERDA.realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getDirecao(), SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.getDirecao().virarParaEsquerda());
	}
	
	@Test
	public void testAcaoVirarParaDireita(){
		ACAO_VIRAR_DIREITA.realizarMovimento(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getDirecao(), SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.getDirecao().virarParaDireita());
	}
}
