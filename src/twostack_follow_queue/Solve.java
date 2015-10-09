package twostack_follow_queue;

import java.util.Stack;

/**
 * 由两个栈组成的队列
 */
public class Solve {
	Stack<Integer> push = new Stack<Integer>();
	Stack<Integer> pop = new Stack<Integer>();
	
	public static void main(String[] args) {
		Solve s = new Solve();
		s.add(4);
		s.add(3);
		s.add(5);
		s.add(2);
		s.add(3);
		s.add(1);
		s.add(6);
		System.out.println(s.peek());
		System.out.println(s.poll());
		System.out.println(s.peek());
		System.out.println(s.poll());
		System.out.println(s.peek());
		System.out.println(s.poll());
		System.out.println(s.peek());
		System.out.println(s.poll());
		System.out.println(s.peek());
		System.out.println(s.poll());
		System.out.println(s.peek());
		System.out.println(s.poll());
		System.out.println(s.peek());
		System.out.println(s.poll());
	}
	
	public void add(Integer val){
		push.add(val);
	}
	public int poll(){
		if(pop.isEmpty()){
			if(push.isEmpty()){
				throw new RuntimeException("stack is empty");
			}
			while(!push.isEmpty()){
				pop.push(push.pop());
			}
		}
		return pop.pop();
	}
	public int peek(){
		if(pop.isEmpty()){
			if(push.isEmpty()){
				throw new RuntimeException("stack is empty");
			}
			while(!push.isEmpty()){
				pop.push(push.pop());
			}
		}
		return pop.peek();
	}
	
	
}
