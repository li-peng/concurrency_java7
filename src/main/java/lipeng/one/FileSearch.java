package lipeng.one;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * @author lipeng
 * @date 2017/11/25
 */
public class FileSearch implements Runnable {
    String initPath;
    String fileName;

    public FileSearch(String initPath, String fileName) {
        this.initPath = initPath;
        this.fileName = fileName;
    }

    public static void main(String[] args) {
        FileSearch searcher = new FileSearch("E:\\惠每\\数据处理", "hospital_disease.sql");
        Thread thread = new Thread(searcher);
        thread.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread.interrupt();
    }

    @Override
    public void run() {
        File file = new File(initPath);
        if (file.isDirectory()) {
            try {
                directoryProcess(file);
            } catch (InterruptedException e) {
                System.out.println("搜索被中断：线程名=" + Thread.currentThread().getName());
            }
        }
    }

    private void directoryProcess(File file) throws InterruptedException {
        File[] list = file.listFiles();
        if (list != null) {
            for (int i = 0; i < list.length; i++) {
                if (list[i].isDirectory()) {
                    directoryProcess(list[i]);
                } else {
                    fileProcess(list[i]);
                }
            }
            if (Thread.interrupted()) {
                System.out.println("搜索被中断：线程名=" + Thread.currentThread().getName());
//                throw new InterruptedException();
            }
        }
    }

    private void fileProcess(File file) throws InterruptedException {
        if (file.getName().equals(fileName)) {
            System.out.println("线程=" + Thread.currentThread().getName() + file.getAbsolutePath());
        }
        if (Thread.interrupted()) {
            System.out.println("搜索被中断：线程名=" + Thread.currentThread().getName());
//            throw new InterruptedException();
        }
    }
}
