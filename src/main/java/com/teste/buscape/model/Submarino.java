package com.teste.buscape.model;

public class Submarino {
	protected Posicao posicao = new Posicao();
	protected Direcao direcao = Direcao.NORTE;
	
	public Posicao getPosicao() {
		return posicao;
	}

	public Direcao getDirecao() {
		return direcao;
	}

	@Override
	public String toString(){
		return posicao.toString()+" "+direcao.name();
	}
}
