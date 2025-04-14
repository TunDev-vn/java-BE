package buoi10.multithread.thread;

class MyThread extends Thread {
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
public class Main1 {
    public static void main(String[] args) {
        System.out.println("Starting main");
        MyThread4 thread = new MyThread4();
        thread.start(); // Bắt đầu thread
        System.out.println("Finish main thread");
    }
}
