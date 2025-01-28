public class DoubleNode {
    public Object data;
    public DoubleNode next;
    public DoubleNode prev;


    /***
     * Create empty DoubleNode
     */
    public DoubleNode()
    {
        this.data = null;
        this.next = this.prev = null;
    }

    /**
     * Create DoubleNode with user-defined data
     * @param dataIn data to write into DoubleNode
     */
    public DoubleNode(Object dataIn)
    {
        this.data = dataIn;
        this.next = this.prev = null;
    }
}
