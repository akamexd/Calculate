package me.akamex.akamexcalculate;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.function.Supplier;

public abstract class CalculateFragment extends Fragment {

    private final int layoutId;
    private final Supplier<CalculateFragment> fragmentSwitchSupplier;

    protected CalculateFragment(int layoutId, Supplier<CalculateFragment> fragmentSwitchSupplier) {
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

        view.findViewById(R.id.switch_mode).setOnClickListener(view1 -> switchMode(fragmentSwitchSupplier));

        return view;
    }

}
