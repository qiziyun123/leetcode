package qizy.leetcode.tree.medium;

import java.util.Stack;

public class KthSmallestElementinaBST {

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
	public int kthSmallest(TreeNode root, int k) {
        // 中序+計時器
		int count=0;
		Stack<TreeNode> s = new Stack<TreeNode>();
		if(root ==null) {
			return 0;
		}
		s.push(root);
		TreeNode p=root;
		while(!s.isEmpty()) {
			if(p!=null&&p.left!=null) {
				s.push(p.left);
				p=p.left;
			}else {
				p=s.pop();
				count++;
				if(count==k) {
					return p.val;
				}
				if(p.right!=null) {
					s.push(p.right);
					p=p.right;
				}else {
					p=null;
				}
			}
		}
		return 0;
		
    }
}
