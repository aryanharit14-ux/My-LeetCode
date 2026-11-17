class Solution {
    public String shiftingLetters(String s, int[] shifts) {
        char[] arr = s.toCharArray();
        long suffix = 0;
        for(int i=shifts.length-1;i>=0;i--){
            suffix = (suffix+shifts[i])%26;
            int x = (arr[i]-'a'+(int)(suffix))%26;
            arr[i] = (char)(x+'a');
        }
        return new String(arr);
    }
}