package datastructure.InterfaceTest.test1;

import datastructure.InterfaceTest.Parent;

public interface ChildB extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
