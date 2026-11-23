class Solution {
    public String decodeString(String s) {
        Stack<String> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(Character.isDigit(ch)){
                num = num*10 + (ch-'0');
            }else if(ch=='['){
                stack.push(curr.toString());
                stack.push(String.valueOf(num));
                curr = new StringBuilder();
                num = 0;
            }
            else if(ch == ']'){
                int repeat = Integer.parseInt(stack.pop());
                String prev = stack.pop();
                StringBuilder temp = new StringBuilder();
                for(int j=0;j<repeat;j++){
                    temp.append(curr);
                }
                curr = new StringBuilder(prev).append(temp);
            }else{
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}