package by.it.agrinkevich.calculator;

import by.it.agrinkevich.webcalculator.calculator.CalcException;
import by.it.agrinkevich.webcalculator.calculator.Parser;
import by.it.agrinkevich.webcalculator.calculator.Var;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;


@RunWith(value = Parameterized.class)
public class MatrixSumTest {

    public static Parser parser = new Parser();

    @Parameterized.Parameters
    public static List<String[]> createData() {
        String[][] str = {
                {"{{1, 2, 3}, {1, 2, 3}, {1, 2, 3}} + {{1, 2, 3}, {1, 2, 3}, {1, 2, 3}}", "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}"},
                {"{{1, 2, 3},{1, 2, 3}} + 3", "{{4.0, 5.0, 6.0}, {4.0, 5.0, 6.0}}"}
        };
        return Arrays.asList(str);
    }

    @Parameterized.Parameter(value = 0)
    public static String expression;

    @Parameterized.Parameter(value = 1)
    public static String result;

    @Test
    public void sum() throws CalcException {
        Var actual = parser.calc(expression);
        Assert.assertThat(result, is(actual.toString()));
        System.out.println("passed: " + expression + "=" + result);
    }
}