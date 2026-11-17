class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int[] indexes = new int[k];
        boolean[] used = new boolean[nums.length];
        int[] ans = new int[k];
        for(int i=0;i<k;i++){
            int max = Integer.MIN_VALUE;
            int index = -1;
            for(int j=0;j<nums.length;j++){
                if(!used[j] && nums[j]>max){
                    max = nums[j];
                    index = j;
                }
            }
            indexes[i] = index;
            used[index] = true;
        }
        for(int i=0;i<k-1;i++){
            for(int j=0;j<k-i-1;j++){
                if(indexes[j]>indexes[j+1]){
                    int temp = indexes[j];
                    indexes[j] = indexes[j+1];
                    indexes[j+1] = temp;
                }
            }
        }
        for(int i=0;i<k;i++){
            ans[i] = nums[indexes[i]];
        }
        return ans;
    }
}