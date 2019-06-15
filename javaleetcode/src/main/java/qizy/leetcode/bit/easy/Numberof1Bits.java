package qizy.leetcode.bit.easy;

public class Numberof1Bits {

	public static void main(String[] args) {
		// http://blog.csdn.net/zheng0518/article/details/8882394
		// n&(n-1)作用：将n的二进制表示中的最低位为1的改为0，先看一个简单的例子：
//		n = 10100(二进制），则(n-1) = 10011 ==》n&(n-1) = 10000
//				可以看到原本最低位为1的那位变为0。
		// 1、 判断一个数是否是2的方幂
		// 2. 求某一个数的二进制表示中1的个数
		// 3. 计算N!的质因数2的个数
	}

	public int hammingWeight(int n) {
        int count=0;
        while(n!=0) {
        	n=n&(n-1);
        	count++;		
        }
        return count;
    }

}
