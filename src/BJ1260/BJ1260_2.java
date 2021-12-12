//import java.io.BufferedReader;
//import java.io.IOException;
//import java.io.InputStreamReader;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.Stack;
//
//public class BJ1260_2 {
//
//    public static void main(String[] args) throws IOException {
//
//        int numberOfPoints;
//        int numberOfLines;
//        int startingPoint;
//
//        BufferedReader bfReader = new BufferedReader(new InputStreamReader(System.in));
//        String[] input1 = bfReader.readLine().split(" ");
//
//        numberOfPoints = Integer.parseInt(input1[0]);
//        numberOfLines = Integer.parseInt(input1[1]);
//        startingPoint = Integer.parseInt(input1[2]) - 1;
//
//        Line[] lines = new Line[numberOfLines];
//
//        for(int i = 0; i < numberOfLines; i++) {
//            String[] input2 = bfReader.readLine().split(" ");
//            int first = Integer.parseInt(input2[0]);
//            int second = Integer.parseInt(input2[1]);
//
//            if (first <= second) {
//                lines[i] = new Line(first, second);
//            } else {
//                lines[i] = new Line(second, first);
//            }
//        }
//
//        bfReader.close();
//
//        System.out.println(dfs(startingPoint, lines));
//        System.out.println(bfs(startingPoint, lines));
//    }
//
//    static ArrayList<Integer> dfs(int startingPoint, Line[] lines){
//        ArrayList<Integer> result = new ArrayList<>();
//        Stack<Line> stack = new Stack<>();
//
//        stack.push(lines[startingPoint]);
//
//        while(!stack.isEmpty()){
//            Line x = stack.pop();
//            result.add(x.from);
//            ArrayList<Line> list = new ArrayList<>();
//
//            for(Line line : lines){
//                if(x.to == line.from){
//                    list.add(line);
//                }
//            }
//            Collections.sort(list, (line1, line2) -> line2.to - line1.to);
//
//            for(Line i : list){
//                if(!stack.contains(i)){
//                    stack.add(i);
//                }
//            }
//
//        }
//        return result;
//    }
//
//    static int[] bfs(int startingPoint, Line[] lines){
//
//        return null;
//    }
//}
//
//
