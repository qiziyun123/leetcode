package qizy.algorithm.print.sync;

public class PrintFuhao implements Runnable {
	private FlagBean flag;
	private Object lock;

	public PrintFuhao(Object lock, FlagBean flag) {
		this.lock = lock;
		this.flag = flag;
	}

	public void run() {
		while (true) {
			synchronized (lock) {

				if (flag.getWhichRun().equals("fuhao")) {
					System.out.println("#$&%@");
					flag.setWhichRun("letter");
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
