class Solution {
    public boolean isValid(String s) {
        var stack = new ArrayDeque<Character>();

        for (var c: s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                var open = stack.pop();

                if (c == ')' && open != '(' ||
                    c == '}' && open != '{' ||
                    c == ']' && open != '['
                ) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
