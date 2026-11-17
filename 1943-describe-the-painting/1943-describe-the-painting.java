class Solution {
    public List<List<Long>> splitPainting(int[][] segments) {
        TreeMap<Integer,Long> diff = new TreeMap<>();
        for(int[] seg:segments){
            diff.put(seg[0],diff.getOrDefault(seg[0],0L)+seg[2]);
            diff.put(seg[1],diff.getOrDefault(seg[1],0L)-seg[2]);
        }
        List<List<Long>> ans = new ArrayList<>();
        long colorSum = 0;
        int prev =-1;
        for(Map.Entry<Integer,Long> entry:diff.entrySet()){
            int curr = entry.getKey();

            if(prev!=-1 && colorSum >0){
                ans.add(Arrays.asList((long) prev,(long) curr,colorSum));
            }
            colorSum+=entry.getValue();

            prev = curr;
        }
        return ans;
    }
}