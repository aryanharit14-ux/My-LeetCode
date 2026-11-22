class Solution {
    public int countDominantElements(int[] nums) {
        int n = nums.length;
        if(n==1) return 1;
        int cnt = 0;
        for(int i=0;i<n;i++){
            int sum = 0;
            int neighbors = 0;
            if(i>0){
                sum+= nums[i-1];
                neighbors++;
            }
            if(i<n-1){
                sum+= nums[i+1];
                neighbors++;
            }
            if(nums[i]*neighbors >= sum) cnt ++;
        }
        return cnt;
    }
}