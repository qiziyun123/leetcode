package qizy.algorithm.proconsum.syncthronized;

public class RunMain {

	
	public static void main(String[] args) {
		Storage s = new Storage();
		Produce p1 =new Produce(s);
		Produce p2 =new Produce(s);
		Produce p3 =new Produce(s);

		Consume c1 = new Consume(s);
		Consume c2 = new Consume(s);
		
		new Thread(p1).start();
		new Thread(p2).start();
		new Thread(p3).start();
		new Thread(c1).start();
		new Thread(c2).start();
	}

	
}



