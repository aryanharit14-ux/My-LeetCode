class Solution {
    public int kthDigit(long k) {
        if(k<=9) return (int)k;
        k-=9;
        long digits = 2;
        long start = 1;
        long count = 9;
        while(k>digits*count*10){
            k-= digits*count*10;
            digits++;
            start*=10;
            count*=10;
        }
        long block = start+(k-1)/(digits*10);
        long pos = (k-1) % (digits*10);
        long offset = pos/digits;
        long num;
        if(block%2==0){
            num = (block*10) + offset;
        }else{
            num = (block*10)+9-offset;
        }
        int index = (int)(pos%digits);
        String s = String.valueOf(num);
        return s.charAt(index)-'0';
    }
}