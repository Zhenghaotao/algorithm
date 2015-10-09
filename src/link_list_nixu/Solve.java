package link_list_nixu;

import java.util.Stack;
/**
 * 将链表的每k个节点之间逆序
 */
public class Solve {
	
	public static void main(String[] args) {
		Solve s = new Solve();
		Node head = new Node(1);
		Node n2 = new Node(2);
		head.next = n2;
		Node n3 = new Node(3);
		n2.next = n3;
		Node n4 = new Node(4);
		n3.next = n4;
		Node n5 = new Node(5);
		n4.next = n5;
		Node n6 = new Node(6);
		n5.next = n6;
		Node n7 = new Node(7);
		n6.next = n7;
		Node n8 = new Node(8);
		n7.next = n8;
		
		Node newhead = s.reverseLinkByK(head, 3);
		while(newhead != null){
			System.out.println(newhead.value);
			newhead = newhead.next;
		}
	}
	
	public Node reverseLinkByK(Node head,int k){
		
		Node newHead = head;
		Node cur = head;
		Node pre = null;
		Stack<Node> stack = new Stack<Node>();
		
		while(cur.next != null){
			Node next = cur.next;
			stack.push(cur);
			while(stack.size() == k){
				pre = reverse(stack, pre, next);
				newHead = newHead == head ? cur : newHead;
			}
			cur = next;
		}
		return newHead;
	}
	
	public Node reverse(Stack<Node> stack,Node left,Node right){
		if(left == null){
			left = stack.pop();
		}
		Node cur = left;
		while(!stack.empty()){
			cur.next = stack.pop();
			cur = cur.next;
		}
		cur.next = right;
		return cur;
	}
}
class Node{
	public int value;
	public Node next;
	public Node(int val) {
		this.value = val;
	}
}