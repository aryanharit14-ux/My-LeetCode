class Solution {
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n =tasks.length;
        int m = shifts.length;
        long[] prefix = new long[n];
        prefix[0] = tasks[0];
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+tasks[i];
        }
        long total = prefix[n-1];
        long done = 0;
        int[] ans = new int[m];
        for(int i=0;i<m;i++){
            done+=shifts[i];
            if(done>=total){
                ans[i]=0;
                done = 0;
                continue;
            }
            int l=0;
            int r = n-1;
            while(l<r){
                int mid = l+(r-l)/2;
                if(prefix[mid]>done){
                    r=mid;
                }else{
                    l=mid+1;
                }
            }
            ans[i]=n-l;
        }
        return ans;
    }
}