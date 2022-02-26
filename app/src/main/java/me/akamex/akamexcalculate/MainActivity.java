package me.akamex.akamexcalculate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import me.akamex.akamexcalculate.button.CalculatorButtonImpl;
import me.akamex.akamexcalculate.button.CalculatorButtons;
import me.akamex.akamexcalculate.expression.CalculatorExpression;
import me.akamex.akamexcalculate.expression.Exp4jExpressionSolver;
import me.akamex.akamexcalculate.fragment.SimpleCalculatorFragment;

public class MainActivity extends AppCompatActivity {

    private Fragment currentMode;
    private final CalculatorExpression expression = new CalculatorExpression(new Exp4jExpressionSolver());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState == null || currentMode == null) {
            currentMode = new SimpleCalculatorFragment(expression, CalculatorButtons.defaultSetup(
                    CalculatorButtonImpl.MINUS, CalculatorButtonImpl.PLUS, CalculatorButtonImpl.EQUAL,
                    CalculatorButtonImpl._1, CalculatorButtonImpl._2, CalculatorButtonImpl._3,
                    CalculatorButtonImpl._4, CalculatorButtonImpl._5, CalculatorButtonImpl._6,
                    CalculatorButtonImpl._7, CalculatorButtonImpl._8, CalculatorButtonImpl._9,
                    CalculatorButtonImpl.SHARE_MODULE, CalculatorButtonImpl.SHARE, CalculatorButtonImpl.MULTIPLY,
                    CalculatorButtonImpl.CLEAR, CalculatorButtonImpl.REMOVE_LEFT,
                    CalculatorButtonImpl.ACOS, CalculatorButtonImpl.COS, CalculatorButtonImpl.SIN, CalculatorButtonImpl.ASIN,
                    CalculatorButtonImpl.TAN, CalculatorButtonImpl.ATAN, CalculatorButtonImpl.BRACKET, CalculatorButtonImpl.BRACKET_2,
                    CalculatorButtonImpl._0, CalculatorButtonImpl.ROOT, CalculatorButtonImpl.LOG
            ));

            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.add(R.id.buttonLayout, currentMode, currentMode.getTag());
            fragmentTransaction.commit();
        }
    }

}