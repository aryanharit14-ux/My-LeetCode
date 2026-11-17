class SnapshotArray {

    List<int[]>[] ans ;
    int SnapID;

    public SnapshotArray(int length) {
        ans = new ArrayList[length];
        for(int i=0;i<length;i++){
            ans[i] = new ArrayList<>();
            ans[i].add(new int[]{0,0});
        }
        SnapID = 0;
    }
    
    public void set(int index, int val) {
        List<int[]> list = ans[index];
        if(list.get(list.size()-1)[0]==SnapID){
            list.get(list.size()-1)[1] = val;
        }else{
            list.add(new int[]{SnapID,val});
        }
    }
    
    public int snap() {
        return SnapID++;
    }
    
    public int get(int index, int snap_id) {
        List<int[]> list = ans[index];
        int left = 0;
        int right = list.size()-1;
        while(left<=right){
            int mid = left+(right-left)/2;
            if(list.get(mid)[0]<=snap_id){
                left=mid+1;
            }else{
                right = mid-1;
            }
        }
        return list.get(right)[1];
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */