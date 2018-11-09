/**
 * Created by ziyaoli on 10/24/18.
 */
import java.util.*;
import java.util.prefs.BackingStoreException;

public class BasicCalculator {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new BasicCalculator().calculate(s));
    }

    private int calculate(String s) {
        Deque<String> stack = new LinkedList<>();
        int i = 0;
        int len = s.length();
        StringBuilder number = new StringBuilder();

        while (i < len) {
            char c = s.charAt(i);
            if (c == '(' || c == '+' || c == '-') {
                stack.offerLast(Character.toString(c));
                i++;
            } else if (c == ' ') {
                i++;
            } else if (c == ')') {
                String cur = stack.pollLast();
                int right = Integer.parseInt(cur);
                stack.pollLast();
                if (stack.peekLast() == null) { //just push value
                    stack.offerLast(cur);
                } else {
                    String operator = stack.pollLast();
                    int left = Integer.parseInt(stack.pollLast());
                    if (operator.equals("+")) {
                        stack.offerLast(Integer.toString(left + right));
                    } else {
                        stack.offerLast(Integer.toString(left - right));
                    }
                }
                i++;
            } else {
                number.append(c);
                int next = i + 1;
                while (next < len) {
                    if (s.charAt(next) == ' ') {
                        next++;
                    } else if (s.charAt(next) <= '9' && s.charAt(next) >= '0') {
                        number.append(s.charAt(next));
                        next++;
                    } else {
                        break;
                    }
                }
                i = next;
                int right = Integer.parseInt(number.toString());
                number.setLength(0);
                if (stack.peekLast() == null || stack.peekLast().equals("(")) { //just push value
                    stack.offerLast(Integer.toString(right));
                } else {
                    String operator = stack.pollLast();
                    int left = Integer.parseInt(stack.pollLast());
                    if (operator.equals("+")) {
                        stack.offerLast(Integer.toString(left + right));
                    } else {
                        stack.offerLast(Integer.toString(left - right));
                    }
                }
            }
        }
        //System.out.println("finishing");
        return Integer.parseInt(stack.peekLast());
    }
}
