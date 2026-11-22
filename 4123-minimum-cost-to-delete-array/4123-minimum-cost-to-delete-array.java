class Solution {
    public long minCost(int[] nums) {
        int n = nums.length;
        long baseCost = (long) nums[0]+nums[n-1];
        long closed = 0;
        long open = Long.MAX_VALUE/2;
        for(int i=1;i<n-1;i++){
            long nextClosed = Math.min(closed,open+nums[i]);
            long nextOpen = Math.min(open,closed+nums[i]);
            closed = nextClosed;
            open = nextOpen;
        }
        return baseCost + closed;
    }
}