package by.it.tsyhanova;

import org.junit.Assert;
import org.junit.Test;

public class VectorCreateTest {
    //тест на создание вектора

    @Test()
    public void checkVarCreate() throws Exception{
        Var var= Var.createVar("{3.4,2.5,8.6}");
        Assert.assertEquals("{3.4, 2.5, 8.6}",var.toString());
    }


}
