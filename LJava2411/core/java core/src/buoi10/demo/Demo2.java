package buoi10.demo;

public class Demo2 {
    public static void main(String[] args) {
        System.out.println("Main thread start");
        // c1 sử dụng 1 thread chính thực thi công việc
        System.out.println("Task1 start1");
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task1 finish");
        // output
        /*
        Main thread start
        Task1 start1
        Task1 finish
        Main thread finished
         */
        System.out.println("Main thread finished");

    }
}
