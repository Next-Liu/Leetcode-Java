/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class BlockingQueueExample {
    public static void main(String[] args) {
        // 创建一个 LinkedBlockingQueue 实例
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>(3);

        // 创建生产者线程
        Thread producer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    blockingQueue.put(i);  // 将元素放入队列，如果队列已满则阻塞
                    System.out.println("Produced: " + i);
                    Thread.sleep(1000);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 创建消费者线程
        Thread consumer = new Thread(() -> {
            try {
                for (int i = 1; i <= 5; i++) {
                    Integer value = blockingQueue.take();  // 从队列中取出元素，如果队列为空则阻塞
                    System.out.println("Consumed: " + value);
                    Thread.sleep(1500);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        // 启动生产者和消费者线程
        producer.start();
        consumer.start();
    }
}
