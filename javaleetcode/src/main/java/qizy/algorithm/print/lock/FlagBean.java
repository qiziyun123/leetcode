package qizy.algorithm.print.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FlagBean {
	int count;
	private String whichRun;
	Lock lock = new ReentrantLock();
	Condition letterCondition = lock.newCondition();
	Condition numCondition = lock.newCondition();
	Condition fuhaoCondition = lock.newCondition();
	
	public String getWhichRun() {
		return whichRun;
	}

	public void setWhichRun(String whichRun) {
		this.whichRun = whichRun;
	}
	
}
