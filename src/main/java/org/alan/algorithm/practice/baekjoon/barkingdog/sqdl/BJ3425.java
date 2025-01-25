package org.alan.algorithm.practice.baekjoon.barkingdog.sqdl;

import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class BJ3425 {
    private final Stack<Long> stack = new Stack<>();
    private List<String> instructions;
    private static final long MAX = 1_000_000_000, INVALID = Long.MAX_VALUE;

    public String solve(String input) {
        instructions = input.lines()
                .takeWhile(s -> !s.equals("END"))
                .collect(Collectors.toList());

        return input.lines()
                .dropWhile(s -> !s.equals("END"))
                .skip(2)
                .map(s -> execute(Long.parseLong(s)))
                .collect(Collectors.joining("\n")) + "\n";
    }

    private String execute(long i) {
        stack.clear();
        stack.push(i);
        for (String instr : instructions) {
            if (instr.length() > 3) {
                stack.push(Long.parseLong(instr.split(" ")[1]));
            } else {
                if (stack.isEmpty()) return "ERROR";
                long x = stack.pop();
                switch (instr) {
                    case "POP": break;
                    case "INV": stack.push(-x); break;
                    case "DUP": stack.push(x); stack.push(x); break;
                    default:
                        if (stack.isEmpty()) return "ERROR";
                        long y = stack.pop();
                        if (instr.equals("SWP")) {
                            stack.push(x);
                            stack.push(y);
                        } else {
                            stack.push(switch (instr) {
                                case "ADD" -> validate(x + y);
                                case "SUB" -> validate(y - x);
                                case "MUL" -> validate(x * y);
                                case "DIV" -> {
                                    if (x == 0) yield INVALID;
                                    long z = Math.abs(y) / Math.abs(x);
                                    yield validate(((y < 0 && x > 0) || (y > 0 && x < 0)) ? -z : z);
                                }
                                case "MOD" -> {
                                    if (x == 0) yield INVALID;
                                    long z = Math.abs(y) % Math.abs(x);
                                    yield validate(y < 0 ? -z : z);
                                }
                                default -> throw new IllegalStateException("Unexpected value: " + instr);
                            });
                            if (stack.peek() == INVALID) return "ERROR";
                        }
                }
            }
        }
        if (stack.size() != 1) return "ERROR";
        return String.valueOf(stack.pop());
    }

    private long validate(long x) {
        if (Math.abs(x) > MAX) return INVALID;
        return x;
    }

}
