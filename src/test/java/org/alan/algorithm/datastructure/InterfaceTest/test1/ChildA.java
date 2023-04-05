package org.alan.algorithm.datastructure.InterfaceTest.test1;

import org.alan.algorithm.datastructure.InterfaceTest.Parent;

public interface ChildA extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
