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
public class VectorSubTest {

    public static Parser parser = new Parser();

    @Parameterized.Parameters
    public static List<String[]> createData() {
        String[][] str = {
                {"{8, 7, 6}-3", "{5.0, 4.0, 3.0}"},
                {"{6, 5, 4} - {1, 2, 3}", "{5.0, 3.0, 1.0}"}
        };
        return Arrays.asList(str);
    }

    @Parameterized.Parameter(value = 0)
    public static String expression;

    @Parameterized.Parameter(value = 1)
    public static String result;

    @Test
    public void sub() throws CalcException {
        Var actual = parser.calc(expression);
        Assert.assertEquals(result, actual.toString());
        System.out.println("passed: " + expression + "=" + result);
    }
}