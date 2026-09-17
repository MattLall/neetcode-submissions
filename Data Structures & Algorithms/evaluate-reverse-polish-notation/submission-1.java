class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String s : tokens) {
            if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                calc(stack, s);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }
        return (stack.pop());
    }

    public void calc(Stack<Integer> stack, String op) {
        int right = stack.pop();
        int left = stack.pop();

        stack.push(switch (op) {
            case "+" -> (left + right);
            case "-" -> (left - right);
            case "*" -> (left* right);
            case "/" -> (left / right);
            default -> 0;
        });
    }
}
