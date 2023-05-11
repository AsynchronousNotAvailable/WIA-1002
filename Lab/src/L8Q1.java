import java.util.PriorityQueue;
import java.util.Stack;

public class L8Q1{

        public static void main(String[] args) {
            PriorityQueue<Integer> pQueue = new PriorityQueue<>();
            int [] numArr = {4,8,1,2,9,6,3,7};
            pQueue.offer(4);
            pQueue.offer(8);
            pQueue.offer(1);
            pQueue.offer(2);
            pQueue.offer(9);
            pQueue.offer(6);
            pQueue.offer(3);
            pQueue.offer(7);


            Integer i;
            while ((i = pQueue.poll())!= null) System.out.print(i + " ");

            System.out.println(pQueue.toString());
            System.out.println(pQueue.poll());
            System.out.println(pQueue.toArray());
            System.out.println(pQueue.peek());
            System.out.println(pQueue.contains(1));
            System.out.println(pQueue.size());

            Stack<Integer> stack = new Stack<>();


            while(!pQueue.isEmpty()){
                Integer item = pQueue.poll();
                System.out.println(item + " ");
                stack.push(item);
            }
            System.out.println("Priority Queue in reversed order: ");
            System.out.println(stack.toArray());

        }


    }

