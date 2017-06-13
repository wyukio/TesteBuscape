package com.teste.buscape.exceptions;

/**
 * Exception caso o submarino ultrapasse o nivel do mar (aka. eixo z > 0)
 */
public class SubmarinoAcimaDoNivelDoMarException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public SubmarinoAcimaDoNivelDoMarException() {
		super("Submarino acima do nível do mar.");
	}

}
