package org.alan.algorithm.datastructure.InterfaceTest.test1;

import org.alan.algorithm.datastructure.InterfaceTest.Parent;

public interface ChildB extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
