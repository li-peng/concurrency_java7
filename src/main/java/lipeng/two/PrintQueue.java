package lipeng.two;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 打印队列
 *
 * @author lipeng
 * @date 2017/12/5
 */
public class PrintQueue {
    private final Lock lock = new ReentrantLock();

    public void printJob(Object doc) {
        lock.lock();// 获取锁的控制权
        try {
            long time = (long) (Math.random() * 10000);
            System.out.println(Thread.currentThread().getName() + "打印一个文档，用时：" + (time / 1000) + "秒");
            Thread.sleep(time);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

}
