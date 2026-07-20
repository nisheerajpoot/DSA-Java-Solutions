package backtrack;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses {

    /*
      Platform : LeetCode

      Question : Restore IP Addresses

      Pattern  : Backtracking

      Approach :
      Partition Based Backtracking

      Idea :
      - Partition the string into
        exactly 4 parts.
      - Each part can have
        1 to 3 digits.
      - A valid part:
          1. Has no leading zero
             (except "0").
          2. Value is between
             0 and 255.
      - Choose a valid part,
        recursively build the
        remaining parts.
      - Remove the chosen part
        (Backtrack) and try the
        next partition.
      - When exactly 4 valid parts
        are formed and the entire
        string is used, store the
        IP address.

      Time Complexity :
      O(3⁴)

      Space Complexity :
      O(4)

      (Recursive Call Stack)
    */

    public List<String> restoreIpAddresses(String s) {

        List<String> ans = new ArrayList<>();

        backtrack(0,
                  0,
                  s,
                  new ArrayList<>(),
                  ans);

        return ans;
    }

    private void backtrack(int index,
                           int parts,
                           String s,
                           List<String> current,
                           List<String> ans) {

        // Base Case
        if (parts == 4) {

            if (index == s.length()) {
                ans.add(String.join(".", current));
            }

            return;
        }

        // Try Every Possible Part
        for (int len = 1; len <= 3; len++) {

            if (index + len > s.length()) {
                break;
            }

            String part =
                    s.substring(index, index + len);

            // Leading Zero Not Allowed
            if (part.length() > 1 &&
                part.charAt(0) == '0') {
                continue;
            }

            int value = Integer.parseInt(part);

            // Value Must Be <= 255
            if (value > 255) {
                continue;
            }

            // Choose
            current.add(part);

            // Explore
            backtrack(index + len,
                      parts + 1,
                      s,
                      current,
                      ans);

            // Backtrack
            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        RestoreIPAddresses obj =
                new RestoreIPAddresses();

        String s = "25525511135";

        List<String> result =
                obj.restoreIpAddresses(s);

        System.out.println("Valid IP Addresses :");

        for (String ip : result) {
            System.out.println(ip);
        }
    }
}