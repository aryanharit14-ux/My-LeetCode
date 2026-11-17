class Solution {
    public long elevatorRequests(int n, int start, int[][] requests) {
        int m = requests.length;
        int s = 1<<m;
        long inf = Long.MAX_VALUE/4;
        long[][] dp = new long[s][m];
        for (long[]a:dp) Arrays.fill(a,inf);
        for(int i=0;i<m;i++){
            long t = Math.abs((long)start-requests[i][1]);
            t = Math.max(t,(long)requests[i][0]);
            int mask = 0;
            for(int j=0;j<m;j++){
                if(requests[j][1]==requests[i][1]&&
                   requests[j][0]<=t) mask|=1<<j;
            }
            dp[mask][i] = Math.min(dp[mask][i],t);
        }
        for(int mask = 0;mask<s;mask++){
            for(int i=0;i<m;i++){
                if(dp[mask][i]==inf) continue;
                for(int j=0;j<m;j++){
                    if((mask&(1<<j))!=0) continue;
                    long t = dp[mask][i] +Math.abs((long)requests[i][1]-requests[j][1]);
                    t=Math.max(t,(long)requests[j][0]);
                    int nm  = mask;
                    for(int k=0;k<m;k++){
                        if(requests[k][1]==requests[j][1] &&requests[k][0]<=t) nm |= 1<<k;
                    }
                    dp[nm][j]=Math.min(dp[nm][j],t);
                }
            }
        }
        long ans = inf;
        for(int i=0;i<m;i++) ans = Math.min(ans,dp[s-1][i]);
        return ans;
    }
}