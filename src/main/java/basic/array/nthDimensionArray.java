package basic.array;

public class nthDimensionArray {
    public static void main(String[] args) {
        //System.out.println(dayCount(2021, 4, 15));
        System.out.println(dayOfYear(2000, 12, 31));
    }

    static void nestedArray() {
        int[][] x = new int[2][4];

        x[0][1] = 37;
        x[0][3] = 54;
        x[1][2] = 65;

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("x[" + i + "][" + j + "] = " + x[i][j]);
            }
        }
    }

    static int dayCount(int year, int month, int day) {
        if (year % 400 == 0) {
            return countDay(true, month, day);
        }
        if (year % 100 == 0) {
            return countDay(false, month, day);
        }
        if (year % 4 == 0) {
            return countDay(true, month, day);
        }
        return countDay(false, month, day);
    }

    static int countDay(boolean isLunar, int month, int day) {
        int count = 0;
        int[][] lunar = {
                {31,28,31,30,31,30,31,31,30,31,30,31},
                {31,29,31,30,31,30,31,31,30,31,30,31}
        };
        if (isLunar) {
            for (int i = 0; i < month - 1; i++) {
                count += lunar[1][i];
            }
        }
        else {
            for (int i = 0; i < month - 1; i++) {
                count += lunar[0][i];
            }
        }
        return count + day;
    }

    static int isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0 ? 1 : 0;
    }

    static int dayOfYear(int year, int month, int day) {
        int dayCount = 0;
        int[][] lunar = {
                {31,28,31,30,31,30,31,31,30,31,30,31},
                {31,29,31,30,31,30,31,31,30,31,30,31}
        };

        for (int m = 0; m < month - 1; m++) {
            dayCount += lunar[isLeap(year)][m];
        }
        return dayCount + day;
    }

}
