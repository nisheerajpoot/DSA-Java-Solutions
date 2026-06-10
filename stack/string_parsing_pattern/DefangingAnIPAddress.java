package stack.string_parsing_pattern;

public class DefangingAnIPAddress {

    /*
      Platform : LeetCode
      Question : Defanging an IP Address (1108)
      Pattern  : String Parsing

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public String defangIPaddr(String address) {

        StringBuilder sb = new StringBuilder();

        for (char ch : address.toCharArray()) {

            if (ch == '.') {
                sb.append("[.]");
            } else {
                sb.append(ch);
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        DefangingAnIPAddress obj = new DefangingAnIPAddress();

        String address = "1.1.1.1";

        System.out.println(obj.defangIPaddr(address)); 
        // Output: 1[.]1[.]1[.]1
    }
}