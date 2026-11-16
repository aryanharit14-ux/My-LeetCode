class Solution {
    public void solve(int index,int[] candidates,int target,List<Integer> current,List<List<Integer>> ans){
        if(target==0){
            ans.add(new ArrayList<>(current));
            return;
        }
        if(index==candidates.length) return;
        if(candidates[index]<=target){
            current.add(candidates[index]);
            solve(index,candidates,target-candidates[index],current,ans);
            current.remove(current.size()-1);
        }
        solve(index+1,candidates,target,current,ans);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        solve(0,candidates,target,new ArrayList<>(),ans);
        return ans;
    }
}