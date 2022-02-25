package me.akamex.akamexcalculate.fragment;

import me.akamex.akamexcalculate.R;
import me.akamex.akamexcalculate.button.CalculatorButtons;
import me.akamex.akamexcalculate.expression.CalculatorExpression;

public class ExtendedCalculatorFragment extends CalculatorFragment {

    public ExtendedCalculatorFragment(CalculatorExpression expression, CalculatorButtons buttons) {
        super(R.layout.fragment_extend_calculate, () -> new SimpleCalculatorFragment(expression, buttons), expression, buttons);
    }
}
