package lipeng.one;

/**
 * @author lipeng
 * @date 2017/12/2
 */
public class ExceptionHandler implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        System.out.println("一个异常被捕获。。。。。。。。。。。。。。。");
        System.out.println("抛出异常的线程id=" + t.getId());
        System.out.println("异常信息：" + e.getClass().getName() + ";;;" + e.getMessage());
    }
}
