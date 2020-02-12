package com.nowak.mikolaj.generics;

import java.util.ArrayList;
import java.util.List;

public class Generics {

    void appendExtends(List<? extends Integer> list, int item){
        list.add(item);
    }
    void appendSupers (List<? super Integer> list, int item){
        list.add(item);
    }

    void foo() {
        appendExtends(new ArrayList<Integer>(), 0);
        appendExtends(new ArrayList<Number>(), 0);
        appendSupers(new ArrayList<Number>(), 0);
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
        Holder<Object> objectHolder = holder;
    }
}
