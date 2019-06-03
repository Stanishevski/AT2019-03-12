package by.it.romanova;

class Patterns {

    static final String
            SCALAR = "-?[0-9]+(\\.[0-9]+)?",
            VECTOR = "\\{((-?[0-9]+(\\.[0-9]+)?),?)+}",
            MATRIX = "\\{(\\{((-?[0-9]+(\\.[0-9]+)?),?)+},?)+}",
            OPERATION = "(?<![-+*/={,])([-+=*/])",
            BRACES = "\\([-+*/0-9a-zA-Z.]+\\)";

}
