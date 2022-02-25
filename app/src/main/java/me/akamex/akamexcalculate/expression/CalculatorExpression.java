package me.akamex.akamexcalculate.expression;

public class CalculatorExpression {

    private String visible, handling, result;

    public CalculatorExpression() {
        visible = handling = result = "";
    }

    public String getVisible() {
        return visible;
    }

    public String getHandling() {
        return handling;
    }

    public String getResult() {
        return result;
    }

    public void setHandling(String handling) {
        this.handling = handling;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
