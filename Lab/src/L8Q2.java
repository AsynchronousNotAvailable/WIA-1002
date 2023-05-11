import java.util.PriorityQueue;

public class L8Q2 {
    public static void main(String[] args) {
        PriorityQueue<String> pQueue1 = new PriorityQueue<>();
        PriorityQueue<String> pQueue2 = new PriorityQueue<>();
        String [] nameArr1 = {"George", "Jim", "John", "Blake", "Kevin", "Michael"};
        String [] nameArr2 = {"George", "Katie", "Kevin", "Michelle", "Ryan"};
        for(String name: nameArr1){
            pQueue1.offer(name);
        }

        for(String name: nameArr2){
            pQueue2.offer(name);
        }

        PriorityQueue<String> union = new PriorityQueue<>(pQueue1);
        for(String name: pQueue2){
            if(union.contains(name)){
                continue;
            }
            union.offer(name);
        }
        System.out.println("Union: "+union.toString());

        PriorityQueue<String> difference = new PriorityQueue<>();
        for(String name: pQueue1){
            if(!pQueue2.contains(name)){
                difference.offer(name);
            }
        }

        for(String name: pQueue2){
            if(!pQueue1.contains(name)){
                if(!difference.contains(name)){
                    difference.offer(name);
                }
            }
        }
        System.out.println("Difference: "+difference.toString());

        PriorityQueue<String> intersection = new PriorityQueue<>();
        for(String name: pQueue1){
            if(pQueue2.contains(name)){
                intersection.offer(name);
            }
        }
        System.out.println("Intersection: "+intersection.toString());
    }
}