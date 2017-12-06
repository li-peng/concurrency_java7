package lipeng.two;

/**
 * @author lipeng
 * @date 2017/12/5
 */
public class Reader implements Runnable {
    private PricesInfo pricesInfo;

    public Reader(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println("线程：" + threadName + "价格1====" + pricesInfo.getPrice1());
            System.out.println("线程：" + threadName + "价格2====" + pricesInfo.getPrice2());
        }

    }
}
