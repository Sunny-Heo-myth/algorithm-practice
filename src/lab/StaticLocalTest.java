package lab;

public class StaticLocalTest {

    static int staticNum = 0;

    public static void main(String[] args) {
        int localNum = 0;
        add1(localNum);
        add2(localNum);

        String[] ss = "s\ns\n".split("\n");
        for (String s : ss) {
            System.out.println(s);
        }

    }

    static void add1(int localNum){
        localNum++;
        staticNum++;
        System.out.println(staticNum);
        System.out.println(localNum);
    }

    static void add2(int localNum){
        localNum++;
        staticNum++;
        System.out.println(staticNum);
        System.out.println(localNum);
    }
}
