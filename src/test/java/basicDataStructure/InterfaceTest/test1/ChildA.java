package basicDataStructure.InterfaceTest.test1;

import basicDataStructure.InterfaceTest.Parent;

public interface ChildA extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
