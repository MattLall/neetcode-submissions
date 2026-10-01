class LRUCache {
    HashMap<Integer,ListNode> cache;
    ListNode left;
    ListNode right;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        cache=new HashMap<Integer,ListNode>();
        left=new ListNode(0,0);
        right=new ListNode(0,0,left);
        left.next=right;
    }
    
    public int get(int key) {
        ListNode node = cache.get(key);
        if(node==null){
            return -1;
        }

            remove(node);
            insert(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        ListNode node;
        if(cache.containsKey(key)){
            node = cache.get(key);
            node.val=value;
            remove(node);
        }else{
            node = new ListNode(key,value);
        }
        insert(node);
        cache.put(key,node);
        sizeCheck();

    }



    private void sizeCheck(){
        System.out.println(cache.size() + " " + capacity);
        if(cache.size()>capacity){
            System.out.println(left.next.key);
            cache.remove(left.next.key);
            remove(left.next);

        }
    }

    private void insert(ListNode node){
        ListNode prev=this.right.prev;
        prev.next=node;
        node.prev=prev;
        node.next=this.right;
        this.right.prev=node;
    }

    private void remove(ListNode node){
        ListNode prev = node.prev;
        ListNode next = node.next;
        prev.next=next;
        next.prev=prev;
    }
}

class ListNode{
    int val;
    int key;
    ListNode prev;
    ListNode next;

    public ListNode(){

    }

    public ListNode(int key, int val){
        this.key=key;
        this.val=val;
    }

    public ListNode(int key, int val, ListNode prev){
        this(key,val);
        this.prev=prev;
    }

    public ListNode(int key, int val, ListNode prev, ListNode next){
        this(key,val,prev);
        this.next=next;
    }
}