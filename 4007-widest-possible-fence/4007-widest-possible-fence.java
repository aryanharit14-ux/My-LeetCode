class Solution {
    public int maximumWidth(int[] planks) {
        HashMap<Integer,Integer> freq = new HashMap<>();
        for(int x:planks){
            freq.put(x,freq.getOrDefault(x,0)+1);
        }
        ArrayList<Integer> vals = new ArrayList<>(freq.keySet());
        HashMap<Integer,Integer> width = new HashMap<>();
        int m = vals.size();
        for(int i=0;i<m;i++){
            int a = vals.get(i);
            int fa = freq.get(a);
            for(int j=i;j<m;j++){
                int b = vals.get(j);
                int fb = freq.get(b);
                int sum = a+b;
                int add;
                if(i==j) {
                    add = fa/2;
                }else{
                    add = Math.min(fa,fb);
                }
                width.put(sum,width.getOrDefault(sum,0)+add);
            }
        }
        int ans = 1;
        for(int h:vals){
            int cur = freq.get(h)+width.getOrDefault(h,0);
            ans = Math.max(ans,cur);
        }
        for(int x:width.values()){
            ans = Math.max(ans,x);
        }
        return ans;
    }
}