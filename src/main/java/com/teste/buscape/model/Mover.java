package com.teste.buscape.model;

public class Mover implements Acao {

	@Override
	public void realizarMovimento(Submarino submarino) {
		submarino.direcao.mover(submarino);
	}

}
