package programmers.lv3.chooseokTraffic;

public class Traffic {

    public static void main(String[] args) {
        String[] lines = {"2016-09-15 01:00:04.002 2.0s",
                "2016-09-15 01:00:07.000 2s"};

        System.out.println(solution(lines));
    }

    public static int solution(String[] lines) {

        for (String line : lines) {
            String[] fragments = line.split(" ");
            String time = fragments[1];
            float operatingTime = Float.parseFloat(fragments[2].split("s")[0]);

        }

        return 0;
    }

}
