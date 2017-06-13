package com.teste.buscape.testcases;

import static org.junit.Assert.assertEquals;

import java.util.function.Consumer;

import org.junit.Test;

import com.teste.buscape.model.ControleSubmarino;
import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Submarino;

public class TestAcoes {
	
	private final Submarino SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE = new Submarino(3,4,-10,Direcao.NORTE);
	private final Submarino SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY = new Submarino(3,4,-10,Direcao.NORTE);
	private static final Consumer<Submarino> ACAO_DESCER = ControleSubmarino::descer; 
	private static final Consumer<Submarino> ACAO_SUBIR = ControleSubmarino::subir; 
	private static final Consumer<Submarino> ACAO_MOVER = ControleSubmarino::mover; 
	private static final Consumer<Submarino> ACAO_VIRAR_ESQUERDA = ControleSubmarino::virarParaEsquerda; 
	private static final Consumer<Submarino> ACAO_VIRAR_DIREITA = ControleSubmarino::virarParaDireita; 
	
	@Test
	public void testAcaoDescer(){
		int eixoZAnterior = SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ();
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.mover(ACAO_DESCER);
		assertEquals(eixoZAnterior-1, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ());
	}
	
	@Test
	public void testAcaoSubir(){
		int eixoZAnterior = SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ();
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.mover(ACAO_SUBIR);
		assertEquals(eixoZAnterior+1, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getPosicao().getZ());
	}
	
	@Test
	public void testAcaoMover(){
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getDirecao().mover(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE);
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.mover(ACAO_MOVER);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE, SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY);
	}
	
	@Test
	public void testAcaoVirarParaEsqueda(){
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.mover(ACAO_VIRAR_ESQUERDA);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getDirecao(), SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.getDirecao().virarParaEsquerda());
	}
	
	@Test
	public void testAcaoVirarParaDireita(){
		SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.mover(ACAO_VIRAR_DIREITA);
		assertEquals(SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE.getDirecao(), SUBMARINO_X3_Y4_Z10_NEGATIVO_NORTE_COPY.getDirecao().virarParaDireita());
	}
}
