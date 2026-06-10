package stack.string_parsing_pattern;

public class GoalParserInterpretation {

    /*
      Platform : LeetCode
      Question : Goal Parser Interpretation (1678)
      Pattern  : String Parsing pattern

      Time Complexity  : O(n)
      Space Complexity : O(n)
    */

    public String interpret(String command) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < command.length(); i++) {

            char ch = command.charAt(i);

            if (ch == 'G') {
                sb.append("G");
            }
            else if (ch == '(') {

                if (command.charAt(i + 1) == ')') {
                    sb.append("o");
                    i++; // skip ')'
                }
                else {
                    sb.append("al");
                    i += 3; // skip "(al)"
                }
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {

        GoalParserInterpretation obj =
                new GoalParserInterpretation();

        String command = "G()(al)";

        System.out.println(obj.interpret(command)); // Goal: "Goal"
    }
}