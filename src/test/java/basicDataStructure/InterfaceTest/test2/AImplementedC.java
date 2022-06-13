package basicDataStructure.InterfaceTest.test2;

public class AImplementedC implements ChildC {
    @Override
    public void childCMethod() {
        System.out.println("AImplementedC");
    }

    @Override
    public void parentMethod() {
        System.out.println("AImplementedC parentMethod");
    }
}
