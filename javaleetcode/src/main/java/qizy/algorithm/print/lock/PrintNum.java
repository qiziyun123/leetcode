package qizy.algorithm.print.lock;

public class PrintNum implements Runnable {
	private FlagBean flag;

	public PrintNum(FlagBean flag) {
		this.flag = flag;
	}

	public void run() {
		while (true) {
			flag.lock.lock();
			try {
				if (flag.getWhichRun().equals("num")) {
					System.out.println("12345");
					flag.setWhichRun("fuhao");
					flag.fuhaoCondition.signal();
				}else {
					flag.numCondition.await();
				}
			} catch (Exception e) {

			} finally {
				flag.lock.unlock();
			}
		}

	}
}
