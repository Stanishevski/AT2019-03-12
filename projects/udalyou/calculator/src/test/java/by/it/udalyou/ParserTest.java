package by.i.udalyou;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ParserTest {
    @Test
    public void calcScalarAddTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("2+2");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 4.0;
        assertEquals("Сложение работает неверно", expectedValue, actialValue, 1e-10);
    }

  /*  @Test
    public void calcInstanceScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("2+3");
        if (!(actual instanceof Vector)) {
            fail("Неловрпвлоырлор");
        }
    }
*/
    @Test
    public void calcScalarSubTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("8-2");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 6.0;
        assertEquals("Вычитание работает неверно", expectedValue, actialValue, 1e-10);
    }
}