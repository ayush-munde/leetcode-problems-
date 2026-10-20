class LRUCache  {

    class Node {
        int key, val;
        Node next, prev;

        Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    Node Head, Tail;
    int size;
    int capacity;
    HashMap<Integer, Node> map = new HashMap<>();

     LRUCache(int capacity) {
        this.capacity = capacity;
        this.size = 0;

        Head = new Node(-1, -1);
        Tail = new Node(-1, -1);

        Head.next = Tail;
        Tail.prev = Head;
    }

    public void addFirst(int key, int val) {
        if (size == capacity) {
            Delete(Tail.prev);
        }

        Node newNode = new Node(key, val);

        newNode.next = Head.next;
        Head.next.prev = newNode;
        Head.next = newNode;
        newNode.prev = Head;

        size++;
        map.put(key, newNode);
    }

    public void Delete(Node deleteNode) {
        Node Next = deleteNode.next;
        Node Prev = deleteNode.prev;

        Next.prev = Prev;
        Prev.next = Next;

        map.remove(deleteNode.key);
        size--;
    }

    public void modify(Node update, int value) {
        int key = update.key;

        Delete(update);
        addFirst(key, value);
    }

    public int check(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node current = map.get(key);
        int value = current.val;

        modify(current, value);

        return value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            modify(map.get(key), value);
        } else {
            addFirst(key, value);
        }
    }

    public int get(int key) {
        return check(key);
    }
}
