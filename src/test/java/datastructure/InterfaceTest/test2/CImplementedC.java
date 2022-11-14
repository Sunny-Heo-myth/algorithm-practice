package datastructure.InterfaceTest.test2;

public class CImplementedC implements ChildC {

    static int index = 0;
    static int[] ints = {1,2,3,4};

    @Override
    public void childCMethod() {
        index++;
        System.out.println("CImplementedC" + ints[index % 4]);
        System.out.println("--------------------");
    }

    @Override
    public void parentMethod() {
        System.out.println("CImplementedC parentMethod");
    }
}
