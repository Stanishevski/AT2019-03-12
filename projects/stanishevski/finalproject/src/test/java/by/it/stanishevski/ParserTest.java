package by.it.stanishevski;

import by.it.stanishevski.WebCalculator.Calculator.Parser;
import by.it.stanishevski.WebCalculator.Calculator.Var;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ParserTest {
    @Test
    public void calcScalarAddTest() throws Exception {
        Parser p=new Parser();
        Var actual = p.calc("2+2");
        double actialValue=Double.parseDouble(actual.toString());
        double expectedValue=4.0;
        assertEquals("Сложение работает неверно",expectedValue,actialValue,1e-10);
    }
//    @Test
//    public void calcInstanceScalarTest() throws Exception {
//        Parser p=new Parser();
//        Var actual = p.calc("2+2");
//        if (!(actual instanceof Vector)){
//            fail("Неловрпвлоырлор");
//        }
//    }

}