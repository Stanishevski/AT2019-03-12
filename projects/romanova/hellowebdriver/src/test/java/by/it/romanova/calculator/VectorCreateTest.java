package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VectorCreateTest {

    private Parser p;

    @BeforeMethod
    public void parserInit(){
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A={1,2,3}", "{1.0, 2.0, 3.0}"},
                {"B=A", "{1.0, 2.0, 3.0}"},
                {"C={1.3,4,6}", "{1.3, 4.0, 6.0}"},
                {"B2={-3,5.0,0,5.5,-8}", "{-3.0, 5.0, 0.0, 5.5, -8.0}"},
                {"B3={   5,    5,5,-6}", "{5.0, 5.0, 5.0, -6.0}"},

         };
    }

    @Test(dataProvider = "data-provider")
    public void vectorCreateTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}