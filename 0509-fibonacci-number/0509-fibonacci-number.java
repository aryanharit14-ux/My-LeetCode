class Solution {
    public int fib(int n) {
        int[] arr = new int[n+1];
        Arrays.fill(arr,-1);
        return fibb(n,arr);
    }
    static int fibb(int n,int[] arr){
        if(n==0 || n==1) return n;
        if(arr[n]!= -1) return arr[n];
        arr[n] = fibb(n-1,arr)+fibb(n-2,arr);
        return arr[n];
    }
}