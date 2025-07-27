import java.util.Stack;

public class EvaluateExpression {
    public static int evaluate(String s) {
        Stack<Integer> stack = new Stack<>();

        int num = 0;
        int sign = 1;
        int result = 0;
        //1 + (2 - (3 + 4))
        // i = 1
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '+' || c == '-') {
                result = result + sign * num;
                num = 0;
                sign = c == '+' ? 1 : -1;
            } else if (c == '(') {
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign = 1;
            } else if (c == ')') {
                result = result + sign * num;
                num = 0;
                result = result * stack.pop();
                result = result + stack.pop();
            }

        }
        result = result + sign * num;
        return result;


    }

    public static void main(String[] args) {
        assert evaluate("1 + (2 - (3 + 4))") == -4;
    }
}
