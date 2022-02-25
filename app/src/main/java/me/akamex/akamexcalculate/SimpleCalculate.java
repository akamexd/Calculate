package me.akamex.akamexcalculate;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.akamex.akamexcalculate.button.InputButtonHandleService;

public class SimpleCalculate extends CalculateFragment  {

    public SimpleCalculate(InputButtonHandleService inputButtonHandleService) {
        super(inputButtonHandleService, R.layout.fragment_simple_calculate, () -> ExtendCalculate.newInstance(inputButtonHandleService));
    }

    public static SimpleCalculate newInstance(InputButtonHandleService inputButtonHandleService) {
        SimpleCalculate fragment = new SimpleCalculate(inputButtonHandleService);
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

}