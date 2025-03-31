package MultiThread;

public class PrintABC {
    private static final Object lock = new Object();
    private static int state = 0; // 0:A, 1:B, 2:C

    static class PrintTask implements Runnable {
        private String letter;
        private int targetState;

        public PrintTask(String letter, int targetState) {
            this.letter = letter;
            this.targetState = targetState;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10; i++) {  //打印的轮次
                synchronized (lock) {
                    while (state % 3 != targetState) {//不能用if：线程可能在没有被 notify() 或 notifyAll() 的情况下被唤醒
                        //如果用if：假设当前状态state = 0，线程B调用wait()被阻塞
                        // 线程B被莫名其妙的唤醒，直接执行后续代码
                        try {
                            lock.wait();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.println(Thread.currentThread().getName()+letter);
                    state++;
                    lock.notifyAll();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread threadA = new Thread(new PrintTask("A", 0));
        Thread threadB = new Thread(new PrintTask("B", 1));
        Thread threadC = new Thread(new PrintTask("C", 2));

        threadA.start();
        threadB.start();
        threadC.start();
    }
}
