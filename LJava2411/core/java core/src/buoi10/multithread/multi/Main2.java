package buoi10.multithread.multi;
class MyRunnable implements Runnable {
    private String task;
    public MyRunnable(String task) {
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
    public static void main(String[] args) {
        // Tạo đối tượng Runnable cho các task
        MyRunnable task1 = new MyRunnable("Task 1");
        MyRunnable task2 = new MyRunnable("Task 2");
        MyRunnable task3 = new MyRunnable("Task 3");
        // Tạo các thread và gán Runnable
        Thread thread1 = new Thread(task1);
        Thread thread2 = new Thread(task2);
        Thread thread3 = new Thread(task3);

        // Bắt đầu các thread
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
public class Main2 {
}
