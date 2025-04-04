package MultiThread;

public class SequentialPrinting {
    private static final int MAX_NUMBER = 100;
    private static int currentNumber = 0;
    private static final Object lock = new Object();

    public static void main(String[] args) {
        // 创建 3 个线程
        Thread thread1 = new Thread(new Printer(0), "Thread-0");
        Thread thread2 = new Thread(new Printer(1), "Thread-1");
        Thread thread3 = new Thread(new Printer(2), "Thread-2");

        // 启动线程
        thread1.start();
        thread2.start();
        thread3.start();
    }

    static class Printer implements Runnable {
        private final int threadId;

        public Printer(int threadId) {
            this.threadId  = threadId;
        }

        @Override
        public void run() {
            while (true) {
                synchronized (lock) {
                    // 检查是否超出范围
                    if (currentNumber > MAX_NUMBER) {
                        break;
                    }

                    // 判断当前线程是否应该打印
                    if (currentNumber % 3 == threadId) {
                        System.out.println(Thread.currentThread().getName()  + ": " + currentNumber);
                        currentNumber++;
                        lock.notifyAll();  // 唤醒其他线程
                    } else {
                        try {
                            lock.wait();  // 等待其他线程打印
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}
