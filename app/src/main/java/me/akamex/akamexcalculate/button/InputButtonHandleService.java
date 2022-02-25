package me.akamex.akamexcalculate.button;

import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.function.Consumer;

public class InputButtonHandleService {

    private final Set<InputButtonHandle> inputButtonHandles;

    public InputButtonHandleService(InputButtonHandle... inputButtonHandles) {
        this.inputButtonHandles = new HashSet<>(Arrays.asList(inputButtonHandles));
    }

    public void setup(View view, Consumer<String> expressionConsumer) {
        inputButtonHandles.forEach(inputButtonHandle -> inputButtonHandle.setupHandle(view, expressionConsumer));
    }

}
