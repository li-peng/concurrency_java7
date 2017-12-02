package lipeng.one;

import java.util.Date;
import java.util.Deque;
import java.util.concurrent.TimeUnit;

/**
 * @author lipeng
 * @date 2017/11/25
 */
public class WriterTask implements  Runnable {
    private Deque<Event> deque;

    public WriterTask(Deque<Event> deque) {
        this.deque = deque;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            Event event=new Event();
            event.setDate(new Date());
            event.setEvent("线程"+Thread.currentThread().getId()+"产生了一个事件"+i);
            deque.addFirst(event);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
