package containSubTree;
/**
 * t1树是否包含t2树的拓扑结构
 */
public class Solve {
	
	public boolean contains(TreeNode t1,TreeNode t2){
		return check(t1, t2) || contains(t1.left,t2) || contains(t1.right ,t2);
	}

	private boolean check(TreeNode t1, TreeNode t2) {
		if(t2 == null){
			return true;
		}
		if(t1 == null || t1.val != t2.val){
			return false;
		}
		return check(t1.left, t1.left) && check(t1.right, t2.right);
	}
	
	public int minColor(char[] chs){
		int num;
		int swap;
		int countg = 0;
		int countr = 0;
		int count1 = 0;
		int count2 = 0;
		
		num = chs.length;
		for(swap = num - 1; swap >= 0; swap--){
			if(chs[swap] == 'r'){
				countr = swap;
			} else {
				continue;
			}
		}
		
		for(swap = 0; swap < num - 1; swap++){
			if(chs[swap] == 'g'){
				countg = swap;
			} else {
				continue;
			}
		}
		for(swap = countg ; swap <= countr;swap++){
			if(chs[swap] == 'g'){
				count1++;
			}
			if(chs[swap] == 'r'){
				count2++;
			}
		}
		
		return count1 > count2 ? count2: count1;
		
	}

	
	
}
class TreeNode{
	int val;
	TreeNode left;
	TreeNode right;
}



