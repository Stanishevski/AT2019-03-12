package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScalarDivTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A=20/5", "4.0"},
                {"B=A/2", "2.0"},
                {"B1=120/B", "60.0"},
                {"B2=B1/3", "20.0"},
                {"B3=B2/A", "5.0"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void scalarDivTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }

}