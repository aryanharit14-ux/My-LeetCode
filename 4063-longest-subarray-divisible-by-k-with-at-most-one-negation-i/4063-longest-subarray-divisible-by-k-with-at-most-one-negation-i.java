class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for(int l=0;l<n;l++){
            long sum = 0;
            HashSet<Integer> set = new HashSet<>();
            for(int r=l;r<n;r++){
                sum+=nums[r];
                int rem = (int)((sum%k+k)%k);
                int x = (int)((2L*nums[r]%k+k)%k);
                set.add(x);
                if(rem==0 || set.contains(rem)){
                    ans = Math.max(ans,r-l+1);
                }
            }
        }
        return ans;
    }
}