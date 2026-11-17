class Solution {
    class Fenwick{
        int[] bit;
        int n;
        Fenwick(int n){
            this.n=n;
            bit = new int[n+2];
        }
        void update (int index,int value){
            while(index<=n){
                bit[index]+=value;
                index+=index&-index;
            }
        }
        int query(int index){
            int sum=0;
            while(index>0){
                sum+=bit[index];
                index-=index&-index;
            }
            return sum;
        }
    }
        
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;
        long[] value  = new long[n+1];
        int even = 0;
        int odd = 0;
        value[0] = 0;
        for(int i=0;i<n;i++){
            if((nums[i]&1)==0) even++;
            else odd++;
            value[i+1] = 1L * even*b-1L*odd*a;
        }
        long[] sorted = value.clone();
        Arrays.sort(sorted);
        HashMap<Long,Integer> map = new HashMap<>();
        int rank = 1;
        for(long x:sorted){
            if(!map.containsKey(x)){
                map.put(x,rank++);
            }
        }
        Fenwick bit  = new Fenwick(rank+2);
        long ans = 0;
        for(int i=0;i<=n;i++){
            int r = map.get(value[i]);
            ans+= bit.query(rank)-bit.query(r-1);
            bit.update(r,1);
        }
        return ans;
    }
}