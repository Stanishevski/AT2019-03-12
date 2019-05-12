package by.it.okoyro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ScalarSumTest {

	private String expression;
	private double result;

	private Parser ps;

	@Parameterized.Parameters      // на входе парсера – строка ввода выражения, на выходе – результат
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][]{
				{"1+3", 4.0},
				{"4.1+4.5", 8.6},
				{"11.12+23.23", 34.35},
				{"2+4", 6.0},
				{"0.1+0.4", 0.5}
		});
	}

	// параметры через констрктор
	public ScalarSumTest(String expression, double result) {
		this.expression = expression;
		this.result = result;
	}

	@Before
	public void initParser() {
		ps = new Parser();
	}

	@Test
	public void sum() throws CalcException {
		double actual = Double.parseDouble(String.valueOf(ps.calc(expression))); // приводим объект к стрингу а потом его к double, чтобы сравнить
		Assert.assertEquals(result, actual, 1e-15);
	}
}