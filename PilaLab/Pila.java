
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
