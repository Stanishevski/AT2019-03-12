package by.it.tsyhanova;

import org.junit.Test;

public class ScalarExceptionTest {
//тест на обработку ошибок

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
