import java.util.Scanner;
public class Queue<E> {
    private E[] elements;
    private int size;
    private int capacity;
    private int front;
    private int back;
    public Queue(E e, int size) {
        this.elements = (E[]) new Object[size];
        this.size = size;
        this.capacity = 0;
        this.front = 0;
        this.back = 0;
    }

    public void enqueue(E e) {
        if (this.capacity == this.size) {
            System.out.println("Queue is full");
        } else {
            this.elements[this.back] = e;
            this.back = (this.back + 1) % this.size;
            this.capacity++;
        }

    }
    public E dequeue() {
        if (this.capacity == 0) {
            System.out.println("Queue is empty");
            return null;
        } else {
            E e = this.elements[this.front];
            this.front = (this.front + 1) % this.size;
            this.capacity--;
            return e;
        }

    }
    public boolean isEmpty() {
        return this.capacity == 0;
    }
    public int size() {
        return this.capacity;
    }

    public static void main(String[] args) {
        Queue<Integer> q = new Queue<Integer>(0, 5);
        Scanner keyIn = new Scanner(System.in); for (int i = 1; i <= 5; i++)
        {
            if (keyIn.nextBoolean())
                System.out.print(i + " ");
            else
                q.enqueue(i);
        }
        while (!q.isEmpty())
             System.out.print(q.dequeue() + " ");
        System.out.println();
    }

}


