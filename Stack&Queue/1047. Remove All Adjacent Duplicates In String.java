class Solution {
    public String removeDuplicates(String s) {
        // res is a stack
        // StringBuilder may also be used
        // StringBuilder res = new StringBuilder();
        StringBuffer res = new StringBuffer();
        // top is the index of the top element in the stack
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // when the stack is not empty and the top element is the same as the current character
            if (top >= 0 && res.charAt(top) == c) {
                res.deleteCharAt(top);
                top--;
            // otherwise, push the current character into the stack
            } else {
                res.append(c);
                top++;
            }
        }
        return res.toString();
    }
}
