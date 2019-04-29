package qizy.leetcode.linkedlist.easy;

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		ListNode middle = reverseList(head);
		System.out.println(middle.val);
	}

	public static ListNode reverseList(ListNode head) {
		if(head==null  ){
            return null;
        }
        if(head.next==null) {
			return head;
		}
		// 1	 2	 	3	 4	 5
		// <-p    <-n	t
		ListNode p = head;
		ListNode n = head.next;
		p.next=null;
		while(n.next!=null) {
			ListNode temp =n.next;
			n.next = p;
			p = n;
			n = temp;
		}
		n.next=p;
		return n;
	}

	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
