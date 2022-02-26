package me.akamex.akamexcalculate.expression;

public class CalculatorExpression {

    private final ExpressionSolver expressionSolver;
    private String handling, result;

    public CalculatorExpression(ExpressionSolver expressionSolver) {
        this.expressionSolver = expressionSolver;
        handling = "";
        result = "";
    }

    public String getHandling() {
        return handling;
    }

    public String getResult() {
        return result;
    }

    public CalculatorExpression calculateResult() {
        this.result = expressionSolver.toResult(handling);
        return this;
    }

    public boolean isClear() {
        return handling.isEmpty() && result.isEmpty();
    }

    public CalculatorExpression addExpressionComponent(String component) {
        this.handling += component;
        return this;
    }

    public CalculatorExpression removeLeftExpressionComponent() {
        if(handling.isEmpty()) {
            return this;
        }
        handling = handling.substring(0, handling.length() - 1).trim();
        return this;
    }

    public CalculatorExpression clearExpressionComponent() {
        handling = "";
        result = "";
        return this;
    }

    public void setHandling(String handling) {
        this.handling = handling;
    }
}
