package stack;

import tree.binary_tree.maximum_depth_of_binary_tree.MaxDepBT;

import java.util.Map;

class MinStack {

    private Node node;
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (node == null) {
            node = new Node(x, x);
        } else {
            node = new Node(node, Math.min(node.min, x), x);
        }

    }

    public void pop() {
        node = node.next;
    }

    public int top() {
        return node.value;
    }

    public int getMin() {
        return node.min;
    }

    static class Node {
        Node next;
        int min;
        int value;
        public Node(Node next, int min, int value) {
            this.next = next;
            this.min = min;
            this.value = value;
        }
        public Node(int min, int value) {
            this(null, min, value);
        }
    }
}
