import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {
    ThreadLocal<Long> longLocal = new ThreadLocal<Long>();
    ThreadLocal<String> stringLocal = new ThreadLocal<String>();

    public void set() {
        longLocal.set(Thread.currentThread().getId());
        stringLocal.set(Thread.currentThread().getName());
    }

    public long getLong() {
        return longLocal.get();
    }

    public String getString() {
        return stringLocal.get();
    }

    public static void main(String[] args) throws InterruptedException {
        final ThreadLocalDemo test = new ThreadLocalDemo();

        test.set();
        System.out.println("父线程 main ：");
        System.out.println(test.getLong());
        System.out.println(test.getString());

        Thread thread1 = new Thread() {
            public void run() {
                test.set();
                System.out.println("\n子线程 Thread-0 ：");
                System.out.println(test.getLong());
                System.out.println(test.getString());
            };
        };
        thread1.start();
    }

}
