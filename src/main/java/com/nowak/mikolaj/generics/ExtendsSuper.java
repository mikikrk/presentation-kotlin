package com.nowak.mikolaj.generics;

import java.util.ArrayList;
import java.util.List;

public class ExtendsSuper {

    interface Super {
        Super superMethod();
    }

    interface Child extends Super {
        Child childMethod();
    }

    interface ChildOfChild extends Child {
        ChildOfChild childOfChildMethod();
    }




    Child getExtends(List<? extends Child> list, int index) {
        return list.get(index).childMethod();
    }

    Child getSupers(List<? super Child> list, int item) {
        return list.get(item).childMethod();
    }

    void getting() {
        getExtends(new ArrayList<Super>(), 0);
        getExtends(new ArrayList<Child>(), 0);
        getExtends(new ArrayList<ChildOfChild>(), 0);

        getSupers(new ArrayList<Super>(), 0);
        getSupers(new ArrayList<Child>(), 0);
        getSupers(new ArrayList<ChildOfChild>(), 0);
    }




    void appendExtends(List<? extends Child> list, Child item){
        list.add(item);
    }
    void appendSupers (List<? super Child> list, Child item){
        list.add(item);
    }

    private Child child;

    void appending() {
        appendExtends(new ArrayList<Super>(), child);
        appendExtends(new ArrayList<Child>(), child);
        appendExtends(new ArrayList<ChildOfChild>(), child);

        appendSupers(new ArrayList<Super>(), child);
        appendSupers(new ArrayList<Child>(), child);
        appendSupers(new ArrayList<ChildOfChild>(), child);
    }
}
