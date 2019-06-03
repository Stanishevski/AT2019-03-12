package by.it.romanova;

import java.util.Arrays;

class Vector extends Var {

    private double[] value;

    public double[] getValue() {
        return value;
    }

    public Vector(double[] value) {
        this.value = Arrays.copyOf(value, value.length);
    }

    public Vector(String strVector){
        String[] s = strVector.replace("{", "").replace("}", "").replaceAll(" ", "").split(",\\s*");
        value = new double[s.length];
        for (int i = 0; i < value.length; i++) {
            value[i] = Double.parseDouble(s[i]);
        }

    }

    public Vector(Vector vector) {
        this.value = Arrays.copyOf(vector.value, vector.value.length);
    }

    @Override
    public Var add(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i]+((Scalar)other).getValue();
            }
            return new Vector(result);

        }
        else if (other instanceof Vector){
            if(this.value.length == ((Vector) other).value.length) {
                double[] result = Arrays.copyOf(value, value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] + ((Vector) other).value[i];
                }
                return new Vector(result);
            }
            throw new CalcException("размер векторов должен быть одинаковым");

        }
        else
            return super.add(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i]-((Scalar)other).getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector){
            if(this.value.length == ((Vector) other).value.length) {
                double[] result = Arrays.copyOf(value, value.length);
                for (int i = 0; i < result.length; i++) {
                    result[i] = result[i] - ((Vector) other).value[i];
                }
                return new Vector(result);
            }
            throw new CalcException("размер векторов должен быть одинаковым");

        }
        else
            return super.sub(other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        if(other instanceof Scalar){
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i]*((Scalar)other).getValue();
            }
            return new Vector(result);
        }
        else if (other instanceof Vector){
            if(this.value.length == ((Vector) other).value.length) {
                double[] array = Arrays.copyOf(value, value.length);
                double result = 0;
                for (int i = 0; i < array.length; i++) {
                    array[i] = array[i] * ((Vector) other).value[i];
                    result = result + array[i];
                }
                return new Scalar(result);
            }
            else throw new CalcException("размер векторов должен быть одинаковым");

        }
        else
            return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        if(other instanceof Scalar){
            if (((Scalar) other).getValue()==0)
                throw new CalcException("нельзя делить на 0");
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i]/((Scalar)other).getValue();
            }
            return new Vector(result);
        }
        else
            return super.div(other);
    }

    @Override
    public String toString() {
        return Arrays.toString(value).replace('[','{').replace(']','}');
    }
}
