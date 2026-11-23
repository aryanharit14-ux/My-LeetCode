class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        int score = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(score);
                score = 0;
            }else{
                int prev = stack.pop();
                if(score==0){
                    score = prev+1;
                }else{
                    score = prev+(2*score);
                }
            }
        }
        return score;
    }
}