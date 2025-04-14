package buoi10.demo;

import buoi10.btvn.CustomException;

public class Demo1 {

    public static void main(String[] args) {
        System.out.println("Main thread start");
       /*
       demo thực thi task 1 trên thread chính -> thread chính phải
       chờ task 1 thực hiện xong, mới có thể hiển thị "Main thread finished"

        System.out.println("Task1 start1");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task1 finish");

        */
        // c2: tạo ra 1 thread ngầm thực hiện công việc, tách rời
        // so với thread chính
        MyThread thread2 = new MyThread("task1"); // tao ra thread
        thread2.start(); // khi gọi hàm start() -> hàm run() được chạy
        System.out.println("Main thread finished");
    }
}
