package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VectorSumTest {

    private Parser p;

    @BeforeMethod
    public void parserInit(){
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"{1,2,3}+{2,3,4}", "{3.0, 5.0, 7.0}"},
                {"{4,5,6}+{2.3,6.7,2}", "{6.3, 11.7, 8.0}"},
                {"{1.3,4,6}+{0,-5,7.8}", "{1.3, -1.0, 13.8}"},
                {"{2,4,7.8}+{2,3,4}", "{4.0, 7.0, 11.8}"},
                {"{-5.3,-5,6}+{2,3,4}", "{-3.3, -2.0, 10.0}"},

         };
    }

    @Test(dataProvider = "data-provider")
    public void vectorMulTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}