package qizy.algorithm.print.lock;

public class AppMain {

	/*
	 * 线程交替打印，用信号法，但注意 原始数据类型 和string不可以，除非你写在一个类里面用内部类方式，否则无法共享信号
	 */
	public static void main(String[] args) throws InterruptedException {
		FlagBean flag = new FlagBean();
		flag.setWhichRun("letter");
		Thread pnum = new Thread(new PrintNum(flag));
		Thread pletter = new Thread(new PrintLetter(flag));
		Thread pfuhao = new Thread(new PrintFuhao(flag));

		pnum.start();
		pnum.sleep(1000);
		pletter.start();
		pletter.sleep(1000);
		pfuhao.start();
		pfuhao.sleep(1000);
	}

}
