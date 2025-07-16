import java.util.Stack;

public class StackB {
    public static boolean isValid(String str){
        Stack<Character> s = new Stack<>();
        
        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);

            if( ch == '(' || ch == '{' || ch == '['){
                s.push(ch);
            }else{
                if(s.isEmpty()){
                    return false;
                }
                if( (s.peek() == '(' && ch == ')')
                 || (s.peek() == '{' && ch == '}')
                 || (s.peek() == '[' && ch == ']')){
                        s.pop();
                 } else {
                    return false;
                 }
            }
        }

        if(s.isEmpty()){
            return true;
        }else {
            return false;
        }
        
    }
    
    public static boolean isDuplicate(String str){
        Stack<Character> s = new Stack<>();

        for(int i = 0; i<str.length(); i++){
            char ch = str.charAt(i);

            if(ch == ')'){
                int count=0;
                while(s.peek() != '('){
                    s.pop();
                    count++;
                }
                if(count < 1){
                    return true;
                }else {
                    s.pop();
                }
            }else {
                s.push(ch);
            }
        }
        return false;
    }

    public static void maxAreaInHistogram(int[] arr){
        int maxArea = 0;
        int nsr[] = new int[arr.length];
        int nsl[] = new int[arr.length];

        Stack<Integer> s = new Stack<>();

        for(int i=arr.length-1; i>=0; i--){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if( s.isEmpty()){
                nsr[i] = arr.length;
            }else {
                nsr[i] = s.peek();
            }
            s.push(i);
        }
        
         s = new Stack<>();

        for(int i=0; i<arr.length; i++){
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
                s.pop();
            }

            if( s.isEmpty()){
                nsl[i] = -1;
            }else {
                nsl[i] = s.peek();
            }
            s.push(i);
        }

        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = nsr[i] - nsl[i] - 1;
            int currArea = height * width;
            maxArea = Math.max(currArea, maxArea);
        }
        System.out.println("Maximun area in histogram is "+ maxArea);
    }

    public static void main(String[] args) {
      int arr[] = {2,1,5,6,2,3};
      maxAreaInHistogram(arr);
    }
}
