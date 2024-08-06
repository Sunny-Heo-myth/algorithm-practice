package org.alan.algorithm.lab.datastructure.InterfaceTest.test1;

import org.alan.algorithm.lab.datastructure.InterfaceTest.Parent;

public interface ChildB extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
