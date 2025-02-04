//import java.util.Random;
import java.util.Scanner;

public class mainProg {
    public static void main(String[] args) {

        

        //Random rand = new Random(System.currentTimeMillis()/1000L);
        Scanner read = new Scanner(System.in);
        LinkedList llist = new LinkedList();
        
        //int items = read.nextInt();
        
        llist.append(new Node(1));
        llist.append(new Node(2));
        llist.append(new Node(20));
        llist.append(new Node(20));
        llist.append(new Node(5));
        llist.append(new Node(2));
        
        llist.show();


        llist.removeDups();

        read.close();

        llist.show();



        

    }
}
