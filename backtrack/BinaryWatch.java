package backtrack;

import java.util.ArrayList;
import java.util.List;

public class BinaryWatch {

    /*
      Platform : LeetCode

      Question : Binary Watch

      Pattern  : Backtracking

      Approach :
      Include / Exclude Backtracking

      Idea :
      - A binary watch has
        10 LEDs:
          • First 4 LEDs represent
            hours.
          • Last 6 LEDs represent
            minutes.
      - At every LED, there are
        two choices:
          1. Turn it ON.
          2. Leave it OFF.
      - If turning ON an LED,
        update either the hour
        or minute value.
      - Ignore combinations where:
          • Hours > 11
          • Minutes > 59
      - When the required number
        of LEDs are turned ON,
        store the formatted time.

      Time Complexity :
      O(2¹⁰)

      Space Complexity :
      O(10)

      (Recursive Call Stack)
    */

    List<String> ans = new ArrayList<>();

    int[] hour = {8, 4, 2, 1};

    int[] minute = {32, 16, 8, 4, 2, 1};

    public List<String> readBinaryWatch(int turnedOn) {

        backtrack(0,
                  0,
                  0,
                  turnedOn);

        return ans;
    }

    private void backtrack(int index,
                           int hours,
                           int minutes,
                           int ledsLeft) {

        // Invalid Time
        if (hours > 11 ||
            minutes > 59) {

            return;
        }

        // Required LEDs Selected
        if (ledsLeft == 0) {

            ans.add(hours + ":" +
                    (minutes < 10 ? "0" : "")
                    + minutes);

            return;
        }

        // All LEDs Processed
        if (index == 10) {
            return;
        }

        // Turn ON Current LED
        if (index < 4) {

            backtrack(index + 1,
                      hours + hour[index],
                      minutes,
                      ledsLeft - 1);

        } else {

            backtrack(index + 1,
                      hours,
                      minutes + minute[index - 4],
                      ledsLeft - 1);
        }

        // Leave Current LED OFF
        backtrack(index + 1,
                  hours,
                  minutes,
                  ledsLeft);
    }

    public static void main(String[] args) {

        BinaryWatch obj =
                new BinaryWatch();

        List<String> result =
                obj.readBinaryWatch(1);

        System.out.println("Possible Times :");

        for (String time : result) {
            System.out.println(time);
        }
    }
}