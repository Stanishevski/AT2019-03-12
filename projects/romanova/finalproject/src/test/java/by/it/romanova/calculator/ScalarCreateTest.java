package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScalarCreateTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A=2", "2.0"},
                {"B=-3.5", "-3.5"},
                {"B1=45.8", "45.8"},
                {"B2=B", "-3.5"},
                {"B3=B1", "45.8"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void scalarCreateTest(String expression, String result) throws CalcException {
        assertThat(p.calc(expression).toString(), is(result));
    }

}