package qizy.leetcode.queue.medium;

public class MyCircularQueue {
	/**
	 * Your MyCircularQueue object will be instantiated and called as such:
	 * MyCircularQueue obj = new MyCircularQueue(k); 
	 * boolean param_1 =
	 * obj.enQueue(value); 
	 * boolean param_2 = obj.deQueue(); 
	 * int param_3 =
	 * obj.Front(); 
	 * int param_4 = obj.Rear(); 
	 * boolean param_5 = obj.isEmpty();
	 * boolean param_6 = obj.isFull();
	 */

	private int[] queue;
	// 当前队列大小
	private int size;
	// 可读取的位置
	private int front=0;
	// 可写入的位置
	private int rear=-1;
	public static void main(String[] args) {
		MyCircularQueue circularQueue = new MyCircularQueue(3); // set the size to be 3
		System.out.println(circularQueue.enQueue(1));  // return true
		System.out.println(circularQueue.enQueue(2));  // return true
		System.out.println(circularQueue.enQueue(3)); // return true
		System.out.println(circularQueue.enQueue(4));  // return false, the queue is full
		System.out.println(circularQueue.Rear());  // return 3
		System.out.println(circularQueue.isFull());  // return true
		System.out.println(circularQueue.deQueue()); // return true
		System.out.println(circularQueue.enQueue(4));  // return true
		System.out.println(circularQueue.Rear());  // return 4
	}

	public MyCircularQueue(int k) {
		queue = new int[k];
	}

	/**
	 * Insert an element into the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean enQueue(int value) {
		if(isFull()) {
			return false;
		}else {
			rear=(rear+1)%queue.length;
			queue[rear]=value;
			size++;
			return true;
		}
	}

	/**
	 * Delete an element from the circular queue. Return true if the operation is
	 * successful.
	 */
	public boolean deQueue() {
		if(isEmpty()) {
			return false;
		}else {
			front++;
			front=front%queue.length;
			size--;
			return true;
		}
	}

	/** Get the front item from the queue. */
	public int Front() {
		return queue[front];
	}

	/** Get the last item from the queue. */
	public int Rear() {
		return queue[rear];
	}

	/** Checks whether the circular queue is empty or not. */
	public boolean isEmpty() {
		return size==0;
	}

	/** Checks whether the circular queue is full or not. */
	public boolean isFull() {
		return size == queue.length;
	}
}
