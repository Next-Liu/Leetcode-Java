package Graph;

import java.util.*;

public class TopologicalSorting {
    public static String findAlienOrder(String[] words){
        //图的建立
        HashMap<Character, Set<Character>> graph = new HashMap<>();
        //入度map
        HashMap<Character, Integer> inDegree = new HashMap<>();
        //入度map的初始化
        for(String word:words){
            for(char c:word.toCharArray()){
                if(!inDegree.containsKey(c)){
                    inDegree.put(c,0);
                }
            }
        }
        //构建入度map
        int length = words.length;
        for(int i = 0;i<length-1;i++){
            String s1 = words[i];
            String s2 = words[i+1];
            int len = Math.min(s1.length(),s2.length());
            for(int j = 0;j<len;j++){
                char c1 = s1.charAt(j);
                char c2 = s2.charAt(j);
                if(c1!=c2){
                    //若不存在c1->c2这条边
                    if(!graph.containsKey(c1)){
                        graph.put(c1,new HashSet<>());
                    }
                    if (!graph.get(c1).contains(c2)){
                        graph.get(c1).add(c2);
                        //更新入度map
                        inDegree.put(c2,inDegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        //拓扑排序
        LinkedList<Character> queue = new LinkedList<>();
        for (Map.Entry<Character,Integer> entry:inDegree.entrySet()){
            if (entry.getValue() == 0){
                queue.add(entry.getKey());
            }
        }
        StringBuilder res = new StringBuilder();
        while (!queue.isEmpty()){
            char c = queue.removeFirst();
            res.append(c);
            if (graph.containsKey(c)){
                Set<Character> characters = graph.get(c);
                for(char cc:characters){
                    inDegree.put(cc,inDegree.get(cc)-1);
                    if(inDegree.get(cc)==0){
                        queue.add(cc);
                    }
                }
            }
        }
        return new String(res);
    }
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        String order = findAlienOrder(words);
        System.out.println("字母序: " + order); // 输出: b d a c
    }

}
