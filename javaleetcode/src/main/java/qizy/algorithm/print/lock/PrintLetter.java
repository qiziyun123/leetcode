package qizy.algorithm.print.lock;

public class PrintLetter implements Runnable {
	private FlagBean flag;

	public PrintLetter(FlagBean flag) {
		this.flag = flag;
	}

	public void run() {
		while (true) {
			flag.lock.lock();
			try {
				if (flag.getWhichRun().equals("letter")) {
					System.out.println("ABCDEFG");
					flag.count++;
					flag.setWhichRun("num");

					flag.numCondition.signal();

				} else {
					flag.letterCondition.await();
				}
			} catch (Exception e) {

			} finally {
				flag.lock.unlock();
			}
		}

	}

}
