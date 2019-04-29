package qizy.algorithm.proconsum.syncthronized;

import java.util.LinkedList;
import java.util.Queue;

public class Storage {
	
	private Queue<Object> list = new LinkedList<Object>();
	private int size = 32;
	public Object get() {
		synchronized (list) {
			while(list.size()==0) {
				try {
					list.wait();
				}catch(Exception e) {
					
				}
			}
			Object o = list.poll();
			list.notifyAll();
			return o;
		}
	}
	
	public void set(Object o) {
		synchronized (list) {
			while(list.size()==size) {
				try {
					list.wait();
				}catch(Exception e) {
					
				}
			}
			list.add(o);
			list.notifyAll();
		}
	}
}
