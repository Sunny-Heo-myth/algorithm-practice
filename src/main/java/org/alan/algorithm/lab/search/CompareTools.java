package org.alan.algorithm.lab.search;

import java.util.Arrays;
import java.util.Comparator;

public class CompareTools {

    static class PhysicsData {
        private String name;
        private int height;
        private double vision;

        public PhysicsData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        @Override
        public String toString() {
            return "PhysicsData{" +
                    "name='" + name + '\'' +
                    ", height=" + height +
                    ", vision=" + vision +
                    '}';
        }

        public static final Comparator<PhysicsData> HEIGHT_ORDER = new HeightOrderComparator();
        public static final Comparator<PhysicsData> SIGHT_ORDER = new SightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysicsData> {

            @Override
            public int compare(PhysicsData o1, PhysicsData o2) {
                return Integer.compare(o1.height, o2.height);
            }
        }

        private static class SightOrderComparator implements Comparator<PhysicsData> {
            @Override
            public int compare(PhysicsData o1, PhysicsData o2) {
                return Double.compare(o1.vision, o2.vision);
            }
        }

    }

    public static void main(String[] args) {
        PhysicsData[] physicsData = {
                new PhysicsData("a", 171, 0.3),
                new PhysicsData("ab", 172, 0.5),
                new PhysicsData("ac", 173, 0.6),
                new PhysicsData("da", 174, 0.7),
                new PhysicsData("aa", 175, 0.8),
                new PhysicsData("ea", 176, 1.0),
                new PhysicsData("av", 177, 1.3),
                new PhysicsData("ba", 178, 1.4)
        };

        PhysicsData me = new PhysicsData("me", 174, 1.0);
        int heightIdx = Arrays.binarySearch(physicsData, me, PhysicsData.HEIGHT_ORDER);
        System.out.println(physicsData[heightIdx]);

        int sightIdx = Arrays.binarySearch(physicsData, me, PhysicsData.SIGHT_ORDER);
        System.out.println(physicsData[sightIdx]);
    }

}
