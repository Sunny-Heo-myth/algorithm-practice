package com.baekjoonPractice.stepByStep.bruteForceStep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BJ7568 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] strings = bf.readLine().split(" ");
            personList.add(new Person(Integer.parseInt(strings[0]), Integer.parseInt(strings[1]), 1));
        }

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Person p1 = personList.get(i);
                Person p2 = personList.get(j);

                if (p1.height > p2.height && p1.weight > p2.weight) p2.grade++;
                else if (p1.height < p2.height && p1.weight < p2.weight) p1.grade++;

            }
        }
        StringBuilder sb = new StringBuilder();
        personList
            .forEach(person -> sb.append(person.grade).append(" "));

        System.out.print(sb);


    }
}

class Person {
    int weight;
    int height;
    int grade;

    public Person(int weight, int height, int grade) {
        this.weight = weight;
        this.height = height;
        this.grade = grade;
    }
}

