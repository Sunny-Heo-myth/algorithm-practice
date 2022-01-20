package baekjoon.java.javaSort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;


public class BJ1181 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());

        String[] strings = new String[n];
        for (int i = 0; i < n; i++) {
            strings[i] = bf.readLine();
        }

        HashMap<Integer, List<String>> countingStrListMap = new HashMap<>();
        char[] countingChars = new char[51];
        for (int i = 0; i < strings.length; i++) {
            int strLength = strings[i].length();
            countingChars[strLength]++;

            if (!countingStrListMap.containsKey(strLength)) {
                countingStrListMap.put(strLength, new ArrayList<>());
                countingStrListMap.get(strLength).add(strings[i]);
            }
            else {
                countingStrListMap.get(strLength).add(strings[i]);
            }
        }



        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 51; i++) {
            if (countingStrListMap.get(i) != null) {
                for (int j = 0; j < countingStrListMap.get(i).size(); j++) {
                    sb.append(countingStrListMap.get(i).get(j)).append("\n");
                }
            }
        }
        System.out.print(sb);


    }
}
