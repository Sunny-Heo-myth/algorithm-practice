package org.alan.algorithm.concept.chaptertwo;

public class Exercise1_4 {

    boolean[] a;
    boolean[] b;
    boolean[] c;

    public Exercise1_4(boolean[] a, boolean[] b) {
        if (a.length != b.length) {
            throw new IllegalArgumentException();
        }

        this.a = a;
        this.b = b;
        this.c = new boolean[a.length + 1];
        calculateC();
    }

    private void calculateC() {
        boolean temp = false;

        for (int i = a.length - 1; i >= 0; i--) {

            if (a[i] && b[i]) { // Both are true.
                c[i + 1] = temp;
                temp = true;

            } else if (a[i] || b[i]) {  // Either one of them is true.

                if (temp) {
                    c[i + 1] = false;
                    temp = false;
                } else {
                    c[i + 1] = true;
                }

            } else {    // Both are false.
                c[i + 1] = temp;
                temp = false;
            }
        }

        c[0] = temp;
    }
}
