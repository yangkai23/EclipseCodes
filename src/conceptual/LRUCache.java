package conceptual;

import java.util.LinkedHashMap;

public class LRUCache  {
    public static void main(String[] args) {
        LinkedHashMap<Integer,String> lruCache=new LinkedHashMap<>(8,0.5f,true);
        lruCache.put(2,"b");
        lruCache.put(3,"c");
        System.out.println(lruCache);
        lruCache.put(1,"c");
        System.out.println(lruCache);
        System.out.println(lruCache.get(2));
        System.out.println(lruCache);

    }
}
