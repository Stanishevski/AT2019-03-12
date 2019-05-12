package by.it.romanova.calc_at14;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(value = Parameterized.class)
public class ScalarExceptionTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<String> parameters(){
        List<String> strings = Arrays.asList(new String[]{
                "A=2/0",
                "B=-6/0",
                "B1=0/0",
                "B2=jjj",
                "B3=o"
        });
        return strings;
    }

    @Parameter
    public String expression;


    @Test(expected = CalcException.class)
    public void scalarEvaluateTest() throws CalcException {
        p.calc(expression);
    }

}