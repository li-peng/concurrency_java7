package lipeng.one;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author lipeng
 * @date 2017/11/25
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        //demo1();
//        demo2();
        demo3();

    }

    private static void demo2() {
        Deque<Event> deque = new ArrayDeque<>();
        WriterTask writer = new WriterTask(deque);
        for (int i = 0; i < 3; i++) {
            Thread t = new Thread(writer);
            t.start();
        }
        CleanerTask cleanerTask = new CleanerTask(deque);
        cleanerTask.start();
    }

    private static void demo3() {
        Task task = new Task();
        Thread thread=new Thread(task);
        thread.setUncaughtExceptionHandler(new ExceptionHandler());
        thread.start();
    }

    private static void demo1() throws InterruptedException {
        Thread t1 = new Thread(new DataSourceesLoader());
        Thread t2 = new Thread(new NetworkConnectionsLoader());
        t1.start();
        t2.start();
        t1.join();// 当前线程必须等t1 执行完毕再继续 join 方法可以指定毫秒数，等待指定时间如果还没有T1完成那么主线程将不再等待。
        t2.join();// 当前线程必须等t2 执行完毕再继续
        System.out.println("完毕");
//        开始初始化资源。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
//        业务开始执行。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
//        初始化资源完成。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
//        业务执行完毕。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。
//        完毕
    }
}
