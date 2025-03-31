package test;

public class EditDistance {
    public class Student {
        int id;
        String name;
        Student(int id, String name){
            this.id = id;
            this.name = name;
        }
    }
    public int minDistance(String word1, String word2) {
        //dp[i][j]：将 s1 的前 i 个字符转换为 s2 的前 j 个字符所需的最少操作次数。
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=0;i<=m;i++)
            dp[i][0] = i;
        for(int j=0;j<=n;j++)
            dp[0][j] = j;
        //dp[i-1][j]：删除 s1[i-1]。
        //dp[i][j-1]：在 s1 中插入 s2[j-1]。
        //dp[i-1][j-1]：替换 s1[i-1] 为 s2[j-1]。
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j] = dp[i-1][j-1];
                else
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
            }
        }
        return dp[m][n];
    }
    public static void main(String[] args) {
        EditDistance editDistance = new EditDistance();
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(editDistance.minDistance(word1,word2));
    }
}
