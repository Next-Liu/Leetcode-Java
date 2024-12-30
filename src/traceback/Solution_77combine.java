package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_77combine {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    int k;
    public void dfs(int i){
        if(path.size() == k){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = i;j>0;j--){
            path.add(j);
            dfs(j-1);
            path.remove(path.size()-1);
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        this.k = k;
        dfs(n);
        return ans;
    }
}
