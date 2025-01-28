public class mainProg {
    public static void main(String[] args){
        Queue newQueue = null;
        try {
            newQueue = new Queue(3);
        } catch (Exception e) {
            String message = "";
            message += "Error: ";
            message += e.getClass().getName();
            message += "\nMessage: ";
            message += e.getMessage();
            System.out.println(message);
            return;
        }

        try {
            newQueue.enqueue(256);
            newQueue.enqueue(9456);
            newQueue.enqueue(65565);
            System.out.println(newQueue.deQueue());
            newQueue.enqueue(22);
            System.out.println(newQueue.deQueue());
            System.out.println(newQueue.deQueue());

        } catch (Exception e) {
            String message = "";
            message += "Error: ";
            message += e.getClass().getName();
            message += "\nMessage: ";
            message += e.getMessage();
            System.out.println(message);
        }
    }
    
}
