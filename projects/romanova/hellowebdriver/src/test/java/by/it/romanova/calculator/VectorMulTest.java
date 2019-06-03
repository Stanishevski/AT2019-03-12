package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class VectorMulTest {

    private Parser p;

    @BeforeMethod
    public void parserInit(){
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"{1,2,3}*{2,3,4}", "20.0"},
                {"{4,5,6}*{2.3,6.7,2}", "54.7"},
                {"{1.3,4,6}*{0,-5,7}", "22.0"},
                {"{2,4,7.8}*{2,3,4}", "47.2"},
                {"{-5,-5,6}*{2,3,4}", "-1.0"},

         };
    }

    @Test(dataProvider = "data-provider")
    public void vectorMulTest(String expression, String expected) throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}