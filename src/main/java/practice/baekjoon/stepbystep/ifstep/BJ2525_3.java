package practice.baekjoon.stepbystep.ifstep;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BJ2525_3 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[] input = bf.readLine().split(" ");
        Time time = new Time(Integer.parseInt(input[0]), Integer.parseInt(input[1]));
        int elapsedTime = Integer.parseInt(bf.readLine());

        BJ2525_3 test = new BJ2525_3();
        Time result = test.elapse(time, elapsedTime);
        System.out.print(result.getHour() + " " + result.getMinute());
    }

    public Time elapse(Time from, int elapsed) {
        int minuteSum = from.getMinute() + elapsed;
        int elapsedHour = minuteSum / 60;
        int minute = minuteSum % 60;

        int hour = from.getHour() + elapsedHour;
        if (hour > 23) {
            hour -= 24;
        }

        return new Time(hour, minute);
    }

    public static class Time {
        private int hour;
        private int minute;

        public Time(int hour, int minute) {
            this.hour = hour;
            this.minute = minute;
        }

        public int getHour() {
            return hour;
        }

        public int getMinute() {
            return minute;
        }
    }
}
