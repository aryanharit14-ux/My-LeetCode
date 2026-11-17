class Solution {
    public String shiftingLetters(String s, int[][] shifts) {
        int n = s.length();
        int[] diff = new int[n+1];
        for(int[] q:shifts ){
            int val = q[2] == 1 ? 1:-1;
            diff[q[0]]+=val;
            diff[q[1]+1]-=val;
        }
        char[] arr = s.toCharArray();
        int shift = 0;
        for(int i=0;i<n;i++){
            shift+=diff[i];
            int x = (arr[i]-'a'+shift)%26;
            if(x<0){
                x+=26;
            }
            arr[i]=(char)(x+'a');
        }
        return new String(arr);

    }
}