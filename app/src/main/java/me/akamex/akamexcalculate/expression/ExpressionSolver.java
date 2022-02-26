package me.akamex.akamexcalculate.expression;

public interface ExpressionSolver {

    static String ERROR = "= Ошибка";

    String toResult(String expression);

}
