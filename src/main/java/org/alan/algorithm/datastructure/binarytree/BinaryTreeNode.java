package org.alan.algorithm.datastructure.binarytree;

import lombok.Getter;

@Getter
public class BinaryTreeNode {
    BinaryTreeNode leftChild;
    BinaryTreeNode rightChild;
    private Object data;

    public BinaryTreeNode(Object data) {
        this.data = data;
    }

}
