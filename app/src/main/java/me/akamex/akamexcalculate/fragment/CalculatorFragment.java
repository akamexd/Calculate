package me.akamex.akamexcalculate.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.function.Supplier;

import me.akamex.akamexcalculate.R;
import me.akamex.akamexcalculate.button.CalculatorButtons;
import me.akamex.akamexcalculate.expression.CalculatorExpression;

public abstract class CalculatorFragment extends Fragment {

    protected final int layoutId;
    protected final Supplier<CalculatorFragment> fragmentSwitchSupplier;
    protected final CalculatorExpression expression;
    protected final CalculatorButtons buttons;

    protected CalculatorFragment(int layoutId, Supplier<CalculatorFragment> fragmentSwitchSupplier, CalculatorExpression expression, CalculatorButtons buttons) {
        this.layoutId = layoutId;
        this.fragmentSwitchSupplier = fragmentSwitchSupplier;
        this.expression = expression;
        this.buttons = buttons;
    }

    protected void switchMode() {
        CalculatorFragment currentMode = fragmentSwitchSupplier.get();

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.buttonLayout, currentMode);
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, container, false);

        view.findViewById(R.id.switch_mode).setOnClickListener(view1 -> switchMode());
        buttons.setup(view, expression);

        return view;
    }
}
