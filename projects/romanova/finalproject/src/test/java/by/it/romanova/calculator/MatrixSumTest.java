package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class MatrixSumTest {

    private Parser p;

    @BeforeMethod
    public void parserInit(){
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"{{1,2.0,3},{4,5,6},{7, 8,9}}+{{1,2.8,3},{4,0,6},{7,8,-9}}", "{{2.0, 4.8, 6.0}, {8.0, 5.0, 12.0}, {14.0, 16.0, 0.0}}"},
                {"{{1,2,3},{4,5,6.4},{7, 8,9}}+{{1,0,3},{4,0,6},{7,8,-9}}", "{{2.0, 2.0, 6.0}, {8.0, 5.0, 12.4}, {14.0, 16.0, 0.0}}"},
                {"{{1,2},{4,5}}+{{1,2},{5,6}}", "{{2.0, 4.0}, {9.0, 11.0}}"},
                {"{{1,8},{4,5}}+{{1,-2},{5,6}}", "{{2.0, 6.0}, {9.0, 11.0}}"},
                {"{{1,2.5},{4,5.5}}+{{1,-2},{5,-6}}", "{{2.0, 0.5}, {9.0, -0.5}}"},

         };
    }

    @Test(dataProvider = "data-provider")
    public void matrixSumTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}