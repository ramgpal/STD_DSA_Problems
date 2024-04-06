import java.util.*;

public class PS3 {

    public static int pageFaults(int[] pages, int n, int c) {
        HashSet<Integer> set = new HashSet<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        int pageFaults = 0;
        for (int i = 0; i < n; i++) {
            int page = pages[i];

            if (!set.contains(page)) {
                pageFaults++;

                if (set.size() == c) {
                    int leastRecentlyUsed = map.entrySet().iterator().next().getKey();
                    map.remove(leastRecentlyUsed);
                    set.remove(leastRecentlyUsed);
                }
                set.add(page);
            } else {
                map.remove(page);
            }
            map.put(page, i);
        }

        return pageFaults;
    }

    public static void main(String[] args) {
        int[] pages = { 5, 0, 1, 3, 2, 4, 1, 0, 5};
        int n = 9;
        int capacity = 4;

        int faults = pageFaults(pages, n, capacity);
        System.out.println("Total page faults using LRU page replacement algorithm: " + faults);
    }
}

