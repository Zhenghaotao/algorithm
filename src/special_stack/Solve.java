package special_stack;

import java.util.Stack;

/**
 * 实现一个特殊的stack，其操作push,pop,getMin的复杂度均为为O(1),可用现成的stack操作
 */
public class Solve {
	private Stack<Integer> stack = new Stack<Integer>();
	private Stack<Integer> minStack = new Stack<Integer>();

	public void push(int val) {
		if(minStack.isEmpty()){
			minStack.push(val);
		} else {
			if(val <= minStack.peek()){
				minStack.push(val);
			}
		}
		
		stack.push(val);
	}

	public int pop() {
		if(stack.empty()){
			throw new IllegalStateException("stack is empty");
		}
		int val = stack.pop();
		if(val == minStack.peek()){
			minStack.pop();
		}
		return val;
	}

	public int getMin() {
		if(stack.empty()){
			throw new IllegalStateException("stack is empty");
		}
		return minStack.peek();
	}

}
