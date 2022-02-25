package me.akamex.akamexcalculate.fragment;

import me.akamex.akamexcalculate.R;
import me.akamex.akamexcalculate.button.CalculatorButtons;
import me.akamex.akamexcalculate.expression.CalculatorExpression;

public class SimpleCalculatorFragment extends CalculatorFragment {

    public SimpleCalculatorFragment(CalculatorExpression expression, CalculatorButtons buttons) {
        super(R.layout.fragment_simple_calculate, () -> new ExtendedCalculatorFragment(expression, buttons), expression, buttons);
    }
}
