package by.it.agrinkevich;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;

@RunWith(value = Parameterized.class)
public class MatrixMulTest {

    public static Parser parser = new Parser();

    @Parameterized.Parameters
    public static List<String[]> createData() {
        String[][] str = {
                {"{{2, 3, 4}, {2, 3, 4}, {2, 3, 4}} * 2", "{{4.0, 6.0, 8.0}, {4.0, 6.0, 8.0}, {4.0, 6.0, 8.0}}"},
                {"{{1, 2},{1, 2}} * {1, 2}", "{5.0, 5.0}"},
                {"{{-4,3,1},{0,7,2},{-8,2,5}}*{{5,1,-3},{-2,4,8},{11,3,-9}}", "{{-15.0, 11.0, 27.0}, {8.0, 34.0, 38.0}, {11.0, 15.0, -5.0}}"}
        };
        return Arrays.asList(str);
    }

    @Parameterized.Parameter(value = 0)
    public static String expression;

    @Parameterized.Parameter(value = 1)
    public static String result;

    @Test
    public void mul() throws CalcException {
        Var actual = parser.calc(expression);
        //double actualDouble = Double.parseDouble(actual);
        //double expectedDouble = Double.parseDouble(result);
        //Assert.assertEquals(expectedDouble, actualDouble, 1e-10);
        // так как actualDouble и expectedDuble - это вектора, то мы должны получить массив даблов (getValue())
        // и сравнить друг с другом нижним методом:
        //Assert.assertArrayEquals();
        Assert.assertThat(result, is(actual.toString()));
        System.out.println("passed: " + expression + "=" + result);
    }
}
