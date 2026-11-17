class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        long[] a = new long[n];
        for(int i=0;i<n;i++){
            a[i] = (long) nums[i]*nums[i];
        }
        Arrays.sort(a);
        long score = 0;
        for(int i=0;i<n;i++){
            if(i<n/2) score-= a[i];
            else score+= a[i];
        }
        return score;
    }
}