/**
 * Stack implementing class.
 */
class Stack {
    private int maxSize;
    private long[] stackArray;
    private int top = -1;

    Stack(int size) {
        maxSize = size;
        stackArray = new long[size];
    }

    void push(long item) {
        stackArray[++top] = item;
    }

    long pop() {
        return stackArray[top--];
    }

    long peek() {
        return stackArray[top];
    }

    boolean empty() {
        return top == -1;
    }

    boolean full() {
        return top == maxSize - 1;
    }

    int search(long item) {
        for (int i = top; i > -1; i--) if (stackArray[i] == item) return top - i + 1;
        return -1;
    }
}
