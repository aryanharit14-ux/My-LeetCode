class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int m = matrix[0].length;
        int l = matrix[0][0];
        int r = matrix[n-1][m-1];
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            int count = countLessEqual(matrix,mid);
            if(count>=k){
                ans = mid;
                r = mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
    public int countLessEqual(int[][] matrix,int mid){
        int n = matrix.length;
        int m = matrix[0].length;
        int row = n-1;
        int col = 0;
        int count = 0;
        while(row>=0&&col<m){
            if(matrix[row][col]<=mid){
                count+=(row+1);
                col++;
            }else{
                row--;
            }
        }
        return count;
    }
}