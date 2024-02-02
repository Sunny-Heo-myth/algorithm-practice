package org.alan.algorithm.practice.baekjoon.clazz.five;

import java.util.Arrays;
import java.util.regex.Pattern;

public class BJ2162 {

    public String solve(String input) {
        int[][] lineArray = input.lines().skip(1).map(s ->
                Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray()).toArray(int[][]::new);


        return null;
    }

    private boolean isIntersect(int[] line1, int[] line2) {
        int[] line1Dot1 = {line1[0], line1[1]};
        int[] line1Dot2 = {line1[2], line1[3]};
        int[] line2Dot1 = {line2[0], line2[1]};
        int[] line2Dot2 = {line2[2], line2[3]};

//        int ab = counterclockwise(line1Dot1, line1Dot2, line2Dot1) * counterclockwise(line1Dot1, line1Dot2, line2Dot2);
//        int cd = counterclockwise(line2Dot1, line2Dot2, line1Dot1) * counterclockwise(line2Dot1, line2Dot2, line1Dot2);
//
//        if (ab == 0 && cd == 0) {
//        }
        return true;
    }

    private int[] parents;

    public String solve2(String input) {
        Line[] lineArray = input.lines().skip(1)
                .map(s -> Pattern.compile(" ").splitAsStream(s).mapToInt(Integer::parseInt).toArray())
                .map(Line::of).toArray(Line[]::new);

        parents = new int[lineArray.length];
        Arrays.fill(parents, -1);

        for (int i = 0; i < lineArray.length; i++) for (int j = i + 1; j < lineArray.length; j++)
            if (lineArray[i].isIntersection(lineArray[j])) union(i, j);

        int cnt = 0;
        int min = 0;
        for (int i = 0; i < lineArray.length; i++) if (parents[i] < 0) {
            cnt++;
            min = Integer.min(min, parents[i]);
        }
        return cnt + "\n" + -min;
    }

    public int find(int a) {
        if (parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    public void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return;

        int h = parents[a] < parents[b] ? a : b;
        int l = parents[a] < parents[b] ? b : a;
        parents[h] += parents[l];
        parents[l] = h;
    }

}

class Point implements Comparable<Point> {
    final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        return this.x == o.x ? this.y - o.y : this.x - o.x;
    }
}

class Line {
    final Point a, b;

    public Line(Point p1, Point p2) {
        a = p1.compareTo(p2) <= 0 ? p1 : p2;
        b = p1.compareTo(p2) <= 0 ? p2 : p1;
    }

    public static Line of(int[] ints) {
        int x1 = ints[0]; int y1 = ints[1]; int x2 = ints[2]; int y2 = ints[3];
        return new Line(new Point(x1, y1), new Point(x2, y2));
    }

    public boolean isIntersection(Line other) {
        int res1 = counterclockwise(this.a, this.b, other.a) * counterclockwise(this.a, this.b, other.b);
        int res2 = counterclockwise(other.a, other.b, this.a) * counterclockwise(other.a, other.b, this.b);
        return res1 == 0 && res2 == 0 ? this.a.compareTo(other.b) <= 0 && other.a.compareTo(this.b) <= 0 : res1 <= 0 && res2 <= 0;
    }

    private int counterclockwise(Point dot1, Point dot2, Point dot3) {
        int op = (dot1.x * dot2.y + dot2.x * dot3.y + dot3.x * dot1.y)
                - (dot1.y * dot2.x + dot2.y * dot3.x + dot3.y * dot1.x);
        return Integer.compare(op, 0);
    }

}

