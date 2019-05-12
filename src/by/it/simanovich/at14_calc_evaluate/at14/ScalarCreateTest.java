package by.it.simanovich.at14_calc_evaluate.at14;

import by.it.simanovich.at14_calc_evaluate.Var;
import org.junit.Assert;
import org.junit.Test;

public class ScalarCreateTest {


    @Test()
    public void checkVarCreate() throws Exception{
        Var var= Var.createVar("123");
        Assert.assertEquals("123.0",var.toString());
    }
}
