package baekjoon.steps.javaDfsAndbfs.BJ2206;

import java.util.ArrayList;

public class Input {
    private int[][] box;
    private ArrayList<int[]> endList;
    private int step;

    public Input(int[][] box, ArrayList<int[]> endList, int step){
        this.box = box;
        this.endList = endList;
        this.step = step;
    }

    public int[][] getBox() {
        return box;
    }

    public void setBox(int[][] box) {
        this.box = box;
    }

    public ArrayList<int[]> getEndList() {
        return endList;
    }

    public void setEndList(ArrayList<int[]> endList) {
        this.endList = endList;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    @Override
    public boolean equals(Object object) {
        if(object instanceof Input){
            Input obj = (Input) object;
            if(this.box == obj.box
                    & this.endList == obj.endList
                    & this.step == obj.step){
                return true;
            }else{
                return false;
            }
        }else {
            return false;
        }

    }
}
