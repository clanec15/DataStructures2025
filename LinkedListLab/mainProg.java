import java.util.Random;

public class mainProg {
    public static void main(String[] args) {

        Random rand = new Random(System.currentTimeMillis()/1000L);
        LinkedList list = new LinkedList();

        for(int i = 0; i < 10; i++)
        {
            list.append(new Node(rand.nextInt(100)));
        }

        Node curr = list.start;
        int iterable = 1;
        int big = 0;
        int itBig = 0;

        list.show();


        System.out.println("\n\n\n\n");

        while(curr.next != null)
        {
            if((int)curr.data > big)
            {
                big = (int)curr.data;
                itBig = iterable;
            }

            curr = curr.next;
            iterable++;
        }

        list.append(new Node(big));
        list.remove(itBig);

        list.show();

    }
}
