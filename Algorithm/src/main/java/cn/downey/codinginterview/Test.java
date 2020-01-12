package cn.downey.codinginterview;

import java.util.Stack;

public class Test {
    Stack<Integer> mainStack = new Stack<>();
    Stack<Integer> minStack = new Stack<>();

    public int i;

    public void push(int node) {
        mainStack.push(node);
        minStack.push(minStack.empty() ? node : node < minStack.peek() ? node : minStack.peek());
    }

    public void pop() {
        minStack.pop();
        mainStack.pop();
    }

    public int top() {
        return mainStack.peek();
    }

    public int min() {
        return minStack.peek();
    }
}
