package com.teste.buscape.model;

public class Descer implements Acao {

	@Override
	public void realizarMovimento(Submarino submarino) {
		submarino.posicao.z--;
	}

}
