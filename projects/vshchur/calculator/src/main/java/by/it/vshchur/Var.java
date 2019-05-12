package by.it.vshchur;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();
    private static String filename=System.getProperty("user.dir")+
            "/src/main/java/by/it/vshchur/vars.txt";

   public static Var createVar(String strVar) throws CalcException {
       strVar=strVar.replace(" ","");
       if (strVar.matches(Patterns.SCALAR))
           return new Scalar(strVar);
       else if (strVar.matches(Patterns.VECTOR))
           return new Vector(strVar);
       else if (strVar.matches(Patterns.MATRIX))
           return new Matrix(strVar);
       else if (vars.containsKey(strVar))
           return vars.get(strVar); //A=9, B=A

       else
           throw new CalcException("Неизвестное выражение, невозможно создать "+strVar);
   }


    public static void saveToFile() {
        try ( PrintWriter out=new PrintWriter(new FileWriter(filename))){
            Set<Map.Entry<String, Var>> entries = vars.entrySet();
            for (Map.Entry<String, Var> entry : entries) {
                out.println(entry.getKey()+"="+entry.getValue());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void loadFromFile() {
        Parser p=new Parser();
        try ( BufferedReader r=new BufferedReader(new FileReader(filename))){
            while (true){
                String line=r.readLine();
                if (line==null)
                    break;
                p.calc(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Сложение "+this+" + "+other+" невозможно!");
    }

    @Override
    public Var sub(Var other)  throws CalcException {
        throw new CalcException("Вычитание "+this+" - "+other+" невозможно!");
    }

    @Override
    public Var mul(Var other)  throws CalcException {
        throw new CalcException("Умножение "+this+" * "+other+" невозможно!");
    }

    @Override
    public Var div(Var other)  throws CalcException {
        throw new CalcException("Деление "+this+" + "+other+" невозможно!");
    }

//    @Override
//    public String toString() {
//        return "Это абстрактная переменная";
//    }

    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;     }
}
