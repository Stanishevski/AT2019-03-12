package by.it.simanovich.at13_calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        //2.0*3.0
        String[] operands = expression.split(Patterns.OPERATION);
        Var two = Var.createVar(operands[1]);
        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
//        String operation;
//        if (matcher.find())
//            operation = matcher.group();
//        else
//            operation = "error";
        String operation = matcher.find() ? matcher.group() : "error";
        if (operation.equals("=")){
            String name=operands[0];
            Var.saveVar(name, two);
            return two;
        }
        Var one = Var.createVar(operands[0]);
        switch (operation) {
            case "+": return one.add(two);
            case "-": return one.sub(two);
            case "*": return one.mul(two);
            case "/": return one.div(two);
        }
        return null;
}
}
