import java.util.Stack;

public class StackB {
    public static void nexGreaterElement(int arr[]){
        Stack<Integer> s = new Stack<>();
        int nexGreater [] = new int[arr.length];

        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]){
                s.pop();
            }

            if( s.isEmpty()){
                nexGreater[i] = -1;
            }else {
                nexGreater[i] = arr[s.peek()];
            }
            s.push(i);
        }
        for(int i=0; i< nexGreater.length; i++){
            System.out.print(nexGreater[i]+" ");
        }
    }
   


    public static void main(String[] args) {
      int arr [] = {6,8,0,1,3};
      

      nexGreaterElement(arr);


       
    }
}
