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
public class ScalarSubTest {

	@Parameterized.Parameters
	public static Collection<Object[]> testParams() {
		return Arrays.asList(new Object[][]{
				{"1-3", -2.0},
				{"100-4.5", 95.5},
				{"5-1.0", 4.0},
				{"11.1-11.1", 0},
				{"0.8-0.4", 0.4}
		});
	}

	// параметры через аннотацию
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
	public void sub() throws CalcException {
		double actual = Double.parseDouble(String.valueOf(ps.calc(expression))); // приводим объект к стрингу а потом его к double, чтобы сравнить
		Assert.assertEquals(result, actual, 1e-15);
	}

}
