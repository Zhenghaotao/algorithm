package reverseStackByRecursion;

import java.util.Stack;
/**
 * 仅用递归函数和栈操作逆序一个栈
 */
public class Solve {
	public static void main(String[] args) {
		Solve solve = new Solve();
		Stack<Integer> s = new Stack<Integer>();
		s.add(1);
		s.add(2);
		s.add(3);
		s.add(4);
		s.add(5);
		System.out.println(s.toString());
		solve.reverseStackByRecursion(s);
		System.out.println(s.toString());
	}
	
	public void reverseStackByRecursion(Stack<Integer> stack){
		if(stack.isEmpty()){
			return;
		}
		int val = reverseStack(stack);
		reverseStackByRecursion(stack);
		stack.push(val);
	}
	public int reverseStack(Stack<Integer> stack){
		int result = stack.pop();
		if(stack.isEmpty()){
			return result;
		} else{
			int last = reverseStack(stack);
			stack.push(result);
			return last;
		}
	}
}
