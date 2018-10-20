/**
 * Created by ziyaoli on 10/20/18.
 */
import java.util.*;
public class SortMapByValue {
    public static void main(String[] args) {
        Map<String, Integer> map = new TreeMap<>();
        map.put("banana", 3);
        map.put("tree", 9);
        map.put("dog", -8);
        map.put("king", 0);
        map.put("cat", 2);

        System.out.println("Default: sort by key:");
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        Comparator<Map.Entry<String, Integer>> valueComparator = new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if (o1.getValue() == o2.getValue()) {
                    return 0;
                }
                return o1.getValue() < o2.getValue() ? -1 : 1;
            }
        };

        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        Collections.sort(list, valueComparator);

        System.out.println("Sort by value in increasing order:");
        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
