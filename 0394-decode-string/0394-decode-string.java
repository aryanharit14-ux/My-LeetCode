class Solution {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strs = new Stack<>();
        StringBuilder curr = new StringBuilder();
        int num = 0;

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                num = num * 10 + ch - '0';
            } 
            else if (ch == '[') {
                nums.push(num);
                strs.push(curr);
                curr = new StringBuilder();
                num = 0;
            } 
            else if (ch == ']') {
                StringBuilder temp = strs.pop();
                int count = nums.pop();

                while (count-- > 0) temp.append(curr);
                curr = temp;
            } 
            else {
                curr.append(ch);
            }
        }
        return curr.toString();
    }
}