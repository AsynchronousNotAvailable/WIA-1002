//A doubly linked list keeps a set of characters. The head, the middle and the tail nodes respectively contains alphabet
//        ‘a’, ‘b’ and ‘c’.
//        These nodes are in successive order. Create a new node that contains alphabet ‘z’.
//        Add this new node at the last location of this linked list.
//        Draw all of these nodes including their correct references.

public class T5Q3 {


    class Tester{
        public void main(String[] args) {
            DoublyLinkedList<String> myList = new DoublyLinkedList<>(5);
            Node<String> node1 = new Node<>("element 1");
            Node<String> node2 = new Node<>("element 2");
            myList.add(node1);
            myList.add(node2);

        }
    }

    class DoublyLinkedList<E> {

        public Node<E>[] nodes;

        public DoublyLinkedList(int size){
            Node<E>[] nodes = new Node[size];
        }

         void add(Node<E> new_node){
            for(int i = 0; i < nodes.length; i++){
                if(nodes[i] == null){
                    nodes[i] = new_node;
                    System.out.println(new_node.element + "Added");
                }
            }
        }

    }

    class Node<E>{
        E element;
        Node<E> head = null;
        Node<E> tail = null;
        Node<E> next;

        public Node(E new_element){
            element = new_element;
            next = null;
        }
    }
}

