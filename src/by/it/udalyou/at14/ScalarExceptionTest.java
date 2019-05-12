package by.it.udalyou.at14;




import by.it.udalyou.at14evlCalk.CalcException;
import by.it.udalyou.at14evlCalk.Parser;
import by.it.udalyou.at14evlCalk.Var;
import org.junit.Test;

public class ScalarExceptionTest {

    @Test(expected = CalcException.class)
    public void checkCalcException() throws Exception{
        Parser parser=new Parser();
        parser.calc("sadasd+asdasdas");
    }

    @Test(expected = CalcException.class)
    public void checkVarCreate() throws Exception{
        Var var=  Var.createVar("bla bla bla");
    }
}
