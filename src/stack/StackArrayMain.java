package stack;

public class StackArrayMain {
	public static void main(String[] args) {
		StackArray stackArray = new StackArray(3);
		stackArray.push(4);
		stackArray.push(8);
		stackArray.push(6);
		stackArray.push(5);
		stackArray.printStack();
		stackArray.pop();
		System.out.println(stackArray.peek());
		stackArray.printStack();
	}
}
