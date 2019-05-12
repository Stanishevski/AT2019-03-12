package by.it.simanovich;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ParserTest {

    @Test
    public void calcScalarAddScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("2+2");

        double actualValue = Double.parseDouble(actual.toString());
        double expectedValue=4.0;
        assertEquals("Сложение работает неверно", expectedValue, actualValue, 1e-10);

    }
    @Test
    public void calcScalarSubScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("40-32");

        double actualValue = Double.parseDouble(actual.toString());
        double expectedValue=8;
        assertEquals("Вычитание работает неверно", expectedValue, actualValue, 1e-10);

    }
    @Test
    public void calcScalarMulScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("5*10");

        double actualValue = Double.parseDouble(actual.toString());
        double expectedValue=50;
        assertEquals("Умножение работает неверно", expectedValue, actualValue, 1e-10);

    }
    @Test
    public void calcScalarDivScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("56/8");

        double actualValue = Double.parseDouble(actual.toString());
        double expectedValue=7;
        assertEquals("Деление работает неверно", expectedValue, actualValue, 1e-10);

    }
    @Test
    public void calcVectorAddAScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{1, 2, 3} + 4");

        String actualValue = actual.toString();
        String expectedValue = "{5.0, 6.0, 7.0}";

        assertEquals("Сложение работает неверно", expectedValue, actualValue);

    }
    @Test
    public void calcVectorAddVectorTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{1, 2, 3} + {4, 5, 6}");

        String actualValue = actual.toString();
        String expectedValue = "{5.0, 7.0, 9.0}";

        assertEquals("Сложение работает неверно", expectedValue, actualValue);

    }
    @Test
    public void calcVectorSubScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{5, 6, 7} - 2");

        String actualValue = actual.toString();
        String expectedValue = "{3.0, 4.0, 5.0}";

        assertEquals("Вычитание работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcVectorSubVectorTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{5, 6, 7} - {1, 2, 3}");

        String actualValue = actual.toString();
        String expectedValue = "{4.0, 4.0, 4.0}";

        assertEquals("Вычитание работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcVectorMulScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{1, 2, 3} * 3");

        String actualValue = actual.toString();
        String expectedValue = "{3.0, 6.0, 9.0}";

        assertEquals("Умножение работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcVectorMulVectorTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{1, 2, 3} * {2, 3, 4}");

        double actualValue = Double.parseDouble(actual.toString());
        double expectedValue = 20.0;

        assertEquals("Умножение работает неверно", expectedValue, actualValue, 1e-10);
    }
    @Test
    public void calcVectorDivScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{2, 4, 6} / 2");

        String actualValue = actual.toString();
        String expectedValue = "{1.0, 2.0, 3.0}";

        assertEquals("Деление работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcMatrixAddScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{{1, 2, 3}, {1, 2, 3}} + 2");

        String actualValue = actual.toString();
        String expectedValue = "{{3.0, 4.0, 5.0}, {3.0, 4.0, 5.0}}";

        assertEquals("Сложение работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcMatrixAddMatrixTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{{1, 2, 3}, {1, 2, 3}} + {{1, 2, 3}, {1, 2, 3}}");

        String actualValue = actual.toString();
        String expectedValue = "{{2.0, 4.0, 6.0}, {2.0, 4.0, 6.0}}";

        assertEquals("Сложение работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcMatrixSubScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{{2, 4, 6}, {2, 4, 6}} - 2");

        String actualValue = actual.toString();
        String expectedValue = "{{0.0, 2.0, 4.0}, {0.0, 2.0, 4.0}}";

        assertEquals("Вычитание работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcMatrixSubMatrixTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{{2, 4}, {2, 4}} - {{1, 2}, {1, 2}}");

        String actualValue = actual.toString();
        String expectedValue = "{{1.0, 2.0}, {1.0, 2.0}}";

        assertEquals("Вычитание работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcMatrixMulScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{{2, 4}, {2, 4}} * 2");

        String actualValue = actual.toString();
        String expectedValue = "{{4.0, 8.0}, {4.0, 8.0}}";

        assertEquals("Умножение работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcMatrixMulVectorTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{{2, 4}, {2, 4}} * {2, 4}");

        String actualValue = actual.toString();
        String expectedValue = "{20.0, 20.0}";

        assertEquals("Умножение работает неверно", expectedValue, actualValue);
    }
    @Test
    public void calcMatrixMulMatrixTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("{{2, 4}, {2, 4}} * {{2, 4}, {2, 4}}");

        String actualValue = actual.toString();
        String expectedValue = "{{12.0, 24.0}, {12.0, 24.0}}";

        assertEquals("Умножение работает неверно", expectedValue, actualValue);
    }



    @Test
    public void calcInstanceScalarTest() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("2+3");
        //String actualString = actual.toString().intern();
        //String expectedString = "4.0";
        if(!(actual instanceof Scalar)){
            fail("eeeee");
        }
    }
}