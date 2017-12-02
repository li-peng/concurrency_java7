package lipeng.two;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author lipeng
 * @date 2017/12/2
 */
public class EventStorage {
    int maxSize;
    LinkedList<Date> storage;

    public EventStorage() {
        maxSize =10;
        storage = new LinkedList<>();
    }
    public synchronized void set(){
        // 如果盒子满了，就等待。并释放锁，线程进入休眠
        if(storage.size()==maxSize){  // 为什么要用while，if不可以吗？
            try {
                this.wait(); // 其他线程调用了notify方法会继续执行。
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // 往盒子中加一条数据
        storage.add(new Date());
        System.out.println("生产一个，总个数="+storage.size());
        // 将因为此线程占有锁而休眠的线程唤醒。
        notifyAll();
    }
    public synchronized void get(){
        if(storage.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.poll();
        System.out.println("消费一个，总个数="+storage.size());
        notifyAll();
    }
}
