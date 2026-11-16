class Solution {
    public void solve(int[] nums, boolean[] used,List<Integer>current,List<List<Integer>>ans){
        if(current.size()==nums.length){
            ans.add(new ArrayList<>(current));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(used[i]) continue;
            used[i]=true;
            current.add(nums[i]);
            solve(nums,used,current,ans);
            current.remove(current.size()-1);
            used[i]=false;
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        boolean[] used  = new boolean[nums.length];
        solve(nums,used,new ArrayList<>(),ans);
        return ans; 
    }
}