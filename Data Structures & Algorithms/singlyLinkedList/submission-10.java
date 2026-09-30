class LinkedList {
    ListNode head;

    public LinkedList() {
        this.head = null;
    }

    public int get(int index) {
        ListNode dummy = head;

        int i = 0;
        while (dummy != null) {
            if (i == index) {
                return dummy.val;
            }
            if (dummy.next == null) {
                return -1;
            }
            dummy = dummy.next;
            i++;
        }
        return -1;
    }

    public void insertHead(int val) {
        ListNode newHead = new ListNode(val, head);
        head = newHead;
    }

    public void insertTail(int val) {
        ListNode dummy = head;
        if (dummy == null) {
            head = new ListNode(val);

            return;
        }

        while (dummy.next != null) {
            dummy = dummy.next;
        }
        dummy.next = new ListNode(val);
    }

    public boolean remove(int index) {
        ListNode dummy = head;
        ListNode prev = null;
        int count = 0;
        while (count < index && dummy != null) {
            prev = dummy;
            dummy = dummy.next;
            count++;
        }

        if (dummy == null) {
            return false;
        }

        if (prev == null) {
            head = dummy.next;
        } else {
            prev.next = dummy.next;
        }

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> out = new ArrayList<>();
        ListNode dummy = head;
        while (dummy != null) {
            out.addLast(dummy.val);
            dummy = dummy.next;
        }
        return out;
    }
}

class ListNode {
    int val;
    ListNode next;
    public ListNode() {}

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this(val);
        this.next = next;
    }
}