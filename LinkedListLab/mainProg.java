//import java.util.Random;
import java.util.Scanner;

public class mainProg {

    public static Node insertNodeAtHead(Node head, int data)
    {
        Node to_add = new Node(data);
        
        to_add.next=head;
        
        return to_add;

        
    }

    public static void main(String[] args) {

        

        //Random rand = new Random(System.currentTimeMillis()/1000L);
        Scanner read = new Scanner(System.in);
        LinkedList llist = new LinkedList();
        
        int items = read.nextInt();
        
        for(int i = 0; i < items; i++)
        {
            int data = read.nextInt();
            llist.start = insertNodeAtHead(llist.start, data);
        }
        
        llist.show();




        read.close();



        

    }
}
