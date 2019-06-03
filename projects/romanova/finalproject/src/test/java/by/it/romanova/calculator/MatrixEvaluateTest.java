package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatrixEvaluateTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
            {"A={{1,2.0,3},{4,5,6},{7, 8,9}}+{{1,2.5,3},{4,0,6},{7,8,-9}}", "{{2.0, 4.5, 6.0}, {8.0, 5.0, 12.0}, {14.0, 16.0, 0.0}}"},
            {"B=A*3.5", "{{7.0, 15.75, 21.0}, {28.0, 17.5, 42.0}, {49.0, 56.0, 0.0}}"},
            {"B1={{1,2},{4,5}}*{{1,2},{5,6}}", "{{11.0, 14.0}, {29.0, 38.0}}"},
            {"B2=B1+3.5", "{{14.5, 17.5}, {32.5, 41.5}}"},
            {"B3=B1-B2", "{{-3.5, -3.5}, {-3.5, -3.5}}"}
        };
    }


    @Test(dataProvider = "data-provider")
    public void matrixEvaluateTest(String expression, String result) throws CalcException {
        assertThat(p.calc(expression).toString(), is(result));
    }

}