package by.it.romanova;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

@RunWith(value = Parameterized.class)
public class MatrixExceptionTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<String> parameters(){
        return Arrays.asList("A={{1,2.0,3},{4,5,6},{7, 8,9}}/{{1,2.5,3},{4,0,6},{7,8,-9}}",
                "B=abc",
                "B1={{1,2},{4,5}}/0",
                "B2={{1,2},{4,5}}+{{1,2.0,3},{4,5,6},{7, 8,9}}",
                "B3={{1,2},{4,5}}-{{1,2.0,3},{4,5,6},{7, 8,9}}");
    }

    @Parameter
    public String expression;


    @Test(expected = CalcException.class)
    public void scalarEvaluateTest() throws CalcException {
        p.calc(expression);
    }

}