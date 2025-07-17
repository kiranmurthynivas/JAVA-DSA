
import java.util.LinkedList;
import java.util.Queue;

public class QueueB {
    public static void inetrLeave(Queue<Integer> q){
    Queue<Integer> qtemp = new LinkedList<>();


    int size = q.size();
    for(int i=0; i<size/2; i++){
        qtemp.add(q.remove());
    }

    while(!qtemp.isEmpty()){
        q.add(qtemp.remove());
        q.add(q.remove());
    }

    while(!q.isEmpty()){
        System.out.print(q.remove()+" ");
    }
    }
    

    public static void main(String[] args) {
    Queue<Integer> q = new LinkedList<>();
    
    for(int i=1; i<=10; i++){
        q.add(i);
    }

    inetrLeave(q);
      
    }

}