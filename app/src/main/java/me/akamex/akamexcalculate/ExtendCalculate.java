package me.akamex.akamexcalculate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ExtendCalculate extends Fragment {

    public ExtendCalculate() {
    }

    public static ExtendCalculate newInstance() {
        ExtendCalculate fragment = new ExtendCalculate();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void switchMode() {
        Fragment currentMode = SimpleCalculate.newInstance();

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.setCustomAnimations(0, R.animator.slide_in_right);
        fragmentTransaction.replace(R.id.buttonLayout, currentMode);
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_extend_calculate, container, false);

        view.findViewById(R.id.switch_mode).setOnClickListener(view1 -> switchMode());

        return view;
    }
}