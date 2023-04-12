public class T5Q1c {

}

class Node <E>{
    Node<E> head;
    Node <E> tail;
    E element;
    Node<E> next;

    public Node(E e){
        element = e;
        next = null;
    }

    public E xyz(int idx, E new_elem){
        Node <E> current = head;
        E replaced = null;
        if(idx < 0){
            Node <E> new_node = new Node<>(new_elem);
            head = new_node;
        }
        else if(idx == 0){
            replaced = head.element;
            head = new Node<>(new_elem);
        }
        else{
            for(int i = 1; i < idx; i++){
                if(current.next != null){
                    current = current.next;
                }
                else{
//                    addLast
                    Node<E> new_node = new Node<>(new_elem);
                    current.next = new_node;
                    tail = new_node;
                }
            }
            Node<E> temp = current.next;
            replaced = current.next.element;
            current.next = new Node<>(new_elem);
            current.next.next = temp;

        }
        return replaced;

    }
}

class NodeTester{

    public static void main(String[] args) {
        // Create a new Node with element "A"
        Node<String> node = new Node<>("A");

        // Test adding a new element at the head of the list
        node.xyz(-1, "B");
        assert(node.head.element.equals("B"));

        // Test replacing the element at the head of the list
        String replaced = node.xyz(0, "C");
        assert(replaced.equals("B"));
        assert(node.head.element.equals("C"));

        // Test adding a new element at index 2
        node.xyz(2, "D");
        assert(node.head.next.next.element.equals("D"));

        // Test replacing the element at index 2
        replaced = node.xyz(2, "E");
        assert(replaced.equals("D"));
        assert(node.head.next.next.element.equals("E"));
    }


}
