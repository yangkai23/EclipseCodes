package hashtable;

import java.util.Arrays;

public class HashTable {
    private MyEntry[] hashArray;

    public HashTable(int initCap) {
        hashArray = new MyEntry[initCap];
    }

    public static void main(String[] args) {
        HashTable table = new HashTable(4);
        table.put(1, "Ani");
        table.put(2, "Hrushikesh");
        table.put(3, "Vishnu");
        table.put(11, "Revanth");
        table.put(15, "Tarun");
        table.printHashTable();
        System.out.println(table.get(2));
        System.out.println(table.get(11));
        System.out.println(table.get(31));
    }

    public int hash(int key) {
        return key % hashArray.length;
    }

    public boolean isOccupied(int key) {
        return hashArray[hash(key)] != null;
    }

    public void put(int key, String name) {
        int hashedKey = hash(key), stopIndex = hashedKey;
        MyEntry entry = MyEntry.valueOf(key, name);
        if (!isOccupied(hashedKey)) {
            hashArray[hashedKey] = entry;
            return;
        } else {
            if (hashedKey == hashArray.length - 1) hashedKey = 0;
            else hashedKey++;
        }

        while (hashedKey != stopIndex && isOccupied(hashedKey)) {
            hashedKey = (hashedKey + 1) % hashArray.length;
        }
        System.out.println(hashedKey);
        if (!isOccupied(hashedKey)) hashArray[hashedKey] = entry;
        else System.out.println("already occupied");

    }

    public String get(int key) {
        int hashedKey = hash(key), stopIndex = hashedKey;
        if (hashArray[hashedKey].key == key) return hashArray[hashedKey].name;
        if (hashedKey == hashArray.length - 1) hashedKey = 0;
        else hashedKey++;
        while (hashedKey != stopIndex) {
            if (!isOccupied(hashedKey)) continue;
            if (hashArray[hashedKey].key == key) return hashArray[hashedKey].name;
            hashedKey = (hashedKey + 1) % hashArray.length;
        }
        return "Key not present";
    }

    public String remove(int key) {
        int hashedKey = findKey(key);
        if (hashedKey == -1) return "No key found";
        String name = hashArray[hashedKey].name;
        hashArray[hashedKey] = null;

        MyEntry[] oldArr = hashArray;
        hashArray = new MyEntry[oldArr.length];
        for (MyEntry myEntry : oldArr) {
            if (myEntry != null) {
                put(myEntry.key, myEntry.name);
            }
        }
        return name;
    }

    public int findKey(int key) {
        int hashedKey = hash(key);
        if (hashArray[hashedKey].key == key) return hashedKey;
        int stopIndex = hashedKey++;
        if (hashedKey == hashArray.length) hashedKey = 0;
        while (hashedKey != stopIndex && !isOccupied(key)) {
            if (hashArray[hashedKey].key == key) return hashedKey;
            hashedKey = (hashedKey + 1) % hashArray.length;
        }
        return -1;
    }

    public void printHashTable() {
        System.out.println(Arrays.toString(hashArray));
    }

    private static class MyEntry {
        private final int key;
        private final String name;

        public MyEntry(int key, String name) {
            this.key = key;
            this.name = name;
        }
                //Convention
        public static MyEntry valueOf(int key, String name) {
            return new MyEntry(key, name);
        }

        @Override
        public String toString() {
            return "MyEntry{" + "key=" + key + ", name='" + name + '\'' + '}';
        }

    }
}
