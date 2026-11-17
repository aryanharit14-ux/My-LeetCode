class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        int[] first = new int[k];
        int[] best = new int[k];
        int[] ptr  = new int[k];
        int[] order = new int[k];
        for(int i=0;i<k;i++){
            first[i] = -1;
            best[i] = Integer.MAX_VALUE;
        }
        first[0] = 0;
        order[0] = 0;
        int cnt = 1;
        int sum = 0;
        for(int r=0;r<n;r++){
            int x = nums[r]%k;
            if(x<0)x+=k;
            int q = (2*x) %k;
            while(ptr[q]<cnt && first[order[ptr[q]]]<=r){
                int p = order[ptr[q]++];
                int rem  = (p+q) %k;
                if(first[p]<best[rem]) best[rem] = first[p];
            }
            sum = (sum+x)%k;
            if(first[sum]!=-1){
                ans = Math.max(ans,r+1-first[sum]);
            }
            if(best[sum]!=Integer.MAX_VALUE){
                ans = Math.max(ans,r+1-best[sum]);
            }
            if(first[sum]==-1){
                first[sum]=r+1;
                order[cnt++] = sum;
            }
        }
        return ans;
    }
}