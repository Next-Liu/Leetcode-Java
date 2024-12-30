package traceback;

import java.util.ArrayList;
import java.util.List;

public class Solution_216Combination {
    List<Integer> path = new ArrayList<>();
    List<List<Integer>> ans = new ArrayList<>();
    public void dfs(int i,int n,int k){
        if(path.size()== k && n==0){
            ans.add(new ArrayList<>(path));
            return;
        }
        for(int j = i;j>0;j--){
            path.add(j);
            dfs(j-1,n-j,k);
            path.remove(path.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        dfs(9,n,k);
        return ans;
    }

    public static void main(String[] args) {
        Solution_216Combination ss = new Solution_216Combination();
        ss.combinationSum3(3,9);
    }
}
