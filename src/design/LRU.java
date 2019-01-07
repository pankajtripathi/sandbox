package design;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/*
Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations:
get and put.

get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
it should invalidate the least recently used item before inserting a new item.

Follow up:
Could you do both operations in O(1) time complexity?

Example:

LRUCache cache = new LRUCache( 2);
cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
* */
public class LRU {
    private int capacity;
    private Map<Integer, Integer> map;

    LRU(int capacity) {
        this.capacity = capacity;
        this.map = new LinkedHashMap<>();
    }

    // get the value check if null the return -1 else call put method and then return the value
    private int get(int key) {
        Integer value = this.map.get(key);
        if (value == null) return -1;
        else this.put(key, value);

        return value;
    }

    // if key exists and below capacity then remove the key and put in map again
    // else iterate and remove the last used
    private void put(int key, int value) {
        if (this.map.containsKey(key)) {
            this.map.remove(key);
        } else if (this.capacity == this.map.size()) {
            Iterator it = this.map.keySet().iterator();
            it.next();
            it.remove();
        }

        this.map.put(key, value);
    }

    public static void main(String[] args) {
        LRU cache = new LRU(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
