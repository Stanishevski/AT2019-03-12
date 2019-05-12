package by.it.tsyhanova;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.List;

//Параметрический (несколько значений в выражении) тест на определение корректности операции сложения
@RunWith(value = Parameterized.class)
public class VectorDivTest {
    @Parameterized.Parameters
    public static List<String[]> createData(){
        String[][] strings = {
                {"{3.2,3.5,6.4}/2", "{1.6, 1.75, 3.2}"},
                {"{6.7,1.5}/0.3", "{22.333333333333336, 5.0}"},
                {"{1.2,5.5}/10", "{0.12, 0.55}"},
                {"A={2.3}/2", "{1.15}"},
                {"{300}/300", "{1.0}"}
        };
        return Arrays.asList(strings);
    }

    @Parameterized.Parameter(value = 0)
    public String expression;

    @Parameterized.Parameter(value = 1)
    public String result;

    Parser parser=new Parser();
    //сравнение именно чисел, а не строк, чтобы избежать проблему точности... см. @generate внизу класса Vector
    @Test
    public void divTest() throws Exception {
        Parser parser=new Parser();
        System.out.println(parser);
        Var actual = parser.calc(expression);
        Assert.assertEquals(Var.createVar(result),actual);
        System.out.println("passed "+expression+" = "+result);
    }

}
