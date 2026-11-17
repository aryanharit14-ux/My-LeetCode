class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n];

        Arrays.fill(ans,-1);
        
        int windowsize = 2*k + 1;
        if(windowsize>n)
            return ans;

        long sum = 0;

        for(int i=0;i<windowsize;i++){
            sum+=nums[i];
        }

        ans[k] = (int)(sum/windowsize);

        for(int right = windowsize;right<n;right++){
            sum-= nums[right-windowsize];
            sum+=nums[right];
            ans[right-k] = (int)(sum/windowsize);
        }
        return ans;
        
    }
}