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
public class MatrixCreateTest {

    private Parser p;

    @Before
    public void parserInit()
    {
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"A={{1,2.0,3},{4,5,6},{7, 8,9}}", "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}"},
                {"B=A", "{{1.0, 2.0, 3.0}, {4.0, 5.0, 6.0}, {7.0, 8.0, 9.0}}"},
                {"B1={{1,2},{4,5}}", "{{1.0, 2.0}, {4.0, 5.0}}"},
                {"B2={{0,4,5},{-4,0.0,5},{4,6,7},{3,4,5}}", "{{0.0, 4.0, 5.0}, {-4.0, 0.0, 5.0}, {4.0, 6.0, 7.0}, {3.0, 4.0, 5.0}}"},
                {"B3={{3,4,5},{-6,7,8},{5,6,7}}", "{{3.0, 4.0, 5.0}, {-6.0, 7.0, 8.0}, {5.0, 6.0, 7.0}}"}
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