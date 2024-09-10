import java.util.ArrayList;
import java.util.List;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class TestArrayList {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        System.out.println("list.size() = " + list.size());
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }
        System.out.println("list.size() = " + list.size());
    }
}
