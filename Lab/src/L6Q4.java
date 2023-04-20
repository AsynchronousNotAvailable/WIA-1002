public class L6Q4 {
    /*A string is a palindrome if it spells the same way forwards and backwards. Write a Java program that uses a Stack to determine if a string is a palindrome or not. Let your string be of maximum size 15 characters. Note however that the actual size may be 15 or less.
    */
    
    public static void main(String[] args) {
        String s = "racecar";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s) {
        MyStack<Character> stack = new MyStack<>();
        for (char c : s.toCharArray())
            stack.push(c);
        for (char c : s.toCharArray())
            if (c != stack.pop()) return false;
        return true;
    }

}
