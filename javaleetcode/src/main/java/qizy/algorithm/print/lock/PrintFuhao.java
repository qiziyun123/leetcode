package qizy.algorithm.print.lock;

public class PrintFuhao implements Runnable {
	private FlagBean flag;

	public PrintFuhao(FlagBean flag) {
		this.flag = flag;
	}

	public void run() {
		while (true) {
			flag.lock.lock();
			try {
				if (flag.getWhichRun().equals("fuhao")) {
					System.out.println("@@@@@");
					flag.setWhichRun("letter");
					flag.letterCondition.signal();
				}else {
					flag.fuhaoCondition.await();
				}
			} catch (Exception e) {

			} finally {
				flag.lock.unlock();
			}
		}

	}

}
