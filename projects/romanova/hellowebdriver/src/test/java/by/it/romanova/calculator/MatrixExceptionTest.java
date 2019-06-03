package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MatrixExceptionTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A={{1,2.0,3},{4,5,6},{7, 8,9}}/{{1,2.5,3},{4,0,6},{7,8,-9}}"},
                {"B=abc"},
                {"B1={{1,2},{4,5}}/0"},
                {"B2={{1,2},{4,5}}+{{1,2.0,3},{4,5,6},{7, 8,9}}"},
                {"B3={{1,2},{4,5}}-{{1,2.0,3},{4,5,6},{7, 8,9}}"}};
    }

    @Test(
            expectedExceptions = CalcException.class,
            dataProvider = "data-provider")
    public void matrixExceptionTest(String expression) throws CalcException {
        p.calc(expression);
    }

}