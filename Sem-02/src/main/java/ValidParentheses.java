import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(' || ch == '[' || ch == '{') {
                stack.add(ch);
                continue;
            }
            if (stack.empty()) {
                return false;
            }
            Character last = stack.pop();
            if (!((last == '(' && ch == ')') || (last == '[' && ch == ']') || (last == '{' && ch == '}'))) {
                return false;
            }
        }
        return stack.empty();
    }
}
