package by.it.agrinkevich.calculator;

import by.it.agrinkevich.webcalculator.calculator.CalcException;
import by.it.agrinkevich.webcalculator.calculator.Var;
import org.junit.Assert;
import org.junit.Test;

public class ScalarCreateTest {

    @Test
    public void checkVarCreate() throws CalcException {
        Var var = Var.createVar("123");
        Assert.assertEquals("123.0", var.toString());
    }
}
