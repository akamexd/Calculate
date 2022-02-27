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

    private static class AfterDigitOrEmptyAddComponentCalculatorButton extends DefaultImpl {

        public AfterDigitOrEmptyAddComponentCalculatorButton(int id, String component) {
            super(id, (view, expression) -> {
                String handling = expression.getHandling();
                if(handling.length() != 0 && !NumberUtils.isDigits(handling.substring(handling.length() - 1))) {
                    return;
                }

                expression.addExpressionComponent(component);
            });
        }

    }

    private static class AfterDigitOrBracketAddComponentCalculatorButton extends DefaultImpl {

        public AfterDigitOrBracketAddComponentCalculatorButton(int id, String component) {
            super(id, (view, expression) -> {
                String handling = expression.getHandling();
                if(handling.length() == 0) {
                    return;
                }
                String last = handling.substring(handling.length() - 1);
                if(!NumberUtils.isDigits(last) && !last.equals(")")) {
                    return;
                }

                expression.addExpressionComponent(component);
            });
        }

    }

    private static class AfterDigitAddComponentCalculatorButton extends DefaultImpl {

        public AfterDigitAddComponentCalculatorButton(int id, String component) {
            super(id, (view, expression) -> {
                String handling = expression.getHandling();
                if(handling.length() == 0) {
                    return;
                }
                String last = handling.substring(handling.length() - 1);
                if(!NumberUtils.isDigits(last)) {
                    return;
                }

                expression.addExpressionComponent(component);
            });
        }

    }

    private static class AfterSignOrEmptyAddComponentCalculatorButton extends DefaultImpl {

        public AfterSignOrEmptyAddComponentCalculatorButton(int id, String component) {
            super(id, (view, expression) -> {
                String handling = expression.getHandling();
                if(handling.length() != 0) {
                    String last = handling.substring(handling.length() - 1);
                    if(NumberUtils.isDigits(last) || last.equals(")")) {
                        return;
                    }
                }

                expression.addExpressionComponent(component);
            });
        }

    }

    private static class AnywhereAddComponentCalculatorButton extends DefaultImpl {

        public AnywhereAddComponentCalculatorButton(int id, String component) {
            super(id, (view, expression) -> {
                String handling = expression.getHandling();
                if(handling.endsWith(")")) {
                    return;
                }

                expression.addExpressionComponent(component);
            });
        }

    }

    public static final CalculatorButton PLUS = new AfterDigitOrBracketAddComponentCalculatorButton(R.id.add, " + ");

    public static final CalculatorButton MINUS = new AfterDigitOrBracketAddComponentCalculatorButton(R.id.minus, " - ");

    public static final CalculatorButton SHARE = new AfterDigitOrBracketAddComponentCalculatorButton(R.id.share, " / ");

    public static final CalculatorButton SHARE_MODULE = new AfterDigitOrBracketAddComponentCalculatorButton(R.id.module_share, " % ");

    public static final CalculatorButton MULTIPLY = new AfterDigitOrBracketAddComponentCalculatorButton(R.id.multiply, " * ");

    public static final CalculatorButton _0 = new AnywhereAddComponentCalculatorButton(R.id.zero, "0");

    public static final CalculatorButton _1 = new AnywhereAddComponentCalculatorButton(R.id._1, "1");

    public static final CalculatorButton _2 = new AnywhereAddComponentCalculatorButton(R.id._2, "2");

    public static final CalculatorButton _3 = new AnywhereAddComponentCalculatorButton(R.id._3, "3");

    public static final CalculatorButton _4 = new AnywhereAddComponentCalculatorButton(R.id._4, "4");

    public static final CalculatorButton _5 = new AnywhereAddComponentCalculatorButton(R.id._5, "5");

    public static final CalculatorButton _6 = new AnywhereAddComponentCalculatorButton(R.id._6, "6");

    public static final CalculatorButton _7 = new AnywhereAddComponentCalculatorButton(R.id._7, "7");

    public static final CalculatorButton _8 = new AnywhereAddComponentCalculatorButton(R.id._8, "8");

    public static final CalculatorButton _9 = new AnywhereAddComponentCalculatorButton(R.id._9, "9");

    public static final CalculatorButton EQUAL = new DefaultImpl(R.id.equal, (view, expression) -> expression.calculateResult());

    public static final CalculatorButton REMOVE_LEFT = new DefaultImpl(R.id.remove_left, (view, expression) -> expression.removeLeftExpressionComponent());

    public static final CalculatorButton CLEAR = new DefaultImpl(R.id.clear, (view, expression) -> expression.clearExpressionComponent());

    public static final CalculatorButton BRACKET = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.bracket, "(");

    public static final CalculatorButton BRACKET_2 = new DefaultImpl(R.id.bracket_2, (view, expression) -> {
        String handling = expression.getHandling();
        if(handling.length() == 0) {
            String last = handling.substring(handling.length() - 1);
            if(!NumberUtils.isDigits(last) && last.equals(")")) {
                return;
            }
        }

        expression.addExpressionComponent(")");
    });

    public static final CalculatorButton ROOT = new AfterDigitOrEmptyAddComponentCalculatorButton(R.id.root, "sqrt(");

    public static final CalculatorButton COS = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.cos, "cos(");

    public static final CalculatorButton ACOS = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.acos, "acos(");

    public static final CalculatorButton SIN = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.sin, "sin(");

    public static final CalculatorButton ASIN = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.asin, "asin(");

    public static final CalculatorButton TAN = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.tan, "tan(");

    public static final CalculatorButton ATAN = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.atan, "atan(");

    public static final CalculatorButton LOG = new AfterSignOrEmptyAddComponentCalculatorButton(R.id.lg, "log(");

    public static final CalculatorButton POINT = new AfterDigitAddComponentCalculatorButton(R.id.point, ".");

}
