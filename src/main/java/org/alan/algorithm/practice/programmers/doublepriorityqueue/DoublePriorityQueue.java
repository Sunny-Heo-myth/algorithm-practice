package org.alan.algorithm.practice.programmers.doublepriorityqueue;

import java.util.ArrayList;
import java.util.Objects;

public class DoublePriorityQueue {
    private final ArrayList<Integer> numbers = new ArrayList<>();

    public int[] solution(String[] operations) {
        Operation[] operationArray = parse(operations);
        execute(operationArray);
        return getPolars();
    }

    private Operation[] parse(String[] operations) {
        Operation[] operationArray = new Operation[operations.length];
        for (int i = 0; i < operations.length; i++) {
            String[] ss = operations[i].split(" ");
            int number = Integer.parseInt(ss[1]);

            if (Objects.equals(ss[0], "I")) {
                operationArray[i] = new Operation(OperationType.INSERT, number);
            } else {
                if (number == 1) {
                    operationArray[i] = new Operation(OperationType.DELETE_MAX, number);
                } else {
                    operationArray[i] = new Operation(OperationType.DELETE_MIN, number);
                }
            }
        }
        return operationArray;
    }

    private void execute(Operation[] operations) {
        for (Operation o : operations) {
            switch (o.getType()) {
                case INSERT:
                    numbers.add(o.getNumber());
                    break;
                case DELETE_MAX:
                    deleteMax();
                    break;
                case DELETE_MIN:
                    deleteMin();
                    break;
                default:
                    break;
            }
        }
    }

    private void deleteMax() {
        if (numbers.isEmpty()) {
            return;
        }

        numbers.remove(getMax());
    }

    private Integer getMax() {
        int max = Integer.MIN_VALUE;
        for (int i : numbers) {
            max = Math.max(max, i);
        }
        return max;
    }

    private void deleteMin() {
        if (numbers.isEmpty()) {
            return;
        }

        numbers.remove(getMin());
    }

    private Integer getMin() {
        int min = Integer.MAX_VALUE;
        for (int i : numbers) {
            min = Math.min(min, i);
        }
        return min;
    }

    private int[] getPolars() {
        if (numbers.isEmpty()) {
            return new int[]{0, 0};
        }

        return new int[]{getMax(), getMin()};
    }

    private static class Operation {
        private final OperationType type;
        private final int number;

        public Operation(OperationType type, int number) {
            this.type = type;
            this.number = number;
        }

        public OperationType getType() {
            return type;
        }

        public int getNumber() {
            return number;
        }
    }

    private enum OperationType {
        INSERT, DELETE_MAX, DELETE_MIN
    }

}
