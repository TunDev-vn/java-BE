package buoi10.demo;

public class MyThread extends Thread{
    private String name;

    public MyThread(String name) {
        super(name);
        this.name = name;
    }
    /*
         Sẽ là hàm thực thi các công việc chính khi thread chạy
         - khi thread bắt đầu chạy, hàm run sẽ được thực thi
         */
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
        //c2: Tạo thread ngầm, tách biệt với thread chính
        System.out.println("Main thread start");



    }
}
