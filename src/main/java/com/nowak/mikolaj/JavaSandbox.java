package com.nowak.mikolaj;

import com.nowak.mikolaj.syntax.*;
import io.reactivex.Single;
import kotlin.Unit;
import kotlin.jvm.JvmDefault;
import org.jetbrains.annotations.NotNull;

public class JavaSandbox {

    public Bar bar = new Bar("id");
    @NotNull
    public Bar nnBar = new Bar("id");

    public void playWithKotlin() {
        BarKt.isZero((aSuper, s) -> {
            aSuper.foo();
        });
        Singleton.INSTANCE.foo();
        Bar.companionFoo();

        new Sss("name", 1);

    }
}
