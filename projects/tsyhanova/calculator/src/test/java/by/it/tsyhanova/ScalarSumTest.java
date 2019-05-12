package by.it.tsyhanova;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

//Параметрический (несколько значений в выражении) тест на определение корректности операции сложения
@RunWith(value = Parameterized.class)
public class ScalarSumTest {
    @Parameterized.Parameters
    public static List<String[]> createData(){
        String[][] strings = {
                {"2+2", "4.0"},
                {"2+8", "10.0"},
                {"0+0", "0.0"},
                {"A=0+10", "10.0"},
                {"100+200", "300.0"}
        };
        return Arrays.asList(strings);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;


    @Test
    public void sumTest() throws Exception {
        /*Parser parser=new Parser();
        Var actual = parser.calc(expression);
        Assert.assertEquals(result,actual.toString());
        System.out.println("passed "+expression+" = "+result);*/


    }
}
