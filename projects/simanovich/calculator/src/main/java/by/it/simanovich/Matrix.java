package by.it.simanovich;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Matrix extends Var {
    private double[][] value;

    public Matrix(double[ ][ ] value){
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            this.value[i] = Arrays.copyOf(value[i], value[i].length);
        }
    }

    public Matrix(Matrix matrix) {
        this(matrix.value);
    }

    public Matrix(String strMatrix){
        this.value = getDoublesMass(strMatrix);
    }

    private double[][] getDoublesMass(String strMatrix) {
        String nextString = strMatrix.substring(1, strMatrix.length() - 1);
        Pattern pattern = Pattern.compile("(\\{)(.+?)(})");
        Matcher matcher = pattern.matcher(nextString);
        int count = nextString.length() - nextString.replaceAll("\\{", "").length();
        double[][] newRes = new double[count][];
        int i = 1;
        while (matcher.find() && i <= count) {
            String str = matcher.group(2);
            String[] s1 = str.split(",");
            double[] d1 = new double[s1.length];
            for (int j = 0; j < s1.length; j++) {
                d1[j] = Double.parseDouble(s1[j]);
            }
            newRes[i - 1] = d1;
            i++;
        }
        return newRes;
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] + ((Scalar) other).value;
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix){
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] + ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] - ((Scalar) other).value;
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Matrix){
            double[][] res = new double[value.length][value[0].length];
            if (res.length != ((Matrix) other).value[0].length)
                throw new CalcException("Матрицы разных рамеров");
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] - ((Matrix) other).value[i][j];
                }
            }
            return new Matrix(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar){
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                res[i] = Arrays.copyOf(value[i], value[i].length);
            }
            for (int i = 0; i < res.length; i++) {
                for (int j = 0; j < res[0].length; j++) {
                    res[i][j] = res[i][j] * ((Scalar) other).value;
                }
            }
            return new Matrix(res);
        }
        if (other instanceof Vector){
            double[][] matrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                matrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[] res = new double[value.length];
            for (int j = 0; j < value[0].length; j++) {
                for (int i = 0; i < value.length; i++) {
                    res[j] += matrix[j][i] * ((Vector)other).value[i];
                }
            }
            return new Vector(res);

        }
        if (other instanceof Matrix){
            double[][] matrix = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                matrix[i] = Arrays.copyOf(value[i], value[i].length);
            }
            double[][] res = new double[value.length][value[0].length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    for (int k = 0; k < matrix.length; k++) {
                        res[i][j] += matrix[i][k] * ((Matrix) other).value[k][j];
                    }
                }
            }
           return new Matrix(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return super.div(other);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        int valueLength = value.length;
        for (int i = 0; i < valueLength; i++) {
            sb.append(Arrays.toString(value[i]).replace('[','{').replace(']', '}'));
            if (i != valueLength - 1){
                sb.append(", ");
            }
        }
        sb.append("}");
        return sb.toString();
    }
}
