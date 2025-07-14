

public class BackTracking {
    public static void changeArr(int arr[], int i){
        
        if(i>=arr.length){
            printArr(arr);
            return;
        }

       arr[i]=i+1;

       changeArr(arr,i+1); 
        arr[i] = arr[i]-2;
    }

    public static void printArr(int arr[]){
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }


     public static void subSets(String str, String ans, int i){
        if(i==str.length()){
           if(ans.length()== 0){
                System.out.println("null");
           }else{
                System.out.println(ans);
           }
           return;
        }

        subSets(str, ans+str.charAt(i), i+1);
        subSets(str, ans, i+1);
     }


     public static void permutations(String str, String ans){
        if(str.length()==0){
            System.out.println(ans);
            return;
        }

        for(int i = 0; i<str.length();i++){
            char curr = str.charAt(i);
            String newString = str.substring(0,i)+str.substring(i+1);
            permutations(newString, ans+curr);
        }
     }

    public static boolean  isSafe(char board[][], int row,int col){
            for(int i=row-1; i>=0;i--){
                if(board[i][col] == 'Q'){
                    return false;
                }
            }
            for(int i=row-1,j=col-1; i>=0&&j>=0;i--,j--){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
            for(int i=row-1,j=col+1; i>=0&&j<board.length;i--,j++){
                if(board[i][j] == 'Q'){
                    return false;
                }
            }
          return true;  
     }

     public static void nQueens(char board[][], int row){
        if(row == board.length){
           printBoard(board);
            return;
        }


        for(int j=0;j<board.length;j++){
           if(isSafe(board, row, j)){
            board[row][j]='Q';
            nQueens(board, row+1);
            board[row][j]='X';
           }
        }
     }

     public static void printBoard(char board[][]){
        System.out.println("-----------");
        for(int i = 0;i<board.length;i++){
            for(int j=0; j<board.length;j++){
                System.out.print(board[i][j]+" ");
            }
            System.out.println();
        }
     }

     public static int gridWays(int i,int j,int n,int m){
        if(i == n-1 && j==m-1){
            return 1;
        }else if(i==n || j==m){
            return 0;
        }

        return gridWays(i+1, j, n, m) + gridWays(i, j+1, n, m);

     }



    public static void main(String[] args) {
     System.out.println(gridWays(0, 0, 3, 3));
    }
}
