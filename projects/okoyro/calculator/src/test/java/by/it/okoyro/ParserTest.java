package by.it.okoyro;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {

	@Test
	public void calcScalarAddTest() throws Exception {
		Parser p = new Parser();
		Var actual = p.calc("2+5.3");
		double actualValue = Double.parseDouble(actual.toString());
		double expectedValue = 7.3;
		assertEquals("Сложение работает неверно", expectedValue, actualValue, 1e-10);
	}

	@Test
	public void calcScalarSubTest() throws Exception {
		Parser p = new Parser();
		Var actual = p.calc("17-1.3");
		double actualValue = Double.parseDouble(actual.toString());
		double expectedValue = 15.7;
		assertEquals("Вычитание работает неверно", expectedValue, actualValue, 1e-10);
	}

	@Test
	public void calcScalarMulTest() throws Exception {
		Parser p = new Parser();
		Var actual = p.calc("1.2*8.9");
		double actualValue = Double.parseDouble(actual.toString());
		double expectedValue = 10.68;
		assertEquals("Умножение работает неверно", expectedValue, actualValue, 1e-10);
	}

	@Test
	public void calcScalarDivTest() throws Exception {
		Parser p = new Parser();
		Var actual = p.calc("12/4");
		double actualValue = Double.parseDouble(actual.toString());
		double expectedValue = 3;
		assertEquals("Деление работает неверно", expectedValue, actualValue, 1e-10);
	}
}