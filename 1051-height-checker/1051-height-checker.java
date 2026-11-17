class Solution {
    public int heightChecker(int[] heights) {
        int n = heights.length;
        int[] res = new int[n];
        for(int i=0;i<n;i++){
            res[i] = heights[i];
        }
        for(int i=0;i<n-1;i++){
            for(int j=i+1;j<n;j++){
                if(res[i]>res[j]){
                    int temp = res[i];
                    res[i] = res[j];
                    res[j] = temp;
                }
            }
        }
        int cnt = 0;
        for(int i=0;i<n;i++){
            if(res[i]!=heights[i]) cnt++;
        }
        return cnt;
    }
}