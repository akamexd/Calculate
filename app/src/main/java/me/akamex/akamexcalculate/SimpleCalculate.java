package me.akamex.akamexcalculate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class SimpleCalculate extends Fragment {

    public SimpleCalculate() {
    }

    public static SimpleCalculate newInstance() {
        SimpleCalculate fragment = new SimpleCalculate();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void switchMode() {
        Fragment currentMode = ExtendCalculate.newInstance();

        FragmentManager fragmentManager = getParentFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.buttonLayout, currentMode);
        fragmentTransaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_simple_calculate, container, false);

        view.findViewById(R.id.switch_mode).setOnClickListener(view1 -> switchMode());

        return view;
    }
}