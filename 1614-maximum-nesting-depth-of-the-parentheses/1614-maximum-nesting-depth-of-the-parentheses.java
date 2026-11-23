class Solution {
    public int maxDepth(String s) {
        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        int ans = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(ch);
                cnt++;
                ans = Math.max(cnt,ans);
            }else if(ch==')'){
                stack.pop();
                cnt--;
            }
        }
        return ans;
    }
}