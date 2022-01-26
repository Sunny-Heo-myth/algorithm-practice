package programmers.lv2.reduceString;

public class ReduceString60057_5 {
    public static void main(String[] args) {
        System.out.println(solution("aabb"));
    }

    static int solution(String s){
        int length = s.length();
        int y = length;
        for(int i = 0; i < length; i++){
            int size = i + 1;
            int sp = 0;
            int ep = sp + size;
            int np = ep + size;
            int count = 1; //Separate declaration(+explanation) and initialization.
            String w = "";
            while (true){
                if (ep <= length) {
                    String cs = s.substring(sp, ep);
                    if (np <= length) {
                        String ns = s.substring(ep, np);
                        if (cs.equals(ns)) {
                            count++;
                        } else {
                            if (count == 1) {
                                w += cs;
                            } else {
                                w += (count + cs);
                            }
                            count = 1;
                        }
                    } else {
                        w += counter(s, count, sp);
                        break;
                    }
                } else {
                    w += counter(s, count, sp);
                    break;
                }
                sp += size;
                ep += size;
                np += size;
            }
            int alpha = w.length();
            if(alpha < y){
                y = alpha;
            }
        }
        return y;
    }

    static String counter(String s, int count, int from) {
        String y = s.substring(from);
        if (count == 1) {
            return y;
        } else {
            return count + y;
        }
    }

}
