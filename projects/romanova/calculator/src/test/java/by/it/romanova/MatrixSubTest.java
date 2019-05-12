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
public class MatrixSubTest {

    private Parser p;

    @Before
    public void parserInit(){
        p = new Parser();
    }

    @Parameters
    public static List<Object[]> parameters(){
        return Arrays.asList(new Object[][]{
                {"{{1,2.0,3},{4,5,6},{7, 8,9}}-{{1,2.5,3},{4,0,6},{7,8,-9}}", "{{0.0, -0.5, 0.0}, {0.0, 5.0, 0.0}, {0.0, 0.0, 18.0}}"},
                {"{{1,2,3},{4,5,6},{7, 8,9}}-{{1,0,3},{4,0,6},{7,8,-9}}", "{{0.0, 2.0, 0.0}, {0.0, 5.0, 0.0}, {0.0, 0.0, 18.0}}"},
                {"{{1,2},{4,5}}-{{1,2},{5,6}}", "{{0.0, 0.0}, {-1.0, -1.0}}"},
                {"{{1,8},{4,5}}-{{1,-2},{5,6}}", "{{0.0, 10.0}, {-1.0, -1.0}}"},
                {"{{1,2.5},{4,5.5}}-{{1,-2},{5,-6}}", "{{0.0, 4.5}, {-1.0, 11.5}}"},

         });
    }

    @Parameter
    public String expression;

    @Parameter(1)
    public String expected;


    @Test
    public void main() throws CalcException {
        assertThat(p.calc(expression).toString(), is(expected));
    }
}