package com.nowak.mikolaj.generics;

public class HolderExample {

    interface Holder<T> {
        T get();
    }
    void foo(Holder<String> holder) {
        Holder<Object> objectHolder = holder;
    }
}
