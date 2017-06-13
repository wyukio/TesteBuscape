package com.teste.buscape.testcases;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Submarino;

public class TesteSubmarino{
	
	private static final Submarino SUBMARINO_DEFAULT = new Submarino();
	private static final Submarino SUBMARINO_X1_Y2_Z3_NEGATIVO_SUL = new Submarino(1,2,-3,Direcao.SUL);
	
	@Test
	public void testConstrutorPadraoPosicaoZeroEixosDirecaoNorte(){
		assertEquals(0, SUBMARINO_DEFAULT.getPosicao().getX());
		assertEquals(0, SUBMARINO_DEFAULT.getPosicao().getY());
		assertEquals(0, SUBMARINO_DEFAULT.getPosicao().getZ());
		assertEquals(Direcao.NORTE, SUBMARINO_DEFAULT.getDirecao());
	}
	
	@Test
	public void testConstrutorInicializaVariaveis(){
		assertEquals(1, SUBMARINO_X1_Y2_Z3_NEGATIVO_SUL.getPosicao().getX());
		assertEquals(2, SUBMARINO_X1_Y2_Z3_NEGATIVO_SUL.getPosicao().getY());
		assertEquals(-3, SUBMARINO_X1_Y2_Z3_NEGATIVO_SUL.getPosicao().getZ());
		assertEquals(Direcao.SUL, SUBMARINO_X1_Y2_Z3_NEGATIVO_SUL.getDirecao());
	}
	
}
