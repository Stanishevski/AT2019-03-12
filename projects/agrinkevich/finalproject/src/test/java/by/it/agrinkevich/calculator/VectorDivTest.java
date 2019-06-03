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


@RunWith(value = Parameterized.class)
public class VectorDivTest {

    public static Parser parser = new Parser();

    @Parameterized.Parameters
    public static List<String[]> createData() {
        String[][] str = {
                {"{12, 10, 8}/2", "{6.0, 5.0, 4.0}"},
                {"{4.2, 6.3, 8.4}/2.1", "{2.0, 3.0, 4.0}"}
        };
        return Arrays.asList(str);
    }

    @Parameterized.Parameter(value = 0)
    public static String expression;

    @Parameterized.Parameter(value = 1)
    public static String result;

    @Test
    public void div() throws CalcException {
        Var actual = parser.calc(expression);
        Assert.assertEquals(result, actual.toString());
        System.out.println("passed: " + expression + "=" + result);
    }
}