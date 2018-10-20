/**
 * Created by ziyaoli on 10/20/18.
 */
import java.util.*;
public class Tmp {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Bob", 3);
        map.put("Cat", 2);
        map.put("Dog", 4);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
