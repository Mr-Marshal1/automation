package itstep.task4;

// V11.
// a)	Create a thread that waits for a signal from another thread using wait and notify.
public class ThreadWaitNotify {
    public static void main(String[] args) {
        final Object signal = new Object();

        Thread waitingThread = new Thread(() -> {
            synchronized (signal) {
                try {
                    System.out.println("Waiting for signal...");
                    signal.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Received signal!");
            }
        });

        Thread signalingThread = new Thread(() -> {
            synchronized (signal) {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                signal.notify();
                System.out.println("Signal sent!");
            }
        });

        waitingThread.start();
        signalingThread.start();
    }
}
