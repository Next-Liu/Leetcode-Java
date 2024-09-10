import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class TestHashMap {
    public static void main(String[] args) {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("0", "0");
        hashMap.put("1", "1");
        hashMap.put("2", "2");
        hashMap.put("3", "3");
        hashMap.put("4", "4");
        // hashMap.put(null, null);
        hashMap.put("5", "5");
        //计算hashMap的长度
        System.out.println("hashMap.size() = " + hashMap.size());
        for (String s : hashMap.keySet()) {
            System.out.println("s = " + s);
        }
        Collections.synchronizedMap(hashMap);
        Iterator<Map.Entry<String, String>> iterator = hashMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> next = iterator.next();
            System.out.print("next.getKey() = " + next.getKey());
            System.out.println(" next.getValue() = " + next.getValue());
        }
        Map.Entry<String, String> max = Collections.max(hashMap.entrySet(), (o1, o2) -> o1.getKey().compareTo(o2.getKey()));
        System.out.println("max.getKey() = " + max.getKey());
    }
}
