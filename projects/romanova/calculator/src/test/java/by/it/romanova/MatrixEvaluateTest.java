package by.it.romanova;

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
public class MatrixEvaluateTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
            {"A={{1,2.0,3},{4,5,6},{7, 8,9}}+{{1,2.5,3},{4,0,6},{7,8,-9}}", "{{2.0, 4.5, 6.0}, {8.0, 5.0, 12.0}, {14.0, 16.0, 0.0}}"},
            {"B=A*3.5", "{{7.0, 15.75, 21.0}, {28.0, 17.5, 42.0}, {49.0, 56.0, 0.0}}"},
            {"B1={{1,2},{4,5}}*{{1,2},{5,6}}", "{{11.0, 14.0}, {29.0, 38.0}}"},
            {"B2=B1+3.5", "{{14.5, 17.5}, {32.5, 41.5}}"},
            {"B3=B1-B2", "{{-3.5, -3.5}, {-3.5, -3.5}}"}
        });
    }

    @Parameter
    public String expression;

    @Parameter(1)
    public String result;

    @Test
    public void scalarEvaluateTest() throws CalcException {
        assertThat(p.calc(expression).toString(), is(result));
    }

}