package lipeng.one;

import java.util.concurrent.TimeUnit;

/**
 * @author lipeng
 * @date 2017/11/25
 */
public class DataSourceesLoader implements Runnable {

    @Override
    public void run() {
        System.out.println("开始初始化资源。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("初始化资源完成。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。");
    }
}
