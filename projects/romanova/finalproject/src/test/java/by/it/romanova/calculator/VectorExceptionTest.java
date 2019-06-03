package by.it.romanova.calculator;

import by.it.romanova.CalcException;
import by.it.romanova.Parser;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class VectorExceptionTest {

    private Parser p;

    @BeforeMethod
    public void parserInit()
    {
        p = new Parser();
    }

    @DataProvider(name = "data-provider")
    public static Object[][] parameters(){
        return new Object[][]{
                {"A={1,2,3}/{2,3,4}"},
                {"B={2,5,6,7}-{2,4}"},
                {"B1={5,7,0}/0"},
                {"B2={7,8,9,6}*{8,8}"},
                {"B3={6,7,8}+{9,0}"}};
    }


    @Test(
            expectedExceptions = CalcException.class,
            dataProvider = "data-provider")
    public void vectorExceptionTest(String data) throws CalcException {
        p.calc(data);
    }

}