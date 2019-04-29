package qizy.algorithm.print.sync;

public class AppMain {

	/*
	 * 线程交替打印，用信号法，但注意 原始数据类型 和string不可以，除非你写在一个类里面用内部类方式，否则无法共享信号
	 */
	public static void main(String[] args) {
		FlagBean flag = new FlagBean();
		flag.setWhichRun("letter");
		Object lock = new Object();
		Thread pnum = new Thread(new PrintNum(lock,flag));
		Thread pletter = new Thread(new PrintLetter(lock,flag));
		Thread pfuhao = new Thread(new PrintFuhao(lock,flag));

		pnum.start();
		pletter.start();
		pfuhao.start();
	}

}
