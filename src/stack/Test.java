package stack;

public class Test {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(-1000);
        minStack.push(4);
        minStack.push(-5);
        System.out.println(minStack.getMin());
        minStack.pop();
        minStack.pop();
        minStack.pop();
        System.out.println(minStack.getMin());
    }
}
