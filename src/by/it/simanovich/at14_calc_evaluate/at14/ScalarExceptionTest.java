package by.it.simanovich.at14_calc_evaluate.at14;

import by.it.simanovich.at14_calc_evaluate.CalcException;
import by.it.simanovich.at14_calc_evaluate.Parser;
import by.it.simanovich.at14_calc_evaluate.Var;
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
