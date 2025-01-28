public class DoubleLinkedList {
    DoubleNode head;

    /***
     * Creates empty Doubly Linked List
     */
    public DoubleLinkedList()
    {
        this.head = null;
    }


    /**
     * Creates Doubly Linked List with user-defined head
     * @param newHead the DoubleNode to serve as new head
     */
    public DoubleLinkedList(DoubleNode newHead)
    {
        this.head = newHead;
    }


    public boolean is_Empty()
    {
        if(head == null)
        {
            return true;
        }

        return false;
    }

    public void append(DoubleNode newNode)
    {
        if(is_Empty()) { head = newNode; return;}

        DoubleNode current = head;

        while(current.next != null){
            current = current.next;
        }

        newNode.prev=current;
        current.next = newNode;
    }

    public void push(DoubleNode newNode)
    {
        newNode.next=head;
        head.prev=newNode;
        newNode.prev = null;
        head = newNode;
    }

    public void insert(DoubleNode newNode, int pos)
    {
        if(pos < 1){ throw new IllegalArgumentException("Illegal position (pos < 1)");}
        if(pos == 1){ newNode.next = head; newNode.prev = null; head = newNode; return;}

        DoubleNode prev = head;

        int iter = 1;

        while(iter < pos - 1 && prev != null){
            prev = prev.next;
            iter++;
        }

        if(prev == null){ throw new ArrayIndexOutOfBoundsException("Illegal Position (Reached EOL)"); }

        newNode.next = prev.next;
        prev.prev = newNode;
    }


    public Object pop()
    {
        if(is_Empty()){ throw new ArrayIndexOutOfBoundsException("List is empty"); }

        DoubleNode temp = head;

        head = temp.next;
        head.prev = null;

        return temp;
    }

    public Object remove(int pos)
    {
        if(is_Empty()){ throw new ArrayIndexOutOfBoundsException("List is empty"); }


        if(head.next == null){
            DoubleNode temp = head;
            head = null;
            return temp;
        }

        if(pos == 1){
            DoubleNode temp = head;

            head = head.next;
            head.prev = null;
            return temp;
        }

        if(pos < 1){ throw new IllegalArgumentException("Invalid position (pos !< 1)"); }

        DoubleNode prev = head;

        int iter = 1;

        while(iter < pos - 1 && prev != null)
        {
            prev = prev.next;
            iter++;
        }

        if(prev == null){ throw new ArrayIndexOutOfBoundsException("Invalid Position (Reached EOL)"); }

        DoubleNode temp = prev.next;
        prev.next = temp.next;
        prev.prev = temp.prev;


        return temp;
    }


    public DoubleNode detach()
    {
        if(is_Empty()) { throw new IndexOutOfBoundsException("List is empty"); }

        if(head.next == null)
        {
            DoubleNode temp = head;
            head = null;
            return temp;
        }

        DoubleNode current = head;

        while(current.next.next != null)
        {
            current = current.next;
        }

        DoubleNode temp = current;

        current.prev.prev = null;

        current = null;

        return temp;
    }

    
}
