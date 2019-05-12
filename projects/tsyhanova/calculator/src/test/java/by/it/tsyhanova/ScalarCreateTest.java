package by.it.tsyhanova;

import org.junit.Assert;
import org.junit.Test;

public class ScalarCreateTest {
//тест на создание скаляра

    @Test()
    public void checkVarCreate() throws Exception{
        Var var= Var.createVar("123");
        Assert.assertEquals("123.0",var.toString());
    }
}
