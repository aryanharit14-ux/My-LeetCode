class Solution {
    public int maxArea(int[][] mat) {
        int m = mat.length,n=mat[0].length;
        int[][] p = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                p[i+1][j+1] = mat[i][j]+p[i][j+1]+p[i+1][j]-p[i][j];
            }
        }
        int l = 1,r=Math.min(m,n),ans=0;
        while(l<=r){
            int k = (l+r)/2;
            if(check(p,m,n,k)){
                ans = k;
                l=k+1;
            }else{
                r=k-1;
            }
        }
        return ans*ans;
    }
    boolean check(int[][] p,int m,int n,int k){
        int minR = m,minC=n,maxR=-1,maxC=-1;
        for(int i=0;i<=m-k;i++){
            for(int j=0;j<=n-k;j++){
                int sum = p[i+k][j+k]-p[i][j+k]-p[i+k][j]+p[i][j];
                if(sum!=k*k) continue;
                minR = Math.min(minR,i);
                minC = Math.min(minC,j);
                maxR = Math.max(maxR,i);
                maxC = Math.max(maxC,j);
                if(maxR-minR>=k||maxC-minC>=k) return true;
            }
        }
        return false;
    }
}