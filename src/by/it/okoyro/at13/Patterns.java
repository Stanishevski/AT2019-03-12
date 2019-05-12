package by.it.okoyro.at13;

public class Patterns {
    static final String SCALAR="-?[0-9]+(\\.[0-9]+)?";
    static final String VECTOR="\\{((-?[0-9]+(\\.[0-9]+)?),?)+}";
    static final String MATRIX="\\{(\\{((-?[0-9]+(\\.[0-9]+)?),?)+},?)+}";
    static final String OPERATION="(?<=[^{,=*/+-])([=*/+-])"; /* этот regexp ищет выражения перед которыми нет других выражений
     для того, чтобы можно было оперировать отрицательными числами*/
}
