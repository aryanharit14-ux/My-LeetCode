class Solution {
    public List<Integer> findMissingElements(int[] nums) {
        int minimum = 100;
        int maximum = 0;
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            minimum = Math.min(minimum,num);
            maximum = Math.max(maximum,num);
            set.add(num);
        }
        List<Integer> ans = new ArrayList<>();
        for(int i=minimum+1;i<maximum;i++){
            if(!set.contains(i)){
                ans.add(i);
            }
        }
        return ans;
    }
}