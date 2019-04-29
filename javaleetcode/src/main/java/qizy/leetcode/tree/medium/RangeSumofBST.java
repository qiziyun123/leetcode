package qizy.leetcode.tree.medium;

import java.util.Stack;

public class RangeSumofBST {

	public static void main(String[] args) {
		// Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
		// Output: 23
		TreeNode root = new TreeNode(10);
		root.left =new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);
		System.out.println(rangeSumBST(root,7,15));
	}

	public static int rangeSumBST(TreeNode root, int L, int R) {
		// 范围中序遍历呗
		// 7 15
		// 10,5,15,3,7,null,18
		// 		10
		// 	5 15
		// 	3 7 null 18
		TreeNode p = root;
		Stack<TreeNode> s = new Stack<TreeNode>();
		int sum = 0;
		while(!s.isEmpty()||p!=null) {
			if(p!=null) {
				s.push(p);
                
                    p=p.left;
                
				
			}else {
				TreeNode temp = s.pop();
				if(temp.val>=L&&temp.val<=R) {
					sum+=temp.val;
				}
				p = temp.right;
			}
		}
		return sum;

	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
