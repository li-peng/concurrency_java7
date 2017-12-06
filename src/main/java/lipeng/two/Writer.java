package lipeng.two;

import java.util.Random;

/**
 * @author lipeng
 * @date 2017/12/5
 */
public class Writer implements Runnable {
    private PricesInfo pricesInfo;

    public Writer(PricesInfo pricesInfo) {
        this.pricesInfo = pricesInfo;
    }

    @Override
    public void run() {
        for (int i = 0; i < 3; i++) {
            System.out.println("Writer 开始修改价格。。。。。。。。。。。。。。。。。。。。。。");
            pricesInfo.setPrices(new Random().nextInt(10),new Random().nextInt(8));
            System.out.println("Writer 修改价格完毕-----------");
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
