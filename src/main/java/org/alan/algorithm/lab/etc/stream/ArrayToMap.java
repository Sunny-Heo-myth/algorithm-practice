package org.alan.algorithm.lab.etc.stream;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ArrayToMap {

    public void run() {
        Long[] numbers = {1L, 2L, 3L, 2L, 3L, 3L};

        Map<Long, Integer> frequencyMap = Arrays.stream(numbers)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.reducing(0, e -> 1, Integer::sum)));

        System.out.print(frequencyMap);  // Outputs: {1=1, 2=2, 3=3}
    }
}
