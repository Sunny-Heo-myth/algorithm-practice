//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Stack;
//
//public class Main {
//
//    static int n;
//    static int size;
//    static int step;
//    static ArrayList<Petal> petals = new ArrayList<>();
//    static Stack<Petal> stack = new Stack<>();
//
//    public static void main(String[] args) throws IOException {
//
//        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
//        String[] input1 = bfReader.readLine().split(" ");
//
//        n = Integer.parseInt(input1[0]);
//        size = Integer.parseInt(input1[1]);
//
//        for (int i = 0; i < n; i++) {
//            String[] input2 = bfReader.readLine().split(" ");
//            Petal petal = new Petal(new int[]{Integer.parseInt(input2[0]), Integer.parseInt(input2[1])});
//            petals.add(petal);
//        }
//
//        String input3 = bfReader.readLine();
//        step = Integer.parseInt(input3);
//
//        System.out.println(dfs());
//    }
//
//    private static int dfs() {
//
//        ArrayList<Petal> result = new ArrayList<>();
//        Petal startingPoint = petals.get(0);
//        stack.push(startingPoint);
//
//        while (!stack.isEmpty()) {
//            Petal targetPetal = stack.pop();
//            for (Petal p : petals) {
//                if (size + step >= targetPetal.getCoordi()[0] - p.getCoordi()[0]
//                        && size + step >= p.getCoordi()[0] - targetPetal.getCoordi()[0]
//                        && size + step >= targetPetal.getCoordi()[1] - p.getCoordi()[1]
//                        && size + step >= p.getCoordi()[1] - targetPetal.getCoordi()[1]
//                ) {
//                //    if (p.isVisited() == false) {
//                //        p.setVisited(true);
//                        stack.add(p);
//                    } else {
//                        result.add(p);
//                    }
//                }
//            }
//        }
//
//        int distance = Integer.MIN_VALUE;
////        for(Petal p : result) {
////
////            int[][] fourPoints = new int[4][2];
////            fourPoints[0] = new int[]{p.getCoordi()[0] + size, p.getCoordi()[1] + size};
////            fourPoints[1] = new int[]{p.getCoordi()[0], p.getCoordi()[1] + size};
////            fourPoints[2] = new int[]{p.getCoordi()[0], p.getCoordi()[1]};
////            fourPoints[3] = new int[]{p.getCoordi()[0] + size, p.getCoordi()[1]};
////
////            for (int[] i : fourPoints) {
////                if (i[0] >= 0 && i[1] >= 0 && i[0] + i[1] > distance) {
////                    distance = i[0] + i[1];
////                } else if (i[0] < 0 && i[1] >= 0 && -i[0] + i[1] > distance) {
////                    distance = -i[0] + i[1];
////                } else if (i[0] < 0 && i[1] < 0 && -i[0] - i[1] > distance) {
////                    distance = -i[0] - i[1];
////                } else if (i[0] >= 0 && i[1] < 0 && i[0] - i[1] > distance) {
////                    distance = i[0] - i[1];
////                } else {
////                    continue;
////                }
////            }
////        }
////        return distance;
//    }
//
//}
