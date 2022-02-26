package me.akamex.akamexcalculate.expression;

public class CalculatorExpression {

    private final ExpressionSolver expressionSolver;
    private String handling, result;
    private boolean error;

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
        if(result.equals(ExpressionSolver.ERROR)) {
            error = true;
        }
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
        if(handling.trim().isEmpty()) {
            return this;
        }
        if(error) {
            result = "";
            error = false;
        }
        handling = handling.trim().substring(0, handling.trim().length() - 1).trim();
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
