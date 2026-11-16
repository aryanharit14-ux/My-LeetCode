class Solution {
    public int jump(int[] nums) {
        int jumps=0;
        int currentEnd=0;
        int Farthest=0;
        for(int i=0;i<nums.length-1;i++){
            Farthest=Math.max(Farthest,i+nums[i]);
            if(i==currentEnd){
                jumps++;
                currentEnd=Farthest;
            }
        }
        return jumps;
    }
}