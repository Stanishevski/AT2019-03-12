package by.it.udalyou.Calc;


import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars=new HashMap<>();
    static Var saveVar(String name, Var var){
        vars.put(name,var);

        return var;
    }

    static Var createVar(String operand)throws CalkException{
        operand=operand.trim().replace("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        else if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        else if (operand.matches(Patterns.MATRIX))
          //  return new Matrix(operand);
            return null;//когда вставлю вектор и матрицу - убрать
        else if (vars.containsKey(operand))
            return vars.get(operand);

        return null;
    }

    @Override
    public Var add(Var other) throws CalkException{
       throw new CalkException("Операция сложения "+this+"+"+other+" не возможна");

    }

    @Override
    public Var sub(Var other)throws CalkException {
        throw new CalkException("Операция вычитания "+this+"-"+other+" не возможна");

    }

    @Override
    public Var mul(Var other) throws CalkException{
        throw new CalkException("Операция умножения "+this+"*"+other+" не возможна");
            }

    @Override
    public Var div(Var other)throws CalkException {
        throw new CalkException("Операция деления "+this+"/"+other+" не возможна");
            }
}
