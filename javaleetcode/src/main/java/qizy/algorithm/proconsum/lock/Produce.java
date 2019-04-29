package qizy.algorithm.proconsum.lock;

public class Produce implements Runnable{

	public Produce(Storage s) {
		this.s= s;
	}
	private Storage s;
	
	public void run() {
		while(true) {
			s.set(new Object());
		}
		
	}
	
}
