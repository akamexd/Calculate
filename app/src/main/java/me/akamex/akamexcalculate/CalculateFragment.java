package me.akamex.akamexcalculate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import me.akamex.akamexcalculate.button.InputButtonHandleService;

public abstract class CalculateFragment extends Fragment {

    private final InputButtonHandleService inputButtonHandleService;
    private final int layoutId;
    private final Supplier<CalculateFragment> fragmentSwitchSupplier;

    protected CalculateFragment(InputButtonHandleService inputButtonHandleService, int layoutId, Supplier<CalculateFragment> fragmentSwitchSupplier) {
        this.inputButtonHandleService = inputButtonHandleService;
        this.layoutId = layoutId;
        this.fragmentSwitchSupplier = fragmentSwitchSupplier;
    }

    protected void switchMode(Supplier<CalculateFragment> fragmentSupplier) {
        CalculateFragment currentMode = fragmentSupplier.get();

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.buttonLayout, currentMode);
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(layoutId, container, false);

        TextView expression = container.getRootView().findViewById(R.id.expression);
        view.findViewById(R.id.switch_mode).setOnClickListener(view1 -> switchMode(fragmentSwitchSupplier));

        inputButtonHandleService.setup(view, result -> {
            if(result != null && !result.isEmpty()) {
                expression.setText(expression.getText() + result);
            }
        });

        return view;
    }

}
