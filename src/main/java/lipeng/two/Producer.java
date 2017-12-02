package lipeng.two;

/**
 * @author lipeng
 * @date 2017/12/2
 */
public class Producer implements  Runnable {
    private EventStorage storage;
    public Producer(EventStorage storage){
        this.storage=storage;
    }
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            storage.set();
        }
    }
}
