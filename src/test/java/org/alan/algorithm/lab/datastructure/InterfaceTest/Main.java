package org.alan.algorithm.lab.datastructure.InterfaceTest;

import org.alan.algorithm.lab.datastructure.InterfaceTest.test2.*;

public class Main {
    public static void main(String[] args) {

        ChildC childC;

        childC = new AImplementedC();
        childC.childCMethod();

        childC.parentMethod();
//-------------------------------------------
        childC = new BImplementedC();
        childC.childCMethod();

        childC.parentMethod();
//-------------------------------------------
        childC = new CImplementedC();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();

        childC.parentMethod();
//-------------------------------------------
        childC = new DImplementedC(2);
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();

        childC.parentMethod();
//-------------------------------------------
        childC = new DImplementedC(4);
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();
        childC.childCMethod();

        childC.parentMethod();
    }
}
