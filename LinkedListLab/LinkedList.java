public class LinkedList {
    public Node start;

    /**
     * 
     * Creates an empty Linked List
     * 
     */
    public LinkedList()
    {
        //sets head as null (Empty list)
        start = null;
    }

    /**
     * 
     * Creates a Linked list with a head defined by the user
     * @param head
     * The Node to be added as head
     * 
     */
    public LinkedList(Node head)
    {
        //Poblates head with new Node
        start = head;
    }


    /**
     * Checks if the linked list is empty
     * @return true if head is null or false if head is not null
     */
    public boolean is_Empty()
    {
        //Checks if head is null
        if(start == null)
        {

            //Head is null, list is empty
            return true;
        }

        //Head is not null, list contains atleast 1 (one) Node
        return false;
    }

    /**
     * Adds node to end of list
     * @param to_add
     * Node to add
     */
    public void append(Node to_add) 
    {
        //If list is empty, replace null head with new Node
        if(is_Empty()){start = to_add; return;}


        //Select head as current node
        Node curr = start;

        //Iterate until EOL
        while(curr.next != null){
            curr = curr.next;
        }

        //Replace last Node next pointer with new Head
        curr.next = to_add;
    }


    /**
     * Adds node to start of list
     * @param NewHead
     * Node to add
     */
    public void push(Node NewHead)
    {

        //Replace new Node next pointer to head
        NewHead.next = start;
        
        //replace head with new Node
        start = NewHead;
    }


    /**
     * Adds Node to specific position
     * @param to_add Node to add
     * @param pos Position of the new node
     */
    public void insert(Node to_add, int pos)
    {
        //1-based indexing (position cannot be less than 1)
        if(pos < 1){ throw new IllegalArgumentException("Invalid Position (pos < 1)"); }


        //head at position 1
        if(pos == 1)
        {
            //replace new Node next pointer with head
            to_add.next = start;

            //replace head with new Node
            start = to_add;

            //finish
            return;
        }


        //Select head as penultimate Node
        Node prev = start;

        //1-based indexing
        int iterable = 1;

        //Iterate to penultimate Node until position or EOL
        while(iterable < pos - 1 && prev != null)
        {
            prev = prev.next;
            iterable++;
        }

        //if EOL reached, position is beyond list size
        if(prev == null)
        {
            throw new ArrayIndexOutOfBoundsException("Invalid Position (End of list reached)");
        }

        //Save new Node
        Node tempNode = to_add;

        //replace new Node next pointer to next Node of previous Node
        tempNode.next = prev.next;

        //Replace previous Node next pointer to new Node
        prev.next = tempNode;
    }


    /**
     * Removes the first node of the list
     */
    public Node pop()
    {

        //Simple is_empty check
        if(is_Empty()){ throw new ArrayIndexOutOfBoundsException("List is empty"); }


        //Save head 
        Node tempNode = start;

        //Replace head with next Node
        start = tempNode.next;

        //Return head
        return tempNode;
    }


    /**
     * Removes the Node in the user-indicated position
     * @param pos
     * Position of the Node to remove
     */
    public Node remove(int pos)
    {

        //Simple is_empty check
        if(is_Empty()){ throw new ArrayIndexOutOfBoundsException("List is empty"); }

        //If list contains only one Node (head), delete head and return it
        if(start.next == null)
        {
            Node tempNode = start;
            start = null;
            return tempNode;
        }


        //If pos indicates head (pos 1) return head and delete it;
        if(pos == 1)
        {
            Node temp = start;
            start = start.next;
            return temp;
        }

        //1-based indexing (pos cannot be less than 1)
        if(pos < 1)
        {
            throw new IllegalArgumentException("Invalid Position (pos < 1)");
        }

        //Select head
        Node prev = start;

        //1-based indexing
        int iterable = 1;

        //iterate until penultimate Node until position is reached or until EOL (End-Of-List);
        while(iterable < pos - 1 && prev.next != null)
        {
            prev = prev.next;
            iterable++;
        }

        //If EOL reached position is beyond list size
        if(prev.next == null)
        {
            throw new ArrayIndexOutOfBoundsException("Invalid Position (EOL reached)");
        }


        //Save Node at position
        Node tempNode = prev.next;
        //Replace Node at position with next Node
        prev.next = tempNode.next;


        //return Node at position
        return tempNode;
    }


    /**
     * Removes the last Node on the list
     */
    public Node detach()
    {

        //Simple is_empty check
        if(is_Empty()) { throw new IndexOutOfBoundsException("List is empty"); }

        //If list contains only one Node (head) return head
        if(start.next == null)
        {
            Node tempNode = start;
            start = null;
            return tempNode;
        }


        //If not, iterate until end of list
        Node curr = start;
        while(curr.next.next != null){
            curr = curr.next;
        }

        Node temp = curr.next;
        curr.next = null;
        //And return last item
        return temp;
    }


    /***
     * Converts the Linked List into a a string
     * @return The Linked list as a string
     */
    public String toStringList()
    {

        //Buffer to hold the characters
        String buf = "";

        //Selects head of current list
        Node curr = this.start;

        //Iterates until EOL (End-Of-List)
        while(curr != null){

            //Adds to buffer the content of the current node (usage of valueOf needed due to abstract datatype (Object))
            buf += String.valueOf(curr.data);
            curr = curr.next;
        }

        //Returns buffer
        return buf;

    }
    
    /***
     * Prints the data inside the linked list
     */
    public void show()
    {
        //Selects head of list as starting point
        Node curr = this.start;

        //1-based indexing
        int iterateId = 1;

        //Iterates until EOL (End Of List)
        do
        {
            System.out.println("Node No. " + String.valueOf(iterateId));
            System.out.println("Contents: " + String.valueOf(curr.data));
            iterateId++;
            curr = curr.next;
        }while(curr != null);

        
    }

    /**
     * Checks the first node of the list
     * @return the first Node of the list
     */
    public Node peek()
    {
        return start;
    }

    /**
     * Checks the node at user-indicated position
     * @param pos
     * Position of the node to be checked
     * @return the node at pos
     */
    public Node peek(int pos)
    {

        //Linked list uses 1-based indexing (returns head)
        if(pos == 1)
        {
            return start;
        }

        //Linked list uses 1-based indexing (pos cannot be less than 1)
        if(pos < 1)
        {
            throw new IllegalArgumentException("Illegal Argument (pos < 1)");
        }




        //Selects the head of the list
        Node curr = this.start;
        //1-based indexing
        int iterable = 1;

        //Iterates until pos is reached
        while(curr.next != null)
        {
            if(iterable == pos)
            {
                break;
            }

            iterable++;
            curr = curr.next;
        }

        //returns Node at pos
        return curr;
    }

    /***
     * Modify content of head
     * @param newData new data to be writen to Node
     */
    public void rewrite(Object newData)
    {
        //Modify head data with new data
        this.start.data = newData;
    }

    /**
     * Modify content of Node at pos
     * @param newData new data to be writen to Node
     * @param pos position of Node
     */
    public void rewrite(Object newData, int pos)
    {

        //Select head as penultimate Node
        Node prev = start;

        //1-based indexing
        int iterable = 1;

        //Iterate to penultimate Node until position or EOL
        while(iterable < pos - 1 && prev != null)
        {
            prev = prev.next;
            iterable++;
        }

        //if EOL reached, position is beyond list size
        if(prev == null)
        {
            throw new ArrayIndexOutOfBoundsException("Invalid Position (End of list reached)");
        }

        //Replace data of Node at position with new data    
        prev.data = newData;
        
    }


    public void reverse()
    {
        Node current = start;
        Node prev = null;
        Node next = null;

        while(current != null){
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        start = prev;
    }


    public void removeDups()
    {
        //Selects head of list as starting point
        Node curr = this.start;

        //Iterates until EOL (End Of List)
        do
        {
            
            Node curr2 = curr;

            while(curr2.next != null){
                if(curr2.next.data == curr.data){
                    curr2.next = curr2.next.next;
                } else {
                    curr2 = curr2.next;
                }
            }

            curr = curr.next;

        }while(curr != null);
    }

    
}
