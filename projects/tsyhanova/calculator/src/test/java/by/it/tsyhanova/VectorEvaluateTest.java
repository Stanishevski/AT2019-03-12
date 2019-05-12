package by.it.tsyhanova;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

@RunWith(value = Parameterized.class)
public class VectorEvaluateTest {
    //параметрический тест на сложное выражение с несколькими операциями

    @Parameterized.Parameters
    public static List<String[]> createData(){
        String[][] strings = {
                {"{2.0,3.5}+2*3", "{8.0, 9.5}"},
                {"10-6/2+{5.0}", "{12.0}"},
                {"2+3*{2.0,0.0}", "{8.0, 2.0}"},
                {"A={2.0,1.5}+{3.5,6.4}*2", "{9.0, 14.3}"},
                {"{5.5,6.6}-{5.0,6.0}+100", "{100.5, 100.6}"}
        };
        return Arrays.asList(strings);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;

    //сравнение именно чисел, а не строк, чтобы избежать проблему точности... см. @generate внизу класса Vector
    @Test
    public void evaluateTest() throws Exception {
        Parser parser=new Parser();
        Var actual = parser.calc(expression);
        Assert.assertEquals(Var.createVar(result),actual);
        System.out.println("passed "+expression+" = "+result);
    }

}
