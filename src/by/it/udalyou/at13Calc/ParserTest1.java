package by.it.udalyou.at13Calc;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ParserTest1 {

    @Test
    public void calc1() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("A=1.3+2*3");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 7.3;
        assertEquals("Сложение работает неверно", expectedValue, actialValue, 1e-10);
    }
    @Test
    public void calc2() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("B=A*3.5");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 25.55;
        assertEquals("Сложение работает неверно", expectedValue, actialValue, 1e-10);
    }
        @Test
        public void calc3() throws Exception {
            Parser p = new Parser();
            Var actual = p.calc("B1=B+0.11*-5");
            double actialValue = Double.parseDouble(actual.toString());
            double expectedValue = 25;
            assertEquals("Сложение работает неверно", expectedValue, actialValue, 1e-10);
        }
    @Test
    public void calc4() throws Exception {
        Parser p = new Parser();
        Var actual = p.calc("B2=A/2-1");
        double actialValue = Double.parseDouble(actual.toString());
        double expectedValue = 2.65;
        assertEquals("Сложение работает неверно", expectedValue, actialValue, 1e-10);
    }
   /* C=B+(A*2)(выведет на экран 40.15).
            •D=((C-0.15)-20)/(7-5) (выведет на экран 10)
            •E={2,3}*(D/2) (выведет на экран {10,15} ).*/
 /*  @Test
   public void calc5() throws Exception {
       Parser p = new Parser();
       Var actual = p.calc("C=B+(A*2)");
       double actialValue = Double.parseDouble(actual.toString());
       double expectedValue = 40.15;
       assertEquals("Сложение работает неверно", expectedValue, actialValue, 1e-10);
   }
    @Test
    public void calc66() throws CalcException {
        Parser p = new Parser();
        Var s = p.calc("1+1");
        //double av=Double.parseDouble(s.toString());
        Assert.assertEquals("2.0",s);
    }

           @Test
    public void calc6() throws CalcException {
        Parser p = new Parser();
        Var s = p.calc("C=B*(A-(4+2))");
        Assert.assertEquals("2.0",s);
    }*/

    @Test
    public void calc7() throws CalcException {
        Parser p = new Parser();
        Var s = p.calc("B=A+{1,3}");
        Assert.assertEquals("{8.3, 10.3}",s);
    }
    @Test
    public void calc8() throws CalcException {
        Parser p = new Parser();
        Var s = p.calc("C=B-{2.3,1.3}");
        Assert.assertEquals("{6.0,9.0}",s);
    }
    @Test
    public void calc9() throws CalcException {
        Parser p = new Parser();
        Var s = p.calc("D=C*{2,3}");
        double expectedValue = 39.0;
        Assert.assertEquals(expectedValue,s);
    }
    @Test
    public void calc10() throws CalcException {
        Parser p = new Parser();
        Var s = p.calc("E=B/2");
        Assert.assertEquals("{3.0,4.5}",s);
    }

/*
@Test
        public void vectorcalc() throws Exception{
            Parser p=new Parser();
            Var actual = p.calc("A={1,3}+{2,4}");
            double actialValue=Double.parseDouble(actual.toString());
            double[] expectedValue=new double[]{3.0,7.0};
         //   assertArrayEquals("gg",expectedValue,actialValue,1e-10);
            Assert.assertEquals(expectedValue,actialValue);
            //assertEquals("Сложение работает неверно", expectedValue,actialValue,1e-10);

    }*/
}