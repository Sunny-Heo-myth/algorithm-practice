package basicDataStructure.InterfaceTest.test1;

import basicDataStructure.InterfaceTest.Parent;

public interface ChildB extends Parent {
    void childMethod();

    @Override
    void parentMethod();
}
