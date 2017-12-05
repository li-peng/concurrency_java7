package lipeng.two;

/**
 * @author lipeng
 * @date 2017/12/2
 */
public class Main {
    public static void main(String[] args) {
//        demo1();
//        demo2();
//        demo3();
        demo4();
    }

    public static void demo1() {
        Account account = new Account();
        account.setBalance(1000);
        Company company = new Company(account);
        Thread thread1 = new Thread(company);
        Bank bank = new Bank(account);
        Thread thread2 = new Thread(bank);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(account.getBalance());

    }

    private static void demo2() {
        Cinema cinema = new Cinema();
        TicketOffice1 office1 = new TicketOffice1(cinema);
        Thread thread1 = new Thread(office1);
        TicketOffice1 office2 = new TicketOffice1(cinema);
        Thread thread2 = new Thread(office2);
        thread1.start();
        thread2.start();
        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1号厅余票=" + cinema.getTicketCount1());
        System.out.println("2号厅余票=" + cinema.getTicketCount2());
    }

    private static void demo3() {
        EventStorage storage = new EventStorage();
        Producer producer = new Producer(storage);
        Thread thread1 = new Thread(producer);
        Consumer consumer = new Consumer(storage);
        Thread thread2 = new Thread(consumer);
        thread1.start();
        thread2.start();


    }

    private static void demo4() {
        EventStorage storage = new EventStorage();
        for (int i = 0; i < 2; i++) {
            Producer producer = new Producer(storage);
            Thread thread1 = new Thread(producer);
            thread1.start();
        }

        for (int i = 0; i < 2; i++) {
            Consumer consumer = new Consumer(storage);
            Thread thread2 = new Thread(consumer);
            thread2.start();
        }


    }
}
