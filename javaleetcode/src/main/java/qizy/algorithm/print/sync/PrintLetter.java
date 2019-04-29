package qizy.algorithm.print.sync;

public class PrintLetter implements Runnable {
	private FlagBean flag;
	private Object lock;

	public PrintLetter(Object lock, FlagBean flag) {
		this.lock = lock;
		this.flag = flag;
	}

	public void run() {
		while (true) {
			synchronized (lock) {

				if (flag.getWhichRun().equals("letter")) {
					System.out.println("ABC");
					flag.setWhichRun("num");
					try {
						lock.notifyAll();
						lock.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}

	}

}
