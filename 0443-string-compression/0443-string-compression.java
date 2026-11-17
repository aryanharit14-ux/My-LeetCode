class Solution {
    public int compress(char[] chars) {
        int index = 0;
        int i=0;
        int n = chars.length;
        while(i<n){
            char curr = chars[i];
            int cnt = 0;
            while(i<n && chars[i]==curr){
                i++;
                cnt++;
            }
            chars[index++] = curr;
            if(cnt>1){
                for(char c:String.valueOf(cnt).toCharArray()){
                    chars[index++] = c;
                }
            }
        }
        return index;
    }
}