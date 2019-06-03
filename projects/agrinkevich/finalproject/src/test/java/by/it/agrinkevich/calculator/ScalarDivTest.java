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
public class ScalarDivTest {

    @Parameterized.Parameters
    public static List<String[]> createData() {
        String[][] str = {
                {"8/4", "2.0"},
                {"100/20", "5.0"},
                {"8.75/3.5", "2.5"},
                {"6.6/1.1", "6.0"},
                {"22.5/5", "4.5"}

        };
        return Arrays.asList(str);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;

    @Test
    public void div() throws CalcException {
        Parser parser = new Parser();
        Var actual = parser.calc(expression);
        double doubleActual = Double.parseDouble(actual.toString());
        double doubleResult = Double.parseDouble(result);
        Assert.assertEquals(doubleResult, doubleActual, 1e-10);
        System.out.println("passed: " + expression + "=" + doubleResult);
    }
}

