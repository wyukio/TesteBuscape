package com.teste.buscape.testcases;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Submarino;

public class TestDirecao{
	
	@Test
	public void testDirecaoNorteVirarParaEsquerdaIsEqualOeste(){
		assertEquals(Direcao.OESTE, Direcao.NORTE.virarParaEsquerda());
	}
	
	@Test
	public void testDirecaoNorteVirarParaDireitaIsEqualLeste(){
		assertEquals(Direcao.LESTE, Direcao.NORTE.virarParaDireita());
	}
	
	@Test
	public void testDirecaoLesteVirarParaEsquerdaIsEqualNorte(){
		assertEquals(Direcao.NORTE, Direcao.LESTE.virarParaEsquerda());
	}
	
	@Test
	public void testDirecaoLesteVirarParaDireitaIsEqualSul(){
		assertEquals(Direcao.SUL, Direcao.LESTE.virarParaDireita());
	}
	
	@Test
	public void testDirecaoSulVirarParaEsquerdaIsEqualLeste(){
		assertEquals(Direcao.LESTE, Direcao.SUL.virarParaEsquerda());
	}
	
	@Test
	public void testDirecaoSulVirarParaDireitaIsEqualOeste(){
		assertEquals(Direcao.OESTE, Direcao.SUL.virarParaDireita());
	}
	
	@Test
	public void testDirecaoOesteVirarParaEsquerdaIsEqualSul(){
		assertEquals(Direcao.SUL, Direcao.OESTE.virarParaEsquerda());
	}
	
	@Test
	public void testDirecaoOesteVirarParaDireitaIsEqualNorte(){
		assertEquals(Direcao.NORTE, Direcao.OESTE.virarParaDireita());
	}
	
	@Test
	public void testDirecaoNorteAumentaEixoY() throws SubmarinoAcimaDoNivelDoMarException{
		final int y = 5;
		Submarino submarino = new Submarino(5, y, -10, Direcao.NORTE);
		submarino.getDirecao().mover(submarino);
		assertEquals(y+1, submarino.getPosicao().getY());
	}
	
	@Test
	public void testDirecaoSulDiminuiEixoY() throws SubmarinoAcimaDoNivelDoMarException{
		final int y = 5;
		Submarino submarino = new Submarino(5, y, -10, Direcao.SUL);
		submarino.getDirecao().mover(submarino);
		assertEquals(y-1, submarino.getPosicao().getY());
	}
	
	@Test
	public void testDirecaoLesteAumentaEixoX() throws SubmarinoAcimaDoNivelDoMarException{
		final int x = 5;
		Submarino submarino = new Submarino(x, 1, -10, Direcao.LESTE);
		submarino.getDirecao().mover(submarino);
		assertEquals(x+1, submarino.getPosicao().getX());
	}
	
	@Test
	public void testDirecaoOesteDiminuiEixoX() throws SubmarinoAcimaDoNivelDoMarException{
		final int x = 5;
		Submarino submarino = new Submarino(x, 1, -10, Direcao.OESTE);
		submarino.getDirecao().mover(submarino);
		assertEquals(x-1, submarino.getPosicao().getX());
	}
}
