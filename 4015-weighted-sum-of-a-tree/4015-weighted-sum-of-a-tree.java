class Solution {
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        int[] depth = new int[n];
        int h = 0;
        for(int i=0;i<n;i++){
            int x=i,d=0;
            while(x!=-1&&depth[x]==0){
                d++;
                x=parent[x];
            }
            if(x!=-1) d+= depth[x];
            x=i;
            while(x!=-1&& depth[x]==0){
                depth[x] = d--;
                x = parent[x];
            }
            h = Math.max(h,depth[i]);
        }
        long ans = 0;
        for(int i=0;i<n;i++){
            ans+=(long)nums[i]*(h-depth[i]+1);
        }
        return ans;
    }
}