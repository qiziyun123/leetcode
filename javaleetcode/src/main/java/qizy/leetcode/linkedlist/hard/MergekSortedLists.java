package qizy.leetcode.linkedlist.hard;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergekSortedLists {

	public static void main(String[] args) {
		// Input:
//		[
//		  1->4->5,
//		  1->3->4,
//		  2->6,
//		  7->8
//		]
//		Output: 1->1->2->3->4->4->5->6

	}

	public static ListNode heapKLists(ListNode[] lists) {
		PriorityQueue<ListNode> heap = new PriorityQueue<>();
		Comparator<ListNode> c = new Comparator<ListNode>() {
			public int compare(ListNode node1,ListNode node2) {
				return node1.val-node2.val;
			}

		};
		for(int i=0;i<lists.length;i++) {
			ListNode temp = lists[i];
			heap.add(temp);
		}
		ListNode head=new ListNode(0);
		ListNode cur=head;
		while(!heap.isEmpty()){
			ListNode t = heap.poll();
			if(t.next!=null) {
				heap.add(t.next);
			}
			cur.next = t;
			cur =cur.next;
		}
		return head.next;
	}
	
	public static ListNode mergeKLists(ListNode[] lists) {
		ListNode r = mergeSort(lists,0,lists.length-1);
		return r;
	}

	private static ListNode mergeSort(ListNode[] lists, int left, int right) {
		
		if(left<right) {
			int mid = (left+right)/2;
			return mergeTwoSortList(mergeSort(lists,left,mid),(mergeSort(lists,mid+1,right)));
			
		}
		return mergeTwoSortList(lists[left],lists[right]);
		
		
	}

	private static ListNode mergeTwoSortList(ListNode node1, ListNode node2) {
		if(node1==node2) {
			return node1;
		}
		ListNode temp;
		if(node1.val<node2.val) {
			temp = node1;
		}else {
			temp = node2;
		}
		while(node1.next!=null&&node2.next!=null) {
			if(node1.next.val<node2.next.val) {
				temp.next = node1.next;
			}else {
				temp.next = node2.next;
			}
		}
		while(node1.next!=null) {
			temp.next=node1.next;
		}
		while(node2.next!=null) {
			temp.next=node2.next;
		}
		return temp;
	}

	/**
	 * Definition for singly-linked list.
	 * 
	 */
	static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}
}
