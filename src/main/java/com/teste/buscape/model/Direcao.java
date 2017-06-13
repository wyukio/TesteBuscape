package com.teste.buscape.model;

public enum Direcao {
	NORTE{
		@Override
		public Direcao virarParaEsquerda() {
			return Direcao.OESTE;
		}

		@Override
		public Direcao virarParaDireita() {
			return Direcao.LESTE;
		}

		@Override
		public void mover(Submarino submarino) {
			submarino.posicao.y++;
		}
	},
 	SUL{
		@Override
		public Direcao virarParaEsquerda() {
			return Direcao.LESTE;
		}

		@Override
		public Direcao virarParaDireita() {
			return Direcao.OESTE;
		}

		@Override
		public void mover(Submarino submarino) {
			submarino.posicao.y--;
		}
	},
 	LESTE {
		@Override
		public Direcao virarParaEsquerda() {
			return Direcao.NORTE;
		}

		@Override
		public Direcao virarParaDireita() {
			return Direcao.SUL;
		}

		@Override
		public void mover(Submarino submarino) {
			submarino.posicao.x++;
		}
	},
	OESTE{
		@Override
		public Direcao virarParaEsquerda() {
			return Direcao.SUL;
		}

		@Override
		public Direcao virarParaDireita() {
			return Direcao.NORTE;
		}

		@Override
		public void mover(Submarino submarino) {
			submarino.posicao.x--;
		}
	};
	
	public abstract Direcao virarParaEsquerda();
	public abstract Direcao virarParaDireita();
	public abstract void mover(Submarino submarino);
}
