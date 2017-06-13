package com.teste.buscape.model;

public class VirarParaEsquerda implements Acao {

	@Override
	public void realizarMovimento(Submarino submarino) {
		submarino.direcao = submarino.direcao.virarParaEsquerda();
	}

}
