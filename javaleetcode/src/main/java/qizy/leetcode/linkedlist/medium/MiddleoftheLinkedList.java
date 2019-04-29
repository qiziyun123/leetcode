package qizy.leetcode.linkedlist.medium;

public class MiddleoftheLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		ListNode middle = middleNode(head);
		System.out.println(middle.val);
	}

	public static ListNode middleNode(ListNode head) {
		// 1  2	 3	4	5 		6
		ListNode fast;
		ListNode slow;
		fast = head;
		slow = head;
		while(fast.next!=null) {
			if(fast.next.next!=null) {
				slow = slow.next;
				fast= fast.next.next;
			}else {
				slow = slow.next;
				fast= fast.next;
			}
			
		}
		return slow;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
