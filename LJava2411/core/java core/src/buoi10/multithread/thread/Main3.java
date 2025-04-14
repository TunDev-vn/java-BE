package buoi10.multithread.thread;

class MyThread3 extends Thread {
    @Override
    public void run() {
        try {
            Thread.sleep(2000); // Timed Waiting
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Thread finished");
    }
    public static void main(String[] args) {
        MyThread3 thread = new MyThread3();
        System.out.println("Thread state: " + thread.getState()); // New
        thread.start();
        System.out.println("Thread state: " + thread.getState()); // Runnable/Blocked
    }
}
