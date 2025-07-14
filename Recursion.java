public class Recursion {

    public static void printDecNum(int n){
        if(n == 1){
            System.out.println(n);
            return;
        }
        System.out.print(n+" ");
        printDecNum(n-1);
    }

    public static void printAscNum(int n){
        if(n == 1){
            System.out.print(n+" ");
            return;
        }
        printAscNum(n-1);
        System.out.print(n+" ");
    }

    public static int factorial(int n){
        if(n== 0){
            return 1;
        }
        return n * factorial(n-1);
    }

    public static int printSumNatural(int n){
        if(n == 1){
            return 1;
        }
        return n + printSumNatural(n);
    }

    public static int fibonacci(int n){
        if( n == 0 || n==1){
            return n;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }

    public static boolean isSorted(int arr[], int i){
        if( i == arr.length-1){
            return true;
        }
        if(arr[i] > arr[i+1]){
            return false;
        }
        return isSorted(arr, i+1);
    }

    public static int firstOccurance(int arr[] , int i, int key){
        if( i == arr.length){
            return -1;
        }
        if( arr[i]== key){
            return i;
        }
        return firstOccurance(arr, i+1,key);
    }

    public static int lastOccurance(int arr[] , int i, int key){
        if( i == arr.length){
            return -1;
        }
        int isFound = lastOccurance(arr, i+1, key);
        if( isFound ==-1 && arr[i]== key){
            return i;
        }
        return isFound;
    }


    public static int power(int x, int n){
        if( n== 0){
            return 1;
        }

        return x * power(x , n-1);

    }

    public static int optimizedPower(int a, int n){
        if(n==0){
            return 1;
        }
        int halfPower = optimizedPower(a, n/2);
        int halfPowerSq = halfPower * halfPower;

        if(n % 2 != 0){
            halfPowerSq = a * halfPowerSq;
        }
        return halfPowerSq;
    }

    public static int tilingProblem(int n){
        if(n == 0 || n==1){
            return 1;
        }
       
        return tilingProblem(n-1)+ tilingProblem(n-2);
     }

     public static void removeDuplicates(String str, int idx, StringBuilder newStr, boolean map[] ){
        if(idx == str.length()){
            System.out.println(newStr);
            return;
        }

        char currChar = str.charAt(idx);
        if(map[currChar-'a']== true){
            removeDuplicates(str, idx+1, newStr, map);
        }else{
            map[currChar-'a'] = true;
            removeDuplicates(str, idx+1, newStr.append(currChar), map);
        }
     }

     public static int friendsParing(int n){
        if(n == 1 || n==2){
            return n;
        }
      
        return friendsParing(n-1) + (n-1)* friendsParing(n-2);
     }


     public static void printBinStrings( int n , int lastPlace, String str){

        if( n == 0){
            System.out.println(str);
            return;
        }
        printBinStrings(n-1, 0, str+"0");
        if( lastPlace == 0){
            printBinStrings(n-1, 1, str+"1");
        }
     }



    public static void main(String[] args) {
        printBinStrings(3, 0, "");
    }
}
