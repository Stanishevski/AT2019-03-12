package by.it.tsyhanova;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

//Параметрический (несколько значений в выражении) тест на определение корректности операции сложения
@RunWith(value = Parameterized.class)
public class VectorSumTest {
    @Parameterized.Parameters
    public static List<String[]> createData(){
        String[][] strings = {
                {"{2.2,3.5,6.4}+2", "{4.2, 5.5, 8.4}"},
                {"{6.7,1.0}+0.3", "{7.0, 1.3}"},
                {"3.5+{1.1,5.5}", "{4.6, 9.0}"},
                {"A={2.3}+2", "{4.3}"},
                {"{300}+0", "{300.0}"}
        };
        return Arrays.asList(strings);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;

    Parser parser=new Parser();
    @Test
    public void sumTest() throws Exception {

        Var actual = parser.calc(expression);
        Assert.assertEquals(result,actual.toString());
        System.out.println("passed "+expression+" = "+result);
    }
}
