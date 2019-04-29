package qizy.algorithm.proconsum.syncthronized;

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
