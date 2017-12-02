package lipeng.one;

import java.util.concurrent.TimeUnit;

/**
 * @author lipeng
 * @date 2017/11/25
 */
public class NetworkConnectionsLoader implements Runnable {

    @Override
    public void run() {
        System.out.println("业务开始执行。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        try {
            TimeUnit.SECONDS.sleep(6);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("业务执行完毕。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
    }
}
