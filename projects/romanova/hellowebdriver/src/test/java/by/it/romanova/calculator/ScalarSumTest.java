package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScalarSumTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A=2+5.3", "7.3"},
                {"B=A+3.5", "10.8"},
                {"B1=B+2", "12.8"},
                {"B2=A+89.5", "96.8"},
                {"B3=B2+80.2", "177.0"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void scalarSumTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }

}