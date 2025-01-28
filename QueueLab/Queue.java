import javax.naming.SizeLimitExceededException;
public class Queue {
    private int[] data;
    private int max;
    private int front,back,cap;

    public Queue(int size) throws Exception{

        if(size > 1){
            this.data = new int[size];
            this.max = 0;
            this.front = 0;
            this.back = 0;
            this.cap = size;
        } else {
            throw new IllegalArgumentException("Size cannot be less or equal to one (1)");
        }
    }

    public boolean isEmpty()
    {
        if(max == 0){
            return true;
        }

        return false;
    }

    public boolean isFull()
    {
        if(max >= cap){
            return true;
        }

        return false;
    }

    public void enqueue(int data) throws Exception
    {
        if(!isFull()){
            this.back = (front+max)%cap;
            max++;
            this.data[back] = data;
        } else {
            throw new SizeLimitExceededException("Queue Full");
        }
    }

    public int deQueue() throws Exception
    {
        int buf;
        if(!isEmpty()){
            buf = data[front];
            data[front] = 0;
            front=(front+1)%cap;
            max--;

            return buf;
        } else {
            throw new IndexOutOfBoundsException("Queue Empty");
        }

        
    }
}
