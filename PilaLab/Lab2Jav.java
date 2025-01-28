import java.util.Scanner;

class SymScanner {
    private Pila stack_Current;
    private String dbString = "()[]{}<>";

    public SymScanner(Pila selected_Stack){
        stack_Current = selected_Stack;
    }

    boolean Scan(String String2Scan)
    {
        for(int i = 0; i < String2Scan.length(); i++){
            char buf = String2Scan.charAt(i);
            if(dbString.contains(Character.toString(buf))){
                if(stack_Current.peek() == buf-1){
                    stack_Current.pop();
                } else if(stack_Current.peek() == buf-2){
                    stack_Current.pop();
                } else {
                    stack_Current.push(buf);
                }
            }
        }

        if(stack_Current.isEmpty()){
            return true;
        }

        return false;
    }

}


class Pila {

    private int sz;
    private char[] data;
    private int cap;

    public Pila(int size) {
        this.sz = size;
        this.cap = -1;
        this.data = new char[sz];
    }

    public boolean isEmpty() {
        return cap == -1;
    }

    public boolean isFull() {
        return cap == sz - 1;
    }

    public int push(char dataIn) {
        if (isFull()) {
            return -1;
        }
        cap++;
        data[cap] = dataIn;
        return 0;
    }

    public char pop() {
        if (isEmpty()) {
            return '\0';
        }
        char poppedValue = data[cap];
        cap--;
        return poppedValue;
    }

    public char peek() {
        if (isEmpty()) {
            return '\0';
        }
        return data[cap];
    }
}


public class Lab2Jav {
    public static void main(String []args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Coloca la cadena a analizar...");
        String str = input.nextLine().strip();
        Pila stack = new Pila(str.length());

        SymScanner scan = new SymScanner(stack);
        
        if(scan.Scan(str)){
            System.out.println("Emparejados...");
        } else {
            System.out.println("No emparejados...");
        }

        input.close();

    }
}