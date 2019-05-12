package by.it.okoyro.at14;

import by.it.okoyro.at13.CalcException;
import by.it.okoyro.at13.Parser;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ScalarDivTest {
	@Parameterized.Parameters
	public static Collection<Object[]> testParams() {
		return Arrays.asList(new Object[][]{
				{"4/2", 2},
				{"100/20", 5},
				{"5/5.0", 1.0},
				{"11.1/1", 11.1},
				{"0.8/0.5", 1.6}
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
	public void div() throws CalcException {
		double actual = Double.parseDouble(String.valueOf(ps.calc(expression))); // приводим объект к стрингу а потом его к double, чтобы сравнить
		Assert.assertEquals(result, actual, 1e-15);
	}
}
