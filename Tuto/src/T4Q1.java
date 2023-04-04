public class T4Q1 {
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        Node<Character> node1 = new Node<>('a');
        Node<Character> node2 = new Node<>('z');
        list.head = node1;
        list.tail = node2;
        node1.next = node2;
        list.addFirst(new Node<Character>('1'));

    }



}

class LinkedList <E> {
    protected Node<E> head = null;
    protected Node<E> tail = null;

    public void addFirst(Node n){
        n.next = head;
        head = n;
        if (tail == null){
            tail = head;
        }
    }

    public void addLast(Node n){
        if(tail == null){
            tail = n;
        }
        tail.next = n;
        tail = n;
    }

    public void add(int index, E element){
        if(index == 0){
            addFirst(new Node(element));
        }

        Node <E> current = head;
        for(int i = 1; i < index; i++){
            current = current.next;
        }
        Node <E> newNode = new Node<>(element);
        newNode.next = current.next;
        current.next = newNode;
        if(newNode.next == null){
            tail = newNode;
        }


    }

    public E removeFirst(){
        if(head == null){
            return null;
        }
        E element = head.element;
        head = head.next;
        return element;
    }

    public E removeLast(E element){
        element = tail.element;
        if(head.next == null){
            head = tail = null;
            return element;
        }

        Node <E> current = head;
        while(current.next.next != null){
            current = current.next;
        }
        current.next = null;
        tail = current;
        return element;
    }

    public E remove(int index){
        if(index == 0){
            removeFirst();
        }
        Node<E> current = head;
        for (int i = 1; i< index; i++){
            current = current.next;
        }
        E element = current.next.element;
        current.next = current.next.next;

        if(current.next == null){
            tail = current;
        }
        return element;
    }




}

class Node <E> {
    E element;
    Node <E> next; //refer to next node so data type is Node<E>

    public Node (E element){
        this.element = element;
    }

}
