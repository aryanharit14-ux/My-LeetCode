class Solution {
    public List<List<Integer>> aggregateTimeSeries(int[][] series1, int[][] series2) {
        List<List<Integer>> ans = new ArrayList<>();
        int i=0;
        int j=0;
        int n=series1.length;
        int m=series2.length;

        while(i<n || j<m){
            int t;
            if(j==m || (i<n && series1[i][0]<series2[j][0])){
                t = series1[i][0];
            }else if(i==n || series2[j][0]<series1[i][0]){
                t = series2[j][0];
            }else{
                t = series1[i][0];
            }
            int val1 = 0;
            int val2 = 0;
            if(i<n && series1[i][0]==t){
                val1 = series1[i][1];
            }else if(i<n){
                val1 = series1[i][1];
            }
            if(j<m && series2[j][0]==t){
                val2 = series2[j][1];
            }else if(j<m){
                val2 = series2[j][1];
            }
            ans.add(Arrays.asList(t,val1+val2));
            if(i<n && series1[i][0]==t){
                i++;
            }
            if(j<m && series2[j][0]==t)j++;
        }
        return ans;
    }
}