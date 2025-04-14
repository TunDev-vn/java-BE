package buoi10.demo;

public class DemoRunnable implements Runnable {
    private String name;

    public DemoRunnable(String name) {
        this.name = name;
    }
    @Override
    public void run() {
        System.out.println(this.name + " start1");
        try {
            Thread.sleep(1); // thread dừng 1s, giải lập xử lý nghiệp vụ
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println(this.name + " finish");
    }

    public static void main(String[] args) {
        System.out.println("Main thread start");
        // tạo ra đối tượng Runnable
        DemoRunnable demoRunnable = new DemoRunnable("Task1");
        // truyền Runnable vào thread để tạo ra thread
        Thread thread = new Thread(demoRunnable);
        thread.start();// khi hàm start được gọi, thread bắt đầu chạy, hàm run được chạy
        System.out.println("Main thread finished");
    }
}
