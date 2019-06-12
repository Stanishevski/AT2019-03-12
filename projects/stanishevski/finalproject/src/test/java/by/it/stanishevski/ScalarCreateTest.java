package by.it.stanishevski;

import by.it.stanishevski.WebCalculator.Calculator.Var;
//import org.junit.Assert;
//import org.junit.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ScalarCreateTest {


    @Test()
    public void checkVarCreate() throws Exception{
        Var var= Var.createVar("123");
        Assert.assertEquals("123.0",var.toString());
    }
}
