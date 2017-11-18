package lipeng.one;

import java.util.concurrent.TimeUnit;

/**
 * @author lipeng
 * @date 2017/11/18
 */
public class PrimeGenerator implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new PrimeGenerator(9L));
        t.start();
        TimeUnit.SECONDS.sleep(5);
        System.out.println("现在中断线程。。。。。。。。。。。。。。。。。。。。。。。");
        t.interrupt();
    }

    private Long num;

    public PrimeGenerator(Long num) {
        this.num = num;
    }

    @Override
    public void run() {
        while (true) {
            if (this.isOdd(num)) {
                System.out.println(num + " 是奇数");
            }
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("线程被中断。。。。。。。。。。。。。。。。。。。。。。。");
                return;
            }
        }
    }

    private boolean isOdd(Long num) {
        return (num & 1) == 1;

    }

}
// .......
//9 是奇数
//        9 是奇数
//        9 是奇数
//        现在中断线程。。。。。。。。。。。。。。。。。。。。。。。
//        9 是奇数
//        9 是奇数
//        9 是奇数
//        9 是奇数
//        9 是奇数
//        9 是奇数
//        线程被中断。。。。。。。。。。。。。。。。。。。。。。。
