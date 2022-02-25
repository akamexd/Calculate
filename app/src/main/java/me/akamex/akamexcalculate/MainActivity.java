package me.akamex.akamexcalculate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import me.akamex.akamexcalculate.button.CalculatorButtons;
import me.akamex.akamexcalculate.expression.CalculatorExpression;
import me.akamex.akamexcalculate.fragment.SimpleCalculatorFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment currentMode;
    private final CalculatorExpression expression = new CalculatorExpression();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null || currentMode == null) {
            currentMode = new SimpleCalculatorFragment(expression, CalculatorButtons.defaultSetup());

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.buttonLayout, currentMode, currentMode.getTag());
            fragmentTransaction.commit();
        }
    }

}