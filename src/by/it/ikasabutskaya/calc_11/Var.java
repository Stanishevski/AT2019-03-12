package by.it.ikasabutskaya.calc_11;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    public static Var saveVar(String name, Var var) {
        vars.put(name, var);

        return var;
    }




   public static Var createVar(String strVar) throws CalcException {
       strVar=strVar.replace(" ","");
       if (strVar.matches(Patterns.SCALAR))
           return new Scalar(strVar);
       else if (strVar.matches(Patterns.VECTOR))
           return new Vector(strVar);
       else if (strVar.matches(Patterns.MATRIX))
           return new Matrix(strVar);
       else if (vars.containsKey(strVar))
           return vars.get(strVar);
       else
           throw  new CalcException(" Невозможно создать  "+strVar);
   }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("сложение "+this+" + "+other+" невозможно!");
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        throw new CalcException("вычитание "+this+" - "+other+" невозможно!");
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        throw new CalcException("умножение "+this+" * "+other+" невозможно!");
    }

    @Override
    public Var div(Var other)  throws CalcException {
        throw new CalcException("деление "+this+" + "+other+" невозможно!");
    }

    @Override
    public String toString() {
        return "Это абстрактная переменная";
    }
}
