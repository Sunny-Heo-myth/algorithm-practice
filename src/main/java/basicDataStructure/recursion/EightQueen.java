package basicDataStructure.recursion;

public class EightQueen {
    static int count = 0;
    static int[] pos = new int[8];
    static boolean[] flag = new boolean[8];

    static boolean[] rowFlag = new boolean[8];
    static boolean[] leftDiagonalFlag = new boolean[15];
    static boolean[] rightDiagonalFlag = new boolean[15];

    static void eightQueen(int row, boolean[] isQueen, int count) {
        for (int i = 0; i < row; i++) {
            if (!isQueen[i]) {
                isQueen[i] = true;
                count++;
                eightQueen(row, isQueen, count);
                isQueen[i] = false;
            }

        }
        if (count == row) {
            EightQueen.count++;
        }
    }

    static void print() {
        for (int i = 0; i < 8; i++) {
            System.out.printf("%2d", pos[i]);
        }
        System.out.println();
    }

    static void set(int i) {
        for (int j = 0; j < 8; j++) {
            pos[i] = j;
            if (i == 7) {
                print();
            }
            else {
                set(i + 1);
            }
        }
    }

    static void set2(int i) {
        for (int j = 0; j < 8; j++) {
            if (!flag[j]) {
                pos[i] = j;
                if (i != 7) {
                    flag[j] = true;
                    set2(i + 1);
                    flag[j] = false;
                }
                else {
                    print();
                }
            }
        }
    }

    static void set3(int i) {
        for (int j = 0; j < 8; j++) {
            if (!rowFlag[j] && !leftDiagonalFlag[i + j] && !rightDiagonalFlag[i - j + 7]) {
                pos[i] = j;
                if (i == 7) {
                    print();
                }
                else {
                    rowFlag[j] = true;
                    leftDiagonalFlag[i + j] = true;
                    rightDiagonalFlag[i - j + 7] = true;

                    set3(i + 1);

                    rowFlag[j] = false;
                    leftDiagonalFlag[i + j] = false;
                    rightDiagonalFlag[i - j + 7] = false;
                }
            }

        }
    }

    static void set4(int row) {
        for (int column = 0; column < 8; column++) {
            if (!rowFlag[column] && !leftDiagonalFlag[row + column] && !rightDiagonalFlag[row - column + 7]) {
                pos[row] = column;
                if (row == 7) {
                    print();
                }
                else {
                    rowFlag[column] = leftDiagonalFlag[row + column] = rightDiagonalFlag[row - column + 7] = true;
                    set4(row + 1);
                    rowFlag[column] = leftDiagonalFlag[row + column] = rightDiagonalFlag[row - column + 7] = false;
                }
            }

        }
    }



















}
