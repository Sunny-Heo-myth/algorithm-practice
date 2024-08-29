package org.alan.algorithm.lab.InterfaceTest.test2;

public class DImplementedC implements ChildC {

    int index;
    static int[] ints = {444,555,666,777,888,999};

    public DImplementedC(int index) {
        this.index = index;
    }

    @Override
    public void childCMethod() {
        index++;
        System.out.println("DImplementedC" + ints[index % 6]);
        System.out.println("--------------------");
    }

    @Override
    public void parentMethod() {
        System.out.println("DImplementedC parentMethod");
    }
}
