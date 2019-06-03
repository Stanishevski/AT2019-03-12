package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class ScalarExceptionTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A=2/0"},
                {"B=-6/0"},
                {"B1=0/0"},
                {"B2=jjj"},
                {"B3=o"}
        };
    }

    @Test(
            expectedExceptions = CalcException.class,
            dataProvider = "data-provider")
    public void scalarExceptionTest(String expression) throws CalcException {
        p.calc(expression);
    }

}