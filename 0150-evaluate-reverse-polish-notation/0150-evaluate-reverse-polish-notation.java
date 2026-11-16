class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> ans = new Stack<>();
        for(String s:tokens){
            if(s.equals("+")|| s.equals("-")||s.equals("*")||s.equals("/")){
                int b = ans.pop();
                int a = ans.pop();
                switch(s){
                    case "+": 
                        ans.push(a+b);
                        break;
                    case "-":
                        ans.push(a-b);
                        break;
                    case "*": 
                        ans.push(a*b);
                        break;
                    case "/":
                        ans.push(a/b);
                        break;       
                }}else{
                    ans.push(Integer.parseInt(s));
                }
            }
            return ans.pop();
    }
}
