package qizy.algorithm.proconsum.lock;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Storage {
	private Lock lock = new ReentrantLock();
	private Condition full = lock.newCondition();
	private Condition empty = lock.newCondition();
	private Queue<Object> list = new LinkedList<Object>();
	private int size = 16;
	BlockingQueue<Object> queue = new LinkedBlockingQueue<Object>();
	public Object get() {
		try {
			lock.lock();
			while(list.size()==0) {
				System.out.println("empty now pls wait");
				empty.await();
			}
			Object e = list.poll();
//			empty.signalAll();
			full.signalAll();
			return e;
		}catch(InterruptedException e) {
			return null;
		}finally {
			lock.unlock();
		}
	}
	
	public void set(Object o) {
		try {
			lock.lock();
			while(list.size()==size) {
				System.out.println("full now pls wait");
				full.await();
			}
			list.add(o);
//			full.signalAll();
			empty.signalAll();
		}catch(InterruptedException e) {
		}finally {
			lock.unlock();
		}
	}
}
