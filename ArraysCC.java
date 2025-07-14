import java.util.*;

public class ArraysCC {

    public static int linearSearch( int num[] , int key){
        for(int i = 0 ; i<num.length; i++){
            if(num[i] == key){
                return i;
            }
        }
        return -1;
    }

    public static int largest(int num[]){
        int largest = Integer.MIN_VALUE;
        for(int i=0; i<num.length; i++){
            if( largest < num[i]){
                largest = num[i];
            }
        }
        return largest;
    }


    public static int binarySearch(int num[], int key){
        int start=0;
        int end = num.length-1;
        
        while(start<=end) {
            int mid = (start+end)/2;

            if( num[mid] == key){
                return mid;
            }

            if( num[mid]<key){
                start = mid+1;
            }else{
                end = mid-1;
            }
           
        }
        return -1;
    }
   

    public static void reverse(int num[]){
        int first = 0;
        int last = num.length-1;

        while(first< last){
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;
            first++;
            last--;
        }
    }

    public static void pairs(int num[]){
        for(int i = 0 ; i <num.length;i++){
            for(int j = i+1; j<num.length;j++){
                System.out.print("("+num[i]+","+num[j]+") ");
            }
            System.out.println("");
        }
    }

    public static void maxSubArrays(int num[]){

        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int prefixSum[] = new int[num.length];


        prefixSum[0] = num[0];

        for(int i =1 ; i<num.length; i++){
            prefixSum[i]= prefixSum[i-1] + num[i];
        }


        for(int i=0; i<num.length;i++){
            int start = i;
            for(int j=i; j<num.length;j++){
                 int end = j;
                 
                currSum = start == 0 ?  prefixSum[end]: prefixSum[start-1];
               

                if(maxSum < currSum){
                    maxSum = currSum;
                }
   
            }
         
        }
        System.out.println("MAX sum = "+maxSum);
    }

    public static void kadanes(int num[]){
        int ms = Integer.MIN_VALUE;
        int cs = 0;

        for(int i=0; i<num.length; i++){
            cs = cs + num[i];
            if(cs < 0) {
                cs = 0;
            }
            ms = Math.max(cs , ms);
        }
        System.out.println("Max sum "+ ms);
    }

    public static int stocks(int num[]){
        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0 ; i< num.length; i++){
            if(buyPrice < num[i]){
                int profit = num[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            }else{
                buyPrice = num[i];
            }

        }
        return maxProfit;
    }


    public static boolean  duplicate(int num[]){
        for(int i = 0 ; i<num.length; i++){
            for(int j= i+1; i<num.length; j++){
                if(num[i] == num[j]){
                    return true;
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        try(Scanner sc = new Scanner(System.in)){
            int num[] = {1 ,2, 3};
           System.out.println(duplicate(num));
        }
    }
}
