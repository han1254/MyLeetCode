package stack.reverse_polish_notation;

import java.util.Stack;

/**
 * 逆波兰表示法（Reverse Polish notation，RPN，或逆波兰记法），
 * 是一种是由波兰数学家扬·武卡谢维奇1920年引入的数学表达式方式，
 * 在逆波兰记法中，所有操作符置于操作数的后面，因此也被称为后缀
 * 表示法。 逆波兰记法不需要括号来标识操作符的优先级。
 *
 *
 * 计算逆波兰式（后缀表达式）的值
 * 运算符仅包含"+","-","*"和"/"，被操作数可能是整数或其他表达式
 * 例如：
 *   ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9↵  ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
 *
 */
public class RPN {

    public static void main(String[] args) {
        String[] polishNotation = new String[]{"4", "13", "5", "/", "+"};
        System.out.println(evalRPN(polishNotation));
    }

    /**
     * 执行结果：
     * 通过
     * 显示详情
     * 执行用时 :
     * 7 ms, 在所有 Java 提交中击败了82.48%的用户
     * 内存消耗 :
     * 39.1 MB, 在所有 Java 提交中击败了5.47%的用户
     * @param tokens
     * @return
     */
    private static int evalRPN(String[] tokens) {
        if (tokens.length == 1) {
            return Integer.parseInt(tokens[0]);
        }
        Stack<Integer> integerStack = new Stack<>();
        String op;
        int var1;
        int var2;
        int value = -1;
        for (String token : tokens) {
            if (!isOp(token)) {
                integerStack.push(Integer.parseInt(token));
            } else {
                if (!integerStack.isEmpty()) {
                    var1 = integerStack.pop();
                    var2 = integerStack.pop();
                    integerStack.push(value = calculate(var2, var1, token));
                }
            }
        }
        return value;
    }

    private static int calculate(int a, int b, String op) {
        switch (op) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new IllegalArgumentException("除数不能为0");
                }
                return a / b;
            default:
                return -1;
        }
    }

    private static boolean isOp(String op) {
        return op.equals("+") || op.equals("-") || op.equals("*") || op.equals("/");
    }

}
