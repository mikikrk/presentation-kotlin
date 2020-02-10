package com.nowak.mikolaj;

import com.nowak.mikolaj.step_1_syntax.Bar;
import com.nowak.mikolaj.step_1_syntax.Bar2;
import com.nowak.mikolaj.step_1_syntax.BarKt;
import com.nowak.mikolaj.step_1_syntax.Singleton;
import com.nowak.mikolaj.step_1_syntax.Utils;
import com.nowak.mikolaj.step_2_datastructures.Person;
import javafx.beans.DefaultProperty;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class JavaSandbox {

    void appendExtends(List<? extends Integer> list, int item){
        list.add(item);
    }
    void appendSupers (List<? super Integer> list, int item){
        list.add(item);
    }
    byte getExtends(List<? extends Integer> list, int item){
        return list.get(item).byteValue();
    }
    byte getSupers(List<? super Integer> list, int item){
        return list.get(item).byteValue();
    }

    interface Holder<T> {
        T get();
    }

    void foo(Holder<String> holder) {
        Holder<? extends Object> objectHolder = holder;
    }

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

        CollectionsKt.plus(
                CollectionsKt.listOf(new Object()),
                CollectionsKt.mutableListOf(new Object())
        );

        appendExtends(new ArrayList<Integer>(), 0);
        appendExtends(new ArrayList<Number>(), 0);
        appendSupers(new ArrayList<Number>(), 0);

        Utils singleton = Utils.INSTANCE;
        String url = Utils.URL;

        Bar.foon();
        String sth = Bar.sth;

        Bar2 bar2 = new Bar2();

        Person person = new Person();
        int id = person.id;
    }
}
