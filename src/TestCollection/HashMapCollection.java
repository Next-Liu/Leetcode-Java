package TestCollection;

import java.util.*;

public class HashMapCollection {
    public static void main(String[] args){
        HashMap<String,Integer> hashMap = new HashMap<String,Integer>();
        hashMap.put("a",1);
        hashMap.put("b",4);
        hashMap.put("c",3);
        hashMap.put("d",2);
        // 将 HashMap 转换为 List
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(hashMap.entrySet());

        // 按 value 排序
        Collections.sort(entryList, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        System.out.println(entryList);

        // 转回 LinkedHashMap 保持排序后的顺序
        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : entryList) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        System.out.println(sortedMap);
    }
}
