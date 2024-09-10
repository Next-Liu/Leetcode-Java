/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
import java.util.Collections;
import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;

// 定义一个任务类
class Task implements Comparable<Task> {
    private String name;
    private int priority;

    public Task(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }

    public String getName() {
        return name;
    }

    public int getPriority() {
        return priority;
    }

    // 实现 Comparable 接口，用于自然顺序排序
    @Override
    public int compareTo(Task other) {
        return Integer.compare(this.priority, other.priority);//
    }
}

public class PriorityBlockingQueueExample {
    public static void main(String[] args) {
        // 创建一个 Comparator 对象来指定排序规则
        Comparator<Task> taskComparator = Comparator.comparing(Task::getPriority);

        // 创建 PriorityBlockingQueue，并传入 Comparator 对象
        PriorityBlockingQueue<Task> priorityQueue = new PriorityBlockingQueue<>(10, taskComparator);

        // 添加任务到队列
        priorityQueue.add(new Task("Task1", 3));
        priorityQueue.add(new Task("Task2", 1));
        priorityQueue.add(new Task("Task3", 2));

        // 从队列中取出任务，按照优先级顺序
        while (!priorityQueue.isEmpty()) {
            Task task = priorityQueue.poll();
            System.out.println("Processing task: " + task.getName() + " with priority: " + task.getPriority());
        }
    }
}

