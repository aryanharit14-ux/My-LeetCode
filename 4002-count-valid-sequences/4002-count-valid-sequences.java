class Solution {
    static final int MOD = 1000000007;
    public int countValidSequences(int n, int k) {
        long[] fact = new long[n+1];
        long[] invfact = new long[n+1];
        fact[0] = 1;
        for(int i=1;i<=n;i++){
            fact[i] = fact[i-1] * i%MOD;
        }
        invfact[n] = pow(fact[n],MOD-2);
        for(int i=n;i>=1;i--){
            invfact[i-1] = invfact[i]*i % MOD;
        }
        long total = nCr(n-1,k-1,fact,invfact);
        long odd = 0;
        if((n-k) % 2==0){
            odd = nCr((n-k)/2+k-1,k-1,fact,invfact);
        }
        return(int)((total-odd+MOD)%MOD);
    }
    long nCr(int n,int r,long[] fact,long[] invfact){
        if(r<0 || r>n) return 0;
        return fact[n] * invfact[r] % MOD*invfact[n-r]%MOD;
    }
    long pow(long a,long b){
        long ans =1;
        while(b>0){
            if((b&1)==1){
                ans = ans*a%MOD;
            }
            a=a*a%MOD;
            b>>=1;
        }
        return ans;
    }
}