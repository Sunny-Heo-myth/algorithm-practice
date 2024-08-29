package org.alan.algorithm.lab.InterfaceTest.test1;

import org.alan.algorithm.lab.InterfaceTest.Parent;

public interface ChildA extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
