package org.alan.algorithm.lab.datastructure.InterfaceTest.test1;

import org.alan.algorithm.lab.datastructure.InterfaceTest.Parent;

public interface ChildA extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
