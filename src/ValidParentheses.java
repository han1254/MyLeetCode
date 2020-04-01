import java.util.Stack;

public class ValidParentheses {


    public static void main(String[] args) {
        String t = "{}{}[]{{{}}}";
        System.out.println(isValid(t));
    }

    private static boolean isValid(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && !isLeft(str.charAt(i)))
                return false;
            char temp = str.charAt(i);
            if (isLeft(temp)) {
                stack.push(temp);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (!isPair(stack.pop(), temp)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    private static boolean isLeft(char temp) {
        switch (temp) {
            case '[':
            case '{':
            case '(':
                return true;
            default:
                return false;
        }
    }

    private static boolean isPair(char left, char right) {
        return (left == '[' && right == ']') ||  (left == '{' && right == '}') ||  (left == '(' && right == ')');
    }

}
