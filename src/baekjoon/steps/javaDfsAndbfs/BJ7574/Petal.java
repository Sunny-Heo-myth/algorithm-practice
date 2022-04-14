package baekjoon.steps.javaDfsAndbfs.BJ7574;

public class Petal {

    private int[] coordi;
    private boolean visited;

    public Petal(int[] coordi) {
        this.coordi = coordi;
        this.visited = false;
    }

    public int[] getCoordi() {
        return coordi;
    }

    public boolean isVisited() {return visited; }

    public void setVisited(boolean visited) {
        this.visited = visited;
    }

    public void setCoordi(int[] coordi) {
        this.coordi = coordi;
    }



}
