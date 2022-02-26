package me.akamex.akamexcalculate.button;

import android.view.View;
import android.widget.TextView;

import org.apache.commons.lang3.math.NumberUtils;

import java.util.function.BiConsumer;

import me.akamex.akamexcalculate.R;
import me.akamex.akamexcalculate.expression.CalculatorExpression;

public final class CalculatorButtonImpl {

    private CalculatorButtonImpl() {
        throw new UnsupportedOperationException();
    }

    private static class DefaultImpl extends CalculatorButton {

        private DefaultImpl(int id, BiConsumer<View, CalculatorExpression> onClick) {
            super(id, (view, expression) -> {
                onClick.accept(view, expression);

                TextView clear = view.findViewById(R.id.clear);
                clear.setText(expression.isClear() ? R.string.ac : R.string.c);
            });
        }
    }

    private static class SignCalculatorButton extends DefaultImpl {

        public SignCalculatorButton(int id, BiConsumer<View, CalculatorExpression> onClick) {
            super(id, (view, expression) -> {
                String handling = expression.getHandling();
                if(handling.length() == 0 || !NumberUtils.isDigits(handling.substring(handling.length() - 1))) {
                    return;
                }

                onClick.accept(view, expression);
            });
        }

    }

    private static class FunctionCalculatorButton extends DefaultImpl {

        public FunctionCalculatorButton(int id, BiConsumer<View, CalculatorExpression> onClick) {
            super(id, (view, expression) -> {
                String handling = expression.getHandling();
                if(handling.length() != 0 && NumberUtils.isDigits(handling.substring(handling.length() - 1))) {
                    return;
                }

                onClick.accept(view, expression);
            });
        }

    }

    private static class NumberCalculatorButton extends DefaultImpl {

        public NumberCalculatorButton(int id, BiConsumer<View, CalculatorExpression> onClick) {
            super(id, onClick);
        }

    }

    public static final CalculatorButton PLUS = new SignCalculatorButton(R.id.add, (view, expression) -> expression.addExpressionComponent(" + "));

    public static final CalculatorButton MINUS = new SignCalculatorButton(R.id.minus, (view, expression) -> expression.addExpressionComponent(" - "));

    public static final CalculatorButton SHARE = new SignCalculatorButton(R.id.share, (view, expression) -> expression.addExpressionComponent(" / "));

    public static final CalculatorButton SHARE_MODULE = new SignCalculatorButton(R.id.module_share, (view, expression) -> expression.addExpressionComponent(" % "));

    public static final CalculatorButton MULTIPLY = new SignCalculatorButton(R.id.multiply, (view, expression) -> expression.addExpressionComponent(" * "));

    public static final CalculatorButton _0 = new NumberCalculatorButton(R.id.zero, (view, expression) -> expression.addExpressionComponent("0"));

    public static final CalculatorButton _1 = new NumberCalculatorButton(R.id._1, (view, expression) -> expression.addExpressionComponent("1"));

    public static final CalculatorButton _2 = new NumberCalculatorButton(R.id._2, (view, expression) -> expression.addExpressionComponent("2"));

    public static final CalculatorButton _3 = new NumberCalculatorButton(R.id._3, (view, expression) -> expression.addExpressionComponent("3"));

    public static final CalculatorButton _4 = new NumberCalculatorButton(R.id._4, (view, expression) -> expression.addExpressionComponent("4"));

    public static final CalculatorButton _5 = new NumberCalculatorButton(R.id._5, (view, expression) -> expression.addExpressionComponent("5"));

    public static final CalculatorButton _6 = new NumberCalculatorButton(R.id._6, (view, expression) -> expression.addExpressionComponent("6"));

    public static final CalculatorButton _7 = new NumberCalculatorButton(R.id._7, (view, expression) -> expression.addExpressionComponent("7"));

    public static final CalculatorButton _8 = new NumberCalculatorButton(R.id._8, (view, expression) -> expression.addExpressionComponent("8"));

    public static final CalculatorButton _9 = new NumberCalculatorButton(R.id._9, (view, expression) -> expression.addExpressionComponent("9"));

    public static final CalculatorButton EQUAL = new DefaultImpl(R.id.equal, (view, expression) -> {
        expression.calculateResult();
    });

    public static final CalculatorButton REMOVE_LEFT = new DefaultImpl(R.id.remove_left, (view, expression) -> {
        expression.removeLeftExpressionComponent();
    });

    public static final CalculatorButton CLEAR = new DefaultImpl(R.id.clear, (view, expression) -> {
        expression.clearExpressionComponent();
    });

    public static final CalculatorButton BRACKET = new FunctionCalculatorButton(R.id.bracket, (view, expression) -> {
        expression.addExpressionComponent("(");
    });

    public static final CalculatorButton BRACKET_2 = new SignCalculatorButton(R.id.bracket_2, (view, expression) -> {
        expression.addExpressionComponent(")");
    });

    public static final CalculatorButton ROOT = new SignCalculatorButton(R.id.root, (view, expression) -> {
        expression.addExpressionComponent("√");
    });

    public static final CalculatorButton COS = new FunctionCalculatorButton(R.id.cos, (view, expression) -> {
        expression.addExpressionComponent("cos(");
    });

    public static final CalculatorButton ACOS = new FunctionCalculatorButton(R.id.acos, (view, expression) -> {
        expression.addExpressionComponent("acos(");
    });

    public static final CalculatorButton SIN = new FunctionCalculatorButton(R.id.sin, (view, expression) -> {
        expression.addExpressionComponent("sin(");
    });

    public static final CalculatorButton ASIN = new FunctionCalculatorButton(R.id.asin, (view, expression) -> {
        expression.addExpressionComponent("asin(");
    });

    public static final CalculatorButton TAN = new FunctionCalculatorButton(R.id.tan, (view, expression) -> {
        expression.addExpressionComponent("tan(");
    });

    public static final CalculatorButton ATAN = new FunctionCalculatorButton(R.id.atan, (view, expression) -> {
        expression.addExpressionComponent("atan(");
    });

    public static final CalculatorButton LOG = new FunctionCalculatorButton(R.id.lg, (view, expression) -> {
        expression.addExpressionComponent("log(");
    });

}
