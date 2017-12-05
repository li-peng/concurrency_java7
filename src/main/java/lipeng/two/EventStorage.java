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
        while(storage.size()==maxSize){  // 为什么要用while，if不可以吗？例：demo4
//            在传统通信的条件判断时，我们会用while而不是if做条件判断，是为了虚假唤醒。那么什么是虚假唤醒呢？
//            虚假唤醒即：如：我们要求AB方法按顺序执行，有5个线程执行A，5个线程执行B，
// 如果某时刻全部A等待，当其中A1被唤醒，并执行完代码后，会调用notify方法，其本意是唤醒B模块执行线程，
// 但是由于AB公用一个锁，所以可能将A唤醒，即唤醒了不该执行的代码，这就是虚假唤醒
            // 在demo4中，2个生产者，2个消费者，消费者1消费最后一个数据后，唤醒其他等待storage锁的线程，那么
            // 消费者2可能被唤醒，但是其实现在盒子中并没有数据。造成的结果是，代码运行完之后剩余个数不为0
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
        while(storage.size()==0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//        System.out.println("消费前，总个数="+storage.size());
        storage.poll();
        System.out.println("消费一个，总个数="+storage.size());
        notifyAll();
    }
}
