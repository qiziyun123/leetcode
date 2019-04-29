package qizy.leetcode.dfs.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		String path = "";
		res = findAll(res, path, root);
		return res;
	}

	private static List<String> findAll(List<String> res, String path, TreeNode root) {
		if (root == null) {
			res.add(path);
			return res;
		}
		if (root.left!=null) {
			findAll(res,path+root.val+"->",root.left);
		}
		if(root.right!=null) {
			findAll(res,path+root.val+"->",root.right);
		}
		if(root.left==null&&root.right==null) {
			findAll(res,path+root.val,null);
		}
		return res;	
	}

	class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}
}
