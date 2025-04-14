package buoi10.multithread.multi;
class MyThread extends Thread {
    private String task;
    public MyThread(String task) {
        this.task = task;
    }
    @Override
    public void run() {
        System.out.println(task + " started by " + Thread.currentThread().getName());
        try {
            Thread.sleep(1000); // Giả lập công việc đang được thực hiện
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(task + " finished by " + Thread.currentThread().getName());
    }
}
public class Main1 {
    public static void main(String[] args) {
        // Tạo và bắt đầu nhiều thread
        MyThread thread1 = new MyThread("Task 1");
        MyThread thread2 = new MyThread("Task 2");
        MyThread thread3 = new MyThread("Task 3");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
