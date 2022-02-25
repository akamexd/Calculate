package me.akamex.akamexcalculate.button;

import android.view.View;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;

import me.akamex.akamexcalculate.expression.CalculatorExpression;

public abstract class CalculatorButton {

    protected final int id;
    protected final BiConsumer<View, CalculatorExpression> onClick;

    protected CalculatorButton(int id, BiConsumer<View, CalculatorExpression> onClick) {
        this.id = id;
        this.onClick = onClick;
    }

    public int getId() {
        return id;
    }

    public void onClick(View view, CalculatorExpression expression) {
        onClick.accept(view, expression);
    }
}
