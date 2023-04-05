package org.alan.algorithm.lab;

public class Stream {

    public static void main(String[] args) {
        String s = "adfaghawe";
        Character[] characters = s.chars()
            .mapToObj(character -> (char) character)
            .toArray(Character[]::new);
    }
}
