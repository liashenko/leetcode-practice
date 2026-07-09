class LRUCache {

    private Map<Integer, Integer> store = new HashMap<>();
    private LinkedList<Integer> order = new LinkedList<>();
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (store.containsKey(key)) {
            // shift to head
            order.removeFirstOccurrence(key);
            order.addFirst(key);
        }
        return store.getOrDefault(key, -1);
    }
    
    public void put(int key, int value) {
        if (store.containsKey(key)) {
            order.removeFirstOccurrence(key);
        } else if (store.size() == capacity) {
            // evict tail (least recently used)
            int tail = order.removeLast();
            store.remove(tail);
        }
        store.put(key, value);
        order.addFirst(key);
    }
}
