import java.util.Map;
import java.util.Stack;

public class ValidParanthesis {
    public boolean validParanthesis(String s) {
        int prevLength = -1;
        while (s.length() != prevLength) {
            prevLength = s.length();
            s = s.replace("()", "").replace("[]", "").replace("{}", "");
        }
        return s.isEmpty();

    }

    public boolean validParenthesisOptimized(String s) {
        Map<Character, Character> map = Map.of('}', '{', ')', '(', ']', '[');
        Stack<Character> stack = new Stack<>();
        int left = 0;
        while (left < s.length()) {
            char c = s.charAt(left);
            if (c == '{' || c == '[' || c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            }
            left++;
        }
        return stack.isEmpty();
    }

}
