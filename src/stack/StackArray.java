package stack;

import java.util.Arrays;

public class StackArray {
	private int top;
	private int stack[];

	public StackArray(int capacity) {
		stack = new int[capacity];
	}

	public void push(int data) {
		if (top == stack.length) {
			int arr[] = new int[stack.length * 2];
			System.arraycopy(stack, 0, arr, 0, stack.length);
			stack = arr;
		}
		stack[top++] = data;
	}

	public int pop() {
		if (isEmpty())
			return -1;
		int topEle = stack[--top];
		stack[top] = 0;
		return topEle;
	}

	public int peek() {
		if (isEmpty())
			return -1;
		return stack[top - 1];
	}

	public int size() {
		return top;
	}

	public boolean isEmpty() {
		return top == 0;
	}

	public void printStack() {
		System.out.println(Arrays.toString(stack));
	}
}
