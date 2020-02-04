package com.nowak.mikolaj;

import com.nowak.mikolaj.step_1_syntax.Bar;
import com.nowak.mikolaj.step_1_syntax.BarKt;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;

public class JavaSandbox {

    @NotNull
    public Bar bar = new Bar(
            1,
            "Jon"
    );

    public void playWithKotlin() {
        bar.getId();
        bar.setId();
        bar.getId().byteValue();
        bar.foo(1);
        bar.foo9(() -> {
            return Unit.INSTANCE;
        });
        BarKt.foo11(bar);
        BarKt.foo13(bar, (bar1 -> {
            return bar1.getId();
        }));
    }
}
