package by.it.vshchur;

import java.util.Arrays;

public class Vector extends Var {
    double[] value;

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String strVector) {
        String[] s = strVector.replace("{", "").replace("}", "").split(",\\s*");
        value = new double[s.length];
        for (int i = 0; i < s.length; i++) {
            value[i] = Double.parseDouble(s[i]);
        }   //{1,2,3,4,5,0}
    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }


    @Override
    public String toString() {
        return Arrays.toString(value).replace('[', '{').replace(']', '}');
    }

    @Override
    public Var add(Var other) throws CalcException {
        if (other instanceof Scalar) { //Это прибавление к каждому элементу вектора некоего числа. Математического смысла в этом нет
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = res[i] + ((Scalar) other).value;
            }
            return new Vector(res);
        } else if (other instanceof Vector) { //Это сложение векторов. Если число элементов у них разное, то сложение невозможно
            double[] res = Arrays.copyOf(value, value.length);
            if (res.length != ((Vector) other).value.length)
                throw new CalcException("ERROR: операция невозможна с векторами разной длины.");
            for (int i = 0; i < res.length; i++) {
                res[i] = res[i] + ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if (other instanceof Scalar) { //Это вычитание числа из каждого элемента вектора. Математического смысла в этом нет.
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = res[i] - ((Scalar) other).value;
            }
            return new Vector(res);
        } else if (other instanceof Vector) { //Это вычитание векторов. Если число элементов у них разное, то сложение невозможно
            double[] res = Arrays.copyOf(value, value.length);
            if (res.length != ((Vector) other).value.length)
                throw new CalcException("ERROR: операция невозможна с векторами разной длины.");
            for (int i = 0; i < res.length; i++) {
                res[i] -= ((Vector) other).value[i];
            }
            return new Vector(res);
        }
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if (other instanceof Scalar) { //Это умножение числа на вектор. Математического смысл есть.
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = res[i] * ((Scalar) other).value;
            }
            return new Vector(res);
        } else if (other instanceof Vector) { //Это умножение векторов. Если число элементов у них разное, то умножение невозможно. Результат - одно число (скаляр)
            if (Arrays.copyOf(value, value.length).length != ((Vector) other).value.length)
                throw new CalcException("ERROR: операция невозможна с векторами разной длины.");
            double res = 0;
            for (int i = 0; i < this.value.length; i++) {
                res += +this.value[i] * ((Vector) other).value[i];
            }
            return new Scalar(res);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if (other instanceof Scalar) { //Деление - это умножение вектора на число обратное делителю . Математического смысл есть.
            double[] res = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                res[i] = res[i] / ((Scalar) other).value;
            }
            return new Vector(res);
        } else if (other instanceof Vector) throw new CalcException("ERROR: деления векторов не существует");
        return super.div(other);
    }
}