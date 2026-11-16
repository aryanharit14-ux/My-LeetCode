class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] ans = new int[m+1][n+1];

        for(int i=0;i<=m;i++){
            ans[i][0] = i;
        }
        for(int j=0;j<=n;j++){
            ans[0][j] = j;
        }
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    ans[i][j] = ans[i-1][j-1];
                }else{
                    int insert = ans[i][j-1];
                    int delete = ans[i-1][j];
                    int replace = ans[i-1][j-1];

                    ans[i][j] = 1 + Math.min(insert,Math.min(delete,replace));
                }
            }
        }
        return ans[m][n];
    }
}