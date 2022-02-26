package me.akamex.akamexcalculate.button;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

import me.akamex.akamexcalculate.R;
import me.akamex.akamexcalculate.expression.CalculatorExpression;

public interface CalculatorButtons {

    void setup(View view, CalculatorExpression expression);

    static CalculatorButtons defaultSetup(CalculatorButton... buttons) {
        return (view, expression) -> Arrays.asList(buttons).forEach(calculatorButton -> {
            Button button = view.findViewById(calculatorButton.getId());
            if(button == null) {
                return;
            }
            button.setOnClickListener(view1 -> {
                calculatorButton.onClick(view, expression);

                TextView expressionView = view.getRootView().findViewById(R.id.expression);
                expressionView.setText(expression.getHandling());

                TextView resultView = view.getRootView().findViewById(R.id.result);
                resultView.setText(expression.getResult());
            });
        });
    }

}
