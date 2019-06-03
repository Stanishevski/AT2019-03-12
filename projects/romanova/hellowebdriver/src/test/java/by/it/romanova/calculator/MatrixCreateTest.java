package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class MatrixCreateTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A={{1,2.0,3},{4,5,6},{7, 8,9}}", "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}"},
                {"B=A", "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}"},
                {"B1={{1,2},{4,5}}", "{{1.0, 2.0}, {4.0, 5.0}}"},
                {"B2={{0,4,5},{-4,0.0,5},{4,6,7},{3,4,5}}", "{{0.0, 4.0, 5.0}, {-4.0, 0.0, 5.0}, {4.0, 6.0, 7.0}, {3.0, 4.0, 5.0}}"},
                {"B3={{3,4,5},{-6,7,8},{5,6,7}}", "{{3.0, 4.0, 5.0}, {-6.0, 7.0, 8.0}, {5.0, 6.0, 7.0}}"}
        };
    }


    @Test(dataProvider = "data-provider")
    public void matrixCreateTest(String expression, String result) throws CalcException {
        assertThat(p.calc(expression).toString(), is(result));
    }

}