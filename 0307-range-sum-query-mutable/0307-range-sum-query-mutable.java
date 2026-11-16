class NumArray {

    int[] nums;
    int[] tree;
    int n;

    public NumArray(int[] nums) {
        this.nums = nums;
        n=nums.length;
        tree = new int[n+1];
        for(int i=0;i<n;i++){
            updateBIT(i+1,nums[i]);
        }
    }

    public void updateBIT(int index,int delta){
        while(index<=n){
            tree[index]+=delta;
            index+=index&(-index);
        }
    }

    private int query(int index){
        int sum = 0;
        while(index>0){
            sum+=tree[index];
            index-=index&-index;
        }
        return sum;
    }
    
    public void update(int index, int val) {
        int delta = val-nums[index];
        nums[index]=val;
        updateBIT(index+1,delta);
    }
    
    public int sumRange(int left, int right) {
        return query(right+1)-query(left);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */