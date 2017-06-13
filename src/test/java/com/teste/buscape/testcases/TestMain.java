package com.teste.buscape.testcases;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.teste.buscape.exceptions.ComandoInvalidoException;
import com.teste.buscape.exceptions.SubmarinoAcimaDoNivelDoMarException;
import com.teste.buscape.exceptions.SubmarinoNaoExistenteException;
import com.teste.buscape.main.Main;
import com.teste.buscape.model.Direcao;
import com.teste.buscape.model.Submarino;

public class TestMain {
	
	private static final String[] INPUT_README = {"RMMLMMMDDLL"};
	private static final String[] INPUT_1 = {"DDRRLMMMLMDRRRMDDDUMMMMM"};
	private static final String[] INPUT_2 = {"DDDLLLMMRRMMMUUMMMDDDMRRRRRM"};
	private static final String[] INPUT_3 = {"DDMMMRRRRMMDMUUUMMLLLLMMRLMLRM"};
	private static final String[] INPUT_ACIMA_NIVEL_MAR = {"DDDMMMLLLLMRRMMMUUUUUU"};
	private static final String[] INPUT_COMANDO_INVALIDO = {"XPTO"};
	private static final String RESULT_README  = new Submarino(2,3,-2,Direcao.SUL).toString();
	private static final String RESULT_INPUT_1 = new Submarino(-3,1,-5,Direcao.OESTE).toString();
	private static final String RESULT_INPUT_2 = new Submarino(-5,1,-4,Direcao.NORTE).toString();
	private static final String RESULT_INPUT_3 = new Submarino(0,12,0,Direcao.NORTE).toString();
	private final ByteArrayOutputStream consoleOutput = new ByteArrayOutputStream();
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void preparaConsole(){
		System.setOut(new PrintStream(consoleOutput));
	}
	
	@After
	public void finalizaConsole(){
		System.setOut(null);
	}
	
	@Test
	public void testDoReadMe() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		Main.main(INPUT_README);
		assertEquals(consoleOutput.toString(), RESULT_README);
	}
	
	@Test
	public void testDoInput1() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		Main.main(INPUT_1);
		assertEquals(consoleOutput.toString(), RESULT_INPUT_1);
	}
	
	@Test
	public void testDoInput2() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		Main.main(INPUT_2);
		assertEquals(consoleOutput.toString(), RESULT_INPUT_2);
	}
	
	@Test
	public void testInput3() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		Main.main(INPUT_3);
		assertEquals(consoleOutput.toString(), RESULT_INPUT_3);
	}
	
	@Test
	public void testAcimaDoNivelDoMar() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		thrown.expect(SubmarinoAcimaDoNivelDoMarException.class);
		Main.main(INPUT_ACIMA_NIVEL_MAR);
	}
	
	@Test
	public void testComandoInvalido() throws SubmarinoAcimaDoNivelDoMarException, ComandoInvalidoException, SubmarinoNaoExistenteException{
		thrown.expect(ComandoInvalidoException.class);
		Main.main(INPUT_COMANDO_INVALIDO);
	}
}
