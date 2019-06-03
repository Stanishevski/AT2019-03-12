package by.it.agrinkevich.webcalculator.calculator;

import java.io.*;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Var implements Operation {

    private static String filename = System.getProperty("user.dir") + "/src/main/java/by/it/agrinkevich/vars.txt";
    private static Map<String, Var> vars = new HashMap<>();

    static void printVar() {
        for (Map.Entry<String, Var> entry : vars.entrySet()) {
            String key = entry.getKey();
            Var value = entry.getValue();
            System.out.println(key + "=" + value);
        }
    }

    static void sortVar() {
        vars = vars.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));
    }

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replace(" ", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        else
            throw new CalcException("Неизвестное выражение " + strVar);
    }

    public static void saveToFile() {
        try (PrintWriter out = new PrintWriter(new FileWriter(filename))) {
            Set<Map.Entry<String, Var>> entries = vars.entrySet();
            for (Map.Entry<String, Var> entry : entries) {
                out.println(entry.getKey() + "=" + entry.getValue());
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Logger.errorLog(e.getMessage());
        }
    }


    static void loadFromFile() {
        Parser p = new Parser();
        try (BufferedReader r = new BufferedReader(new FileReader(filename))) {
            while (true) {
                String line = r.readLine();
                if (line == null) break;
                p.calc(line);
            }
        } catch (FileNotFoundException e) {
            //e.printStackTrace();
            System.out.println(e.getMessage());
            Logger.errorLog(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            Logger.errorLog(e.getMessage());
        }
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("сложение " + this + " + " + other + " невозможно!");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("вычитание " + this + " - " + other + " невозможно!");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("умножение " + this + " * " + other + " невозможно!");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("деление " + this + " + " + other + " невозможно!");
    }

    @Override
    public String toString() {
        return "Это абстрактная переменная";
    }
}
