package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VectorEvaluateTest {

    private Parser p;

    @BeforeMethod
    public void parserInit(){
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A={1,2,3}*{2,3,4}", "20.0"},
                {"B=A*13", "260.0"},
                {"C={1.3,4,6}*-5", "{-6.5, -20.0, -30.0}"},
                {"B2=B*C", "{-1690.0, -5200.0, -7800.0}"},
                {"B3={5,5,5,6}*0", "{0.0, 0.0, 0.0, 0.0}"},

         };
    }

    @Test(dataProvider = "data-provider")
    public void vectorEvaluateTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}