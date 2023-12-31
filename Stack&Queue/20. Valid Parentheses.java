class Solution {
    public boolean isValid(String s) {
        if((s.length() & 1) == 1)
        return false;
        Deque<Character> stack = new LinkedList<Character>();
        for(char c : s.toCharArray()){
            if(c == '(') stack.push(')');
            else if(c == '{') stack.push('}');
            else if(c == '[') stack.push(']');
            else if(stack.isEmpty() || stack.pop() != c) return false;
        }
        return stack.isEmpty();
    }
}
