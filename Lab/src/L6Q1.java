import java.util.ArrayList;
import java.util.Scanner;

//Create a generic stack called MyStack class using ArrayList. The MyStack generic class should implement the following methods
public class L6Q1 {

}

class MyStack <E>{
    public ArrayList<E> stackList;
    public void push(E o){
        stackList.add(o);
        System.out.println("Pushed " + o);
    }

    public E pop(){
        E e = stackList.get(stackList.size() - 1);
        stackList.remove(stackList.size() - 1);
        return e;
    }

    public E peek(){
        return stackList.get(stackList.size() - 1);
    }

    public int getSize(){
        return stackList.size();
    }

    public boolean isEmpty(){
        return stackList.isEmpty();
    }

    public String toString(){
        return "stack: " + stackList.toString();
    }

    public boolean search(E o){
        return stackList.contains(o);
    }
}

//b) Write a test program for Q1(a) called TestMyStack class. Create a stack of type Character from MyStack.
class TestMyStack{

    public static void main(String[] args) {
        MyStack<Character> stack = new MyStack<>();
        stack.push('A');
        stack.push('B');
        stack.push('C');
        System.out.println(stack);
        System.out.println(stack.search('b'));
        System.out.println(stack.search('k'));

        MyStack<Integer> stack2 = new MyStack<>();
        stack2.push(1);
        stack2.push(2);
        stack2.push(3);
        System.out.print(stack2);
        System.out.println(stack2.search(6));
    }
}

class TestIntMyStack{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter an integer: ");
        int num = sc.nextInt();
        MyStack<Integer> intStack = new MyStack<>();
        intStack.push(num);
        System.out.print(intStack);
        while(!intStack.isEmpty()){
            System.out.println("Popped " + intStack.pop());

        }
    }
}