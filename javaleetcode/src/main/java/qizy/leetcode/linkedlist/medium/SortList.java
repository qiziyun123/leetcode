package qizy.leetcode.linkedlist.medium;

public class SortList {

	public static void main(String[] args) {
		ListNode head1 = new ListNode(4);
		ListNode head2 = new ListNode(2);
		ListNode head3 = new ListNode(1);
		ListNode head4 = new ListNode(3);
		head1.next=head2;
		head2.next=head3;
		head3.next=head4;
		sortList(head1);
		
		System.out.println();
	}

	public static ListNode sortList(ListNode head) {
        if(head==null||head.next==null) {
        	return head;
        }
        ListNode p = head;
        while (p.next != null) {
            System.out.print(p.val);
            p = p.next;
        }
        
        sort(head,p);
        return head;
    }
	
	
	 private static void sort(ListNode head, ListNode end) {
		if(head==end||head==null||end==null) {
			return;
		}
		ListNode b = head;
		ListNode e = end;
		ListNode p = head;
		ListNode q = head.next;
		int sval = head.val;
		while(q!=null&&q!=end.next) {
			// q1=end.next  遍歷左邊部分範圍
			if(q.val<sval) {
				p=p.next;
				swap(p,q);
			}
			q=q.next;
		}
		ListNode mid = p;
		swap(head,p);
		
		sort(b,mid);
		sort(mid.next,e);
		
		
	}


	private static void swap(ListNode p, ListNode q) {
		int pv = p.val;
		int qv = q.val;
		p.val=qv;
		q.val=pv;
		
	}


	public static class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	 }
	 
}
