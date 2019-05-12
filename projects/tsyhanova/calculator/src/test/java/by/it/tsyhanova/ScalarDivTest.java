package by.it.tsyhanova;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

//Параметрический (несколько значений в выражении) тест на определение корректности операции умножения
@RunWith(value = Parameterized.class)
public class ScalarDivTest {
    @Parameterized.Parameters
    public static List<String[]> createData(){
        String[][] strings = {
                {"2/2", "1.0"},
                {"2/8", "0.25"},
                {"0/1", "0.0"},
                {"A=10/5", "2.0"},
                {"200/100", "2.0"}
        };
        return Arrays.asList(strings);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;


    @Test
    public void divTest() throws Exception {
        Parser parser=new Parser();
        Var actual = parser.calc(expression);
        Assert.assertEquals(result,actual.toString());
        System.out.println("passed "+expression+" = "+result);
    }
}
