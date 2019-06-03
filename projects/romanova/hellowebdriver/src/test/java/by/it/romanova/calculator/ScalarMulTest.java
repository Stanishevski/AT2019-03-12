package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScalarMulTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A=2*5", "10.0"},
                {"B=A*3", "30.0"},
                {"B1=B*2", "60.0"},
                {"B2=A*8", "80.0"},
                {"B3=B2*0", "0.0"}
        };
    }

    @Test(dataProvider = "data-provider")
    public void scalarMulTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }

}