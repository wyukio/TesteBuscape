package com.teste.buscape.model;

import java.util.function.Consumer;

public class Submarino {
	protected Posicao posicao = new Posicao();
	protected Direcao direcao = Direcao.NORTE;
	
	public Submarino(){}
	
	public Submarino(int x, int y, int z, Direcao direcao){
		this.posicao = new Posicao(x,y,z);
		this.direcao = direcao != null ? direcao : Direcao.NORTE;
	}
	
	public Posicao getPosicao() {
		return posicao;
	}

	public Direcao getDirecao() {
		return direcao;
	}
	
	public void mover(Consumer<Submarino> consumer){
		consumer.accept(this);
	}
	
	@Override
	public String toString(){
		return posicao.toString()+" "+direcao.name();
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((direcao == null) ? 0 : direcao.hashCode());
		result = prime * result + ((posicao == null) ? 0 : posicao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Submarino other = (Submarino) obj;
		if (direcao != other.direcao)
			return false;
		if (posicao == null) {
			if (other.posicao != null)
				return false;
		} else if (!posicao.equals(other.posicao))
			return false;
		return true;
	}
}
