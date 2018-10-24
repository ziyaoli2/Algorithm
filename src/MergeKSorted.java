/**
 * Created by ziyaoli on 10/23/18.
 */
import java.util.*;
public class MergeKSorted {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(new Integer[] {1,3,5,7,9});
        List<Integer> l2 = Arrays.asList(new Integer[] {2,4,6,8,10});
        List<Integer> l3 = Arrays.asList(new Integer[] {2,4,6,8,10});
        List<Integer> l4 = Arrays.asList(new Integer[] {0,0,0,0,0});
        List<Integer> l5 = Arrays.asList(new Integer[] {-2,-1,20,30,40});
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        lists.add(l4);
        lists.add(l5);

        //List<Integer> l = Arrays.asList(new Integer[] {2,3,4,5,6});
        System.out.println(new MergeKSorted().mergeKSorted(lists));
    }

    private List<Integer> mergeKSorted(List<List<Integer>> lists) {
        int len = lists.size();
        while (len > 0) {
            for (int i = 0; i < len / 2; i++) {
                System.out.println("is " + i + " " + len);
                lists.set(i, merge(lists.get(i), lists.get(len - i - 1)));
            }
            len /= 2;
        }
        return lists.get(0);
    }

    private List<Integer> merge(List<Integer> a, List<Integer> b) {
        int x = 0;
        int y = 0;
        List<Integer> cur = new ArrayList<>();

        while (x < a.size() && y < b.size()) {
            if (a.get(x) <= b.get(y)) {
                cur.add(a.get(x++));
            } else {
                cur.add(b.get(y++));
            }
        }

        while (x < a.size()) {
            cur.add(a.get(x++));
        }

        while (y < b.size()) {
            cur.add(b.get(y++));
        }

        return cur;
    }
}
