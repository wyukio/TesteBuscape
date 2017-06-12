package com.teste.buscape.model;

public class Posicao {
	protected int x = 0;
	protected int y = 0;
	protected int z = 0;
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getZ() {
		return z;
	}

	@Override
	public String toString(){
		return x+" "+y+" "+z;
	}
}
