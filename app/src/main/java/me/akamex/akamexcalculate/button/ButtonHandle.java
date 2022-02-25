package me.akamex.akamexcalculate.button;

import android.view.View;

import java.util.function.Function;

public abstract class ButtonHandle implements InputButtonHandle {

    protected final int idNeed;
    protected final Function<View, String> clickHandle;

    protected ButtonHandle(int idNeed, Function<View, String> clickHandle) {
        this.idNeed = idNeed;
        this.clickHandle = clickHandle;
    }

    @Override
    public int getIdHandle() {
        return idNeed;
    }

    @Override
    public String handleClick(View view) {
        return clickHandle.apply(view);
    }
}
