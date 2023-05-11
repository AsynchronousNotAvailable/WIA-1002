//Write a Java program that uses a Queue to determine if the input string is a palindrome or not.

import java.util.LinkedList;
import java.util.Queue;

public class L7Q2 {
    public static void main(String[] args) {
        MyQueue<Character> list = new MyQueue<Character>(new Character[]{'a', 'b', 'b', 'a'});

    }
    boolean isPalindrome(String s){
        Queue<Character> q = new LinkedList<>();
        for(int i = 0; i < s.length()/2; i++){
            q.offer(s.charAt(i));
        }
        for(int i = s.length()-1; !s.isEmpty(); i--){
            if(s.charAt(i) != q.poll()){
                return false;
            }
        }
        return true;
    }

}
