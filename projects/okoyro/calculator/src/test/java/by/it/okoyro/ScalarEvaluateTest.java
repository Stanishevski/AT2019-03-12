package by.it.okoyro;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class ScalarEvaluateTest {

	private Parser ps;

	@Parameterized.Parameters      // на входе парсера – строка ввода выражения, на выходе – результат
	public static Collection<Object[]> getTestParameters() {
		return Arrays.asList(new Object[][]{
				{"A=6/3", 2.0},
				{"B=A*11", 22},
				{"C=B+17", 39.0},
				{"D=C-C", 0},
				{"E=D+1", 1}
		});
	}

	@Parameterized.Parameter
	public String expression;

	@Parameterized.Parameter(1)
	public double result;

	@Before
	public void initParser() {
		ps = new Parser();
	}

	@Test
	public void evaluate() throws CalcException {
		double actual = Double.parseDouble(String.valueOf(ps.calc(expression))); // приводим объект к стрингу а потом его к double, чтобы сравнить
		Assert.assertEquals(result, actual, 1e-15);
	}
}
