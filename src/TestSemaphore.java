import java.util.concurrent.Semaphore;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class TestSemaphore {
    public static void main(String[] args) throws InterruptedException {
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                try {
                    // 获取许可
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " is running");
                    Thread.sleep(1000);
                    // 释放许可
                    semaphore.release();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
