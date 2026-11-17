class Solution {
    public int minDays(int n) {
        int[] dp = new int[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = -1;
        for(int score = 1;score<=n;score++){
            int points = 0;
            for(int streak = 1;;streak++){
                points+=streak;
                if(points>score){
                    break;
                }
                if(dp[score-points]!=Integer.MAX_VALUE){
                    dp[score] = Math.min(dp[score],dp[score-points]+streak+1);
                }
            }
        }
        return dp[n];
    }
}