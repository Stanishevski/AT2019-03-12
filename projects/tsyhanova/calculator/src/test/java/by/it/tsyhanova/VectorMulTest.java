package by.it.tsyhanova;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

//Параметрический (несколько значений в выражении) тест на определение корректности операции сложения
@RunWith(value = Parameterized.class)
public class VectorMulTest {

    @Parameterized.Parameters
    public static List<String[]> createData(){
        String[][] strings = {
                {"{3.2,3.5,6.4}*2", "{6.4, 7.0, 12.8}"},
                {"{6.7,1.0}*0.3", "{2.01, 0.3}"},
                {"3*{1.1,5.5}", "{3.3, 16.5}"},
                {"A={2.3}*2", "{4.6}"},
                {"0*{300}", "{0.0}"}
        };
        return Arrays.asList(strings);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;

    //сравнение именно чисел, а не строк, чтобы избежать проблему точности... см. @generate внизу класса Vector
    @Test
    public void mulTest() throws Exception {
        Parser parser=new Parser();
        Var actual = parser.calc(expression);
        Assert.assertEquals(Var.createVar(result),actual);
        System.out.println("passed "+expression+" = "+result);
    }
}
