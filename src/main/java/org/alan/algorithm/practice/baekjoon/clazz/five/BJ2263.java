package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
public class BJ2263 {
    private int[] preorder, inorder, postorder;
    private int idx;

    public String solve(String input) {
        String[] lines = input.split("\n");
        preorder = new int[Integer.parseInt(lines[0])];
        inorder = Pattern.compile(" ").splitAsStream(lines[1]).mapToInt(Integer::parseInt).toArray();
        postorder = Pattern.compile(" ").splitAsStream(lines[2]).mapToInt(Integer::parseInt).toArray();

        getPreOrder(0, preorder.length - 1, 0, preorder.length - 1);

        return Arrays.stream(preorder).mapToObj(String::valueOf).collect(Collectors.joining(" "));
    }

    private void getPreOrder(int is, int ie, int ps, int pe) {
        if (is > ie || ps > pe) return;

        preorder[idx++] = postorder[pe];
        int pos = IntStream.rangeClosed(is, ie).filter(i -> inorder[i] == postorder[pe]).findFirst().orElse(is);
        getPreOrder(is, pos - 1, ps, ps + pos - is - 1);
        getPreOrder(pos + 1, ie, ps + pos - is, pe - 1);
    }

}
