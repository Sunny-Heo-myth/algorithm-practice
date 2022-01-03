package bootCamp.bitMask;

public class Topping {

    public static void main(String[] args) {

        int topping = 1023;
        System.out.println(topping << 2);

        int topping2 = 1020;
        int p2 = 3;
        System.out.println(topping2 |= p2);

        int topping3 = 512;
        int p3 = 9;
        System.out.println(topping3 &= (1<<p3));

        int topping4 = 513;
        int p4 = 9;
        System.out.println(topping4 &= ~(1<<p4));

        int topping5 = 528;
        int p5 = 4;
        System.out.println(topping5 ^= 1<<p5);

        System.out.println(151/4);
        System.out.println(151%4);

        System.out.println(bitCount(657));
    }

    static int bitCount(int x){
        if (x == 0) { return 0; }
        return x%2 + bitCount(x/2);
    }
}
