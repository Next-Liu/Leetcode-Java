package LinkedList;

import java.util.*;

public class Solution_49groupAnagrams {
    /**
     * 给你一个字符串数组，请你将 字母异位词 组合在一起。可以按任意顺序返回结果列表。
     * 字母异位词 是由重新排列源单词的所有字母得到的一个新单词。
     * 输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出: [["bat"],["nat","tan"],["ate","eat","tea"]]
     * @param strs
     * @return
     */
    List<List<String>> ans = new ArrayList<>();
    HashMap<String,List<String>> hashMap = new HashMap<>();
    String ss = new String();
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length==0){
            return ans;
        }
        if (strs.length==1){
            List<String> temp = new ArrayList<>();
            temp.add(strs[0]);
            ans.add(temp);
            return ans;
        }
        for (String string:strs){
            char[] c = string.toCharArray();
            Arrays.sort(c);
            String s = new String(c);
            if(!hashMap.containsKey(s)){
                List<String> temp = new ArrayList<>();
                temp.add(string);
                hashMap.put(s,temp);
            }else{
                hashMap.get(s).add(string);
            }
        }
        for(Map.Entry<String,List<String>>entry:hashMap.entrySet()){
            ans.add(entry.getValue());
        }
        return ans;
    }
}
