public final class Node
{
    //datatype-independent content (Usage of Object class)
    Object data;

    //Pointer to next Node
    Node next;

    //Create Node with datatype-independent content (Usage of Object class)
    public Node(Object input)
    {
        this.data = input;
        this.next = null;
    }

    //Create empty Node
    public Node()
    {
        this.data = null;
        this.next = null;
    }
}
