package by.it.okoyro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ScalarMulTest {

	@Parameterized.Parameters
	public static Collection<Object[]> testParams() {
		return Arrays.asList(new Object[][]{
				{"4*7", 28},
				{"100*1.0", 100},
				{"5*5.0", 25.0},
				{"11.1*0", 0},
				{"0.8*0.5", 0.4}
		});
	}

	@Parameterized.Parameter(value = 0) // not necessary is 0 by default
	public String expression;

	@Parameterized.Parameter(value = 1)
	public double result;

	private Parser ps;

	@Before
	public void initParser() {
		ps = new Parser();
	}

	@Test
	public void mul() throws CalcException {
		double actual = Double.parseDouble(String.valueOf(ps.calc(expression))); // приводим объект к стрингу а потом его к double, чтобы сравнить
		Assert.assertEquals(result, actual, 1e-15);
	}
}
