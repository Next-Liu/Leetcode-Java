package hashmap;

import java.util.*;

/**
 * @version 1.0
 * @auther 刘庆延
 * @email 2291572118@qq.com
 */
public class TestHashMap {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "apple", "orange", "banana", "apple");
        HashMap<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((e1,e2) ->{
           int freCount = e2.getValue().compareTo(e1.getValue());
           if (freCount == 0 ){
               return e1.getKey().compareTo(e2.getKey());
           }else {
               return freCount;
           }
        });

        if (!map.containsKey("apple")){
            map.put("apple",2);
        }else{
            map.put("apple",4);
        }
        // 打印排序后的结果
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

    }
}
