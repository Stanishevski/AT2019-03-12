package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VectorSubTest {

    private Parser p;

    @BeforeMethod
    public void parserInit(){
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"{1,2,3}-{2,3,4}", "{-1.0, -1.0, -1.0}"},
                {"{4,5,6}-{2,6.5,2}", "{2.0, -1.5, 4.0}"},
                {"{1.3,4,6}-{0,-5,7.5}", "{1.3, 9.0, -1.5}"},
                {"{2,4,7.8}-{2,3,4}", "{0.0, 1.0, 3.8}"},
                {"{-5.3,-5,6}-{2,3,4}", "{-7.3, -8.0, 2.0}"},

         };
    }

    @Test(dataProvider = "data-provider")
    public void vectorSubTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}