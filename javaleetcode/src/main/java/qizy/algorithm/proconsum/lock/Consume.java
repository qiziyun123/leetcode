package qizy.algorithm.proconsum.lock;

public class Consume implements Runnable{

	public Consume(Storage s) {
		this.s= s;
	}
	private Storage s;
	
	public void run() {
		while(true) {
			System.out.println(s.get());
		}
		
	}
	
}
