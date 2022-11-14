package datastructure.InterfaceTest.test2;

public class BImplementedC implements ChildC {
    @Override
    public void childCMethod() {
        System.out.println("BImplementedC");
    }

    @Override
    public void parentMethod() {
        System.out.println("BImplementedC parentMethod");
    }
}
