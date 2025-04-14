package buoi10.multithread.thread;
class MyThread4 extends Thread {
    @Override
    public void run() {
        try {
            int result = 10 / 0; // Gây ra ngoại lệ
        } catch (ArithmeticException e) {
            System.out.println("Caught exception: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        MyThread4 thread = new MyThread4();
        thread.start();
    }
}

public class Main4 {
}
