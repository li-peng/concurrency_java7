package lipeng.two;

/**
 * @author lipeng
 * @date 2017/12/5
 */
public class Job implements Runnable {
    private PrintQueue printQueue;

    public Job(PrintQueue printQueue) {
        this.printQueue = printQueue;
    }

    @Override
    public void run() {
        String threadName=Thread.currentThread().getName();
        System.out.println(threadName+" 开始打印一个文档");
        printQueue.printJob(new Object());
        System.out.println(threadName+" 打印一个文档-------结束------------------------------");
    }
}
