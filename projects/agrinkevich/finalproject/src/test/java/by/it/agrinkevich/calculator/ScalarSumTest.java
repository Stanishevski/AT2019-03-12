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
public class ScalarSumTest {

    @Parameterized.Parameters
    public static List<String[]> createData() {
        String[][] str = {
                {"2+3", "5.0"},
                {"0+0", "0.0"},
                {"2.33+5.12", "7.45"},
                {"43.27+5", "48.27"},
                {"55+5.12", "60.12"}
        };
        return Arrays.asList(str);
    }

    @Parameterized.Parameter(value = 0)
    public static String expression;

    @Parameterized.Parameter(value = 1)
    public static String result;

    @Test
    public void sum() throws CalcException {
        Parser parser = new Parser();
        Var actual = parser.calc(expression);
        double doubleActual = Double.parseDouble(actual.toString());
        double doubleResult = Double.parseDouble(result);
        Assert.assertEquals(doubleResult, doubleActual, 1e-10);
        System.out.println("passed: " + expression + "=" + doubleResult);
    }
}
