class LRUCache {
    class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) {
            this.key = k;
            this.value = v;
        }
    }
    class DoublyLinkedList {
        Node head = new Node(0, 0);
        Node tail = new Node(0, 0);
        DoublyLinkedList() {
            head.next = tail;
            tail.prev = head;
        }

        void addFirst(Node node) {
            node.next = head.next;
            node.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        int removeLast() {
            Node last = tail.prev;
            remove(last);
            return last.key;
        }

        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
    }
    private final int capacity;
    private final Map<Integer, Node> map = new HashMap<>();
    private final DoublyLinkedList order = new DoublyLinkedList();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            order.remove(node);
            order.addFirst(node);
            return node.value;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            order.remove(node);
            order.addFirst(node);
            node.value = value;
            return;
        }
        if (map.size() == capacity) {
            int k = order.removeLast();
            map.remove(k);
        }
        Node node = new Node(key, value);
        map.put(key, node);
        order.addFirst(node);
    }
}