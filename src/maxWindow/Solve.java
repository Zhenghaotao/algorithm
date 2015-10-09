package maxWindow;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Solve {
	public static void main(String[] args) {
		Solve s = new Solve();
		int[] res = s.getMaxWindow(new int[]{4,3,5,4,3,3,6,7}, 3);
		for(int i : res){
			System.out.print(i + "\t");
		}
	}
	
	public int[] getMaxWindow(int[] arr,int w){
		if(arr == null || w < 1 || arr.length < w){
			return null;
		}
		int[] res = new int[arr.length - w + 1];
		LinkedList<Integer> qmax = new LinkedList<Integer>();
		int index = 0;
		for(int i = 0; i < arr.length; i++){
			while(!qmax.isEmpty() && arr[qmax.peekLast()] <= arr[i]){
				qmax.pollLast();
			}
			
			qmax.addLast(i);
			if(qmax.peekFirst() == i - w){
				qmax.pollFirst();
			}
			if(i >= w - 1){
				res[index++] = arr[qmax.peekFirst()];
			}
		}
		return res;
	}
	
}
