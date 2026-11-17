class Solution {
    public int countSpecialIntegers(int[] nums) {
        HashMap<Integer,ArrayList<Integer>> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            map.putIfAbsent(nums[i],new ArrayList<>());
            map.get(nums[i]).add(i);
        }
        int count = 0;
        for(ArrayList<Integer> indices:map.values()){
            if(indices.size()<3){
                continue;
            }
            int gap = indices.get(1)-indices.get(0);
            boolean special = true;
            for(int j=2;j<indices.size();j++){
                if(indices.get(j)-indices.get(j-1)!=gap){
                    special = false;
                    break;
                }
            }
            if(special){
                count++;
            }
        }
        return count;
    }
}