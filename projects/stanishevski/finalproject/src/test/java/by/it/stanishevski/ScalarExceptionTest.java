package by.it.stanishevski;

import by.it.stanishevski.WebCalculator.Calculator.CalcException;
import by.it.stanishevski.WebCalculator.Calculator.Parser;
import by.it.stanishevski.WebCalculator.Calculator.Var;
import org.junit.Test;


public class ScalarExceptionTest {

    @Test(expected = CalcException.class)
    public void checkCalcException() throws Exception{
        Parser parser=new Parser();
        parser.calc("sadasd+asdasdas");
    }

    @Test(expected = CalcException.class)
    public void checkVarCreate() throws Exception{
        Var var= Var.createVar("bla bla bla");
    }
}
