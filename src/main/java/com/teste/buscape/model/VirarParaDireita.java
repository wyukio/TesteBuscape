package com.teste.buscape.model;

public class VirarParaDireita implements Acao {

	@Override
	public void realizarMovimento(Submarino submarino) {
		submarino.direcao = submarino.direcao.virarParaDireita();
	}

}
