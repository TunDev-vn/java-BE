package buoi10.multithread.thread;
import static java.lang.Thread.sleep;
class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("Sub thread is running");
        try {
            sleep(100); // giả lập thread xử lý mất 1s
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Sub thread is finish");
    }
}
public class Main2 {
    public static void main(String[] args) {
        System.out.println("Starting main");
        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();
        System.out.println("Finish main thread");
    }
}
