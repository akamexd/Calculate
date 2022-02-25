package me.akamex.akamexcalculate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.widget.EditText;

import me.akamex.akamexcalculate.button.InputButtonHandleService;
import me.akamex.akamexcalculate.button.MinusButton;
import me.akamex.akamexcalculate.button.PlusButton;

public class MainActivity extends AppCompatActivity {

    private Fragment currentMode;

    private InputButtonHandleService inputButtonHandleService = new InputButtonHandleService(
        new PlusButton(), new MinusButton()
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null || currentMode == null) {
            currentMode = SimpleCalculate.newInstance(inputButtonHandleService);

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.buttonLayout, currentMode, currentMode.getTag());
            fragmentTransaction.commit();
        }
    }

}