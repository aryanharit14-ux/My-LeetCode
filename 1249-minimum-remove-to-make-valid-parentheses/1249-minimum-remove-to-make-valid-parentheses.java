class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder result = new StringBuilder(s);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
                stack.push(i);
            }else if(ch==')'){
                if(!stack.isEmpty()){
                    stack.pop();
                }else{
                    result.setCharAt(i,'*');
                }
            }
        }
        while(!stack.isEmpty()){
            result.setCharAt(stack.pop(),'*');
        }
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<result.length();i++){
            if(result.charAt(i)!='*'){
                ans.append(result.charAt(i));
            }
        }
        return ans.toString();
    }
}