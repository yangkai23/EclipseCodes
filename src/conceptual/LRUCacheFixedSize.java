package conceptual;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheFixedSize<k, v> extends LinkedHashMap {
    public LRUCacheFixedSize(int size, float loadFactor, boolean cache) {
        super(size, loadFactor, cache);
    }

    public static void main(String[] args) {
        Map<Integer, String> lru = new LRUCacheFixedSize<>(3, 0.5f, true);
        lru.put(2, "b");
        lru.put(3, "c");
        System.out.println(lru);
        lru.put(1, "a");
        System.out.println(lru);
        System.out.println(lru.get(2));
        System.out.println(lru);
        lru.put(4, "d");
        System.out.println(lru);
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > 3;
    }
}
