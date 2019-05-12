package by.it.udalyou.Calk;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public Var calk(String expression)throws CalkException {
        //2.0*2.0
        String[]operand=expression.split(Patterns.OPERATION);

        Var two=Var.createVar(operand[1]);

        if (expression.contains("=")){
           Var.saveVar(operand[0],two);
        }
        Var one=Var.createVar(operand[0]);


        if (one==null||two==null) {
            return null; //ToDo create error
        }

        Pattern p= Pattern.compile(Patterns.OPERATION);
        Matcher m=p.matcher(expression);
        if (m.find()){
            String operetion=m.group();
            switch (operetion){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
