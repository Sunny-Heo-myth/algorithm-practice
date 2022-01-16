package baekjoon.java.dfsAndbfs.BJ2206;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class BJ2206 {

    public static void main(String[] args) throws IOException {

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        int xAxis = Integer.parseInt(input[0]);
        int yAxis = Integer.parseInt(input[1]);
        int[][] box = new int[xAxis][yAxis];

        for (int i = 0; i < xAxis; i++) {
            String[] hehe = bf.readLine().split("");

            for (int j = 0; j < yAxis; j++) {
                box[i][j] = Integer.parseInt(hehe[j]);
            }
        }

        ArrayList<Integer> stepList = new ArrayList<>();
        Stack<Input> stack = new Stack<>();

        ArrayList<int[]> dummy = new ArrayList<>();
        dummy.add(new int[]{0,0});
        stack.push(new Input(box, dummy, 0));

        while(!stack.isEmpty()){
            Input going = stack.pop();
            ArrayList<int[]> goingEndList = going.getEndList();

            if(going.getStep() >= xAxis + yAxis -2 && !goingEndList.isEmpty()){
                for(int i = 0; i < goingEndList.size(); i++){
                    if(goingEndList.get(i)[0] == xAxis -1
                            && goingEndList.get(i)[1] == yAxis -1){
                        stepList.add(going.getStep() +1);
                    }
                }
            }

            Input toGo = move(going);
            if(toGo != null){
                stack.push(toGo);
            }
        }

        int result = Integer.MAX_VALUE;
        for(int i = 0; i < stepList.size(); i++){
            if(stepList.get(i) < result){
                result = stepList.get(i);
            }
        }
        if(stepList.isEmpty()){
            System.out.println(-1);
        }else {
            System.out.println(result);
        }
    }

    // time complexity : c(3*3) // spatial complexity : axis^2
    public static Input move(Input input){
        int step = 0;
        int[][] box = input.getBox();
        ArrayList<int[]> endList = input.getEndList();
        int xAxis = box.length; int yAxis = box[0].length;
        ArrayList<int[]> resultList = new ArrayList<>();
        int[] dx = {1, 0 ,-1, 0};
        int[] dy = {0, 1 ,0, -1};
        
        for(int i = 0; i < endList.size(); i++){
            int x = endList.get(i)[0]; int y = endList.get(i)[1];
            
            for(int j = 0; j < 4; j++) {
                int xChanged = x + dx[j];
                int yChanged = y + dy[j];
                int targetPoint = box[xChanged][yChanged];
                
                if (xChanged >= 0 && xChanged < xAxis
                        && yChanged >= 0 && yChanged < yAxis
                        && targetPoint == 0) {
                    targetPoint = box[x][y] + 1;
                    step = targetPoint;
                    resultList.add(new int[]{xChanged, yChanged});
                }
            }
        }
        if(step == 0){
            return null;
        }else {
            return new Input(box, resultList, step);
        }
    }

    static int[][] breakpoint(int[][] box, int x, int y){
        box[x][y] = 0;
        return box;
    }
}
