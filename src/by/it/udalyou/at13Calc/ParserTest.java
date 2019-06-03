package by.it.udalyou.at13Calc;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ParserTest {
    @Test
    public void calcScalarAddTest() throws Exception {
        Parser p=new Parser();
        Var actual = p.calc("2+5.3");
        double actialValue=Double.parseDouble(actual.toString());
        double expectedValue=7.3;
        assertEquals("Сложение работает неверно",expectedValue,actialValue,1e-10);
    }
    @Test
    public void calcInstanceScalarTest() throws Exception {
        Parser p=new Parser();
        Var actual = p.calc("2+3");
        if (!(actual instanceof Vector)){
            fail("Неловрпвлоырлор");
        }
    }

}