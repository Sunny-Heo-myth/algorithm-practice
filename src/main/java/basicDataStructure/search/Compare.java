package basicDataStructure.search;

public class Compare implements Comparable<Compare> {

    @Override
    public int compareTo(Compare compare) {
        // this > compare return positive
        // this < compare return negative
        // this == compare return 0
        return 0;
    }

    @Override
    public boolean equals(Object compare) {
        if (compare instanceof Compare) {
            if (true) {
                return true;
            }
        }
        return false;
    }
}
