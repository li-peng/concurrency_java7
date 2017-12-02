package lipeng.one;

import java.util.Date;
import java.util.Deque;

/**
 * @author lipeng
 * @date 2017/12/2
 */
public class CleanerTask extends Thread {
    private Deque<Event> deque;

    public CleanerTask(Deque<Event> deque) {
        this.deque = deque;
        // 设置为守护线程
        this.setDaemon(true);
    }

    @Override
    public void run() {
        while (true) {
            Date date = new Date();
            this.clean(date);
        }
    }

    private void clean(Date date) {
        long diff;
        boolean del = false;
        if (deque.size() == 0) {
            return;
        }
        do {
            Event e = deque.getLast();
            diff = date.getTime() - e.getDate().getTime();
            if (diff > 10000) {
                System.out.println("删除时间：" + e.getEvent());
                deque.removeLast();
                del = true;
            }

        } while (diff > 10000);
        if (del) {
            System.out.println("队列长度：" + deque.size());
        }

    }
}
