/**
 * Created by ziyaoli on 10/23/18.
 */
import java.util.*;

public class Formula {
    public static void main(String[] args) {
        System.out.println(new Formula().formula("Kg4(ON(SO3)2)2"));
    }

    private String formula(String s) {
        Deque<Pair> stack = new LinkedList<>();
        int i = 0;
        int len = s.length();
        while (i < len) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.offerLast(new Pair("(", 1));
                i++;
            } else if (c == ')') {
                int num = 0;
                int next = i + 1;
                while (next < len && s.charAt(next) <= '9' && s.charAt(next) >= '0') {
                    int cur = s.charAt(next) - '0';
                    num = num * 10 + cur;
                    next++;
                }
                if (num == 0) {
                    num = 1;
                }
                List<Pair> pairs = new ArrayList<>();
                while (!stack.peekLast().name.equals("(")) {
                    Pair cur = stack.pollLast();
                    pairs.add(cur);
                }
                stack.pollLast();
                for (Pair pair : pairs) {
                    pair.count *= num;
                    stack.offerLast(pair);
                }
                i = next;
            } else if (c >= 'A' && c <= 'Z') {
                StringBuilder sb = new StringBuilder();
                sb.append(c);
                int next = i + 1;
                while (next < len && s.charAt(next) >= 'a' && s.charAt(next) <= 'z') {
                    sb.append(s.charAt(next));
                    next++;
                }
                int num = 0;
                while (next < len && s.charAt(next) >= '0' && s.charAt(next) <= '9') {
                    int cur = s.charAt(next) - '0';
                    num = num * 10 + cur;
                    next++;
                }
                if (num == 0) {
                    num = 1;
                }
                stack.offerLast(new Pair(sb.toString(), num));
                i = next;
            }
        }

        Map<String, Integer> map = new TreeMap<>();
        while (!stack.isEmpty()) {
            Pair cur = stack.pollLast();
            if (map.containsKey(cur.name)) {
                map.put(cur.name, map.get(cur.name) + cur.count);
            } else {
                map.put(cur.name, cur.count);
            }
        }

       // for (Map.Entry<String, Integer> entry : map.entrySet()) {
        //    System.out.println(entry.getKey() + " " + entry.getValue());
        //}
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            result.append(entry.getKey());
            result.append(entry.getValue());
        }
        return result.toString();
    }

    class Pair {
        String name;
        int count;

        Pair(String s, int c) {
            name = s;
            count = c;
        }
    }
}
