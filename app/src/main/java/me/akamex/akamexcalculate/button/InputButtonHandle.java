package me.akamex.akamexcalculate.button;

import android.view.View;
import android.widget.Button;

import java.util.function.Consumer;
import java.util.function.Function;

public interface InputButtonHandle {

    int getIdHandle();

    default void setupHandle(View view, Consumer<String> action) {
        view.findViewById(getIdHandle()).setOnClickListener(view1 -> action.accept(handleClick(view1)));
    }

    String handleClick(View view);

}
