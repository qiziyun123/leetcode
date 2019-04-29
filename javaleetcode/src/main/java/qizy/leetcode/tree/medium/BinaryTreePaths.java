package qizy.leetcode.tree.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePaths {

	public static void main(String[] args) {
		// Input: root = [10,5,15,3,7,13,18,1,null,6], L = 6, R = 10
		// Output: 23
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(15);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(7);
		root.right.right = new TreeNode(18);
//		inOrder(root);
		System.out.println();
//		postOrder(root);
		List<String> r =binaryTreePaths(root);
		for (String string : r) {
			System.out.println(string);
		}
		
	}

	static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// postorder
	public static void postOrder(TreeNode root) {
		if (root == null) {
			return;
		}
		// 10
		// 5 15
		// 3 7 n 18

		Stack<TreeNode> s = new Stack<TreeNode>();
		Stack<TreeNode> o = new Stack<TreeNode>();
		s.push(root);
		while (!s.isEmpty()) {
			TreeNode temp = s.pop();
			o.push(temp);
			if (temp.left != null) {
				s.push(temp.left);
			}
			if (temp.right != null) {
				s.push(temp.right);
			}
		}
		while (!o.isEmpty()) {
			System.out.println(o.pop().val);
		}
	}

	public static void inOrder(TreeNode root) {
		Stack<TreeNode> s = new Stack<TreeNode>();
		s.push(root);
		TreeNode p = root;
		// 10
		// 5 15
		// 3 7 n 18
		while (!s.isEmpty()) {
			if (p != null && p.left != null) {
				s.push(p.left);
				p = p.left;
			} else {
				p = s.pop();
				System.out.println(p.val);
				if (p.right != null) {
					s.push(p.right);
					p = p.right;
				} else {

					p = null;
				}
			}

		}
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		if(root==null) {
			return null;
		}
		// 10
		// 5 15
		// 3 7 n 18
		List<String> paths = new ArrayList<String>();
		String path = "";
		
		dfs(root,paths,path);
		return paths;
	}

	private static void dfs(TreeNode root, List<String> paths, String path) {
		if(root==null) {
			return;
		}
		if(root.left==null&&root.right==null) {
			paths.add(path+root.val);
			return;
		}
		dfs(root.left, paths, path + root.val + "->");
        dfs(root.right, paths, path + root.val + "->");
	}

}
