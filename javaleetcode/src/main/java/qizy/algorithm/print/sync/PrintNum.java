package qizy.algorithm.print.sync;

public class PrintNum implements Runnable {
	private Object lock;
	private FlagBean flag;

	public PrintNum(Object lock, FlagBean flag) {
		this.lock = lock;
		this.flag = flag;
	}

	public void run() {
		while (true) {
			synchronized (lock) {
				if (flag.getWhichRun().equals("num")) {
					System.out.println("123");
					flag.setWhichRun("fuhao");
					try {
						lock.notifyAll();
						lock.wait();
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
				}
			}
		}

	}
}
