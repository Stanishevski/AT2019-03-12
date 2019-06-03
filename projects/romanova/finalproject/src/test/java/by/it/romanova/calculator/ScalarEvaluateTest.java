package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScalarEvaluateTest {

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
            {"B=A*3.5", "25.55"},
            {"B1=B+0.11*-5", "25.0"},
            {"B2=A/2-1", "2.65"},
            {"B3=B2+4/2", "4.65"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void scalarEvaluateTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }

}