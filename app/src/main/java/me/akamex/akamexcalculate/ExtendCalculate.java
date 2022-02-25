package me.akamex.akamexcalculate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.function.Supplier;

import me.akamex.akamexcalculate.button.InputButtonHandleService;

public class ExtendCalculate extends CalculateFragment {

    public ExtendCalculate(InputButtonHandleService inputButtonHandleService) {
        super(inputButtonHandleService, R.layout.fragment_extend_calculate, () -> SimpleCalculate.newInstance(inputButtonHandleService));
    }

    public static ExtendCalculate newInstance(InputButtonHandleService inputButtonHandleService) {
        ExtendCalculate fragment = new ExtendCalculate(inputButtonHandleService);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

}