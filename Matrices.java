
import java.util.Scanner;

public class Matrices {
    
    public static  boolean  search(int matrix[][], int key){

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
               if( matrix[i][j] == key){
                return true; 
               }
            }
        }
        return false;

    }

    public static void min(int matrix[][]){
        int min = Integer.MAX_VALUE;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if( matrix[i][j] < min){
                    min = matrix[i][j];
                }
            }
        }
        System.out.println("Minium value "+ min);
    }

    public static void spiralMatrix(int matrix[][]){
        int startRow = 0;
        int startCol = 0;
        int endRow = matrix.length-1;
        int endCol = matrix[0].length-1;

        while(startRow<=endRow && startCol<=endCol){
            //top
            for(int j=startCol; j<=endCol; j++){
                System.out.print(matrix[startRow][j]+" ");
            }

            //right
            for(int i=startRow+1; i<=endRow; i++){
                System.out.print(matrix[i][endCol]+" ");
            }

            //bottom
            for(int j=endCol- 1; j>=startCol;j--){
                if( startRow == endRow){
                    break;
                }
                System.out.print(matrix[endCol][j]+" ");
            }

            //left
            for(int i=endRow-1; i>=startRow+1;i--){
                if(startCol == endCol){
                    break;
                }
                System.out.print(matrix[i][startCol]+" ");
            }
            startCol++;
            startRow++;
            endCol--;
            endRow--;
        }
        System.out.println();
    }
    
   public static int diagonalSum(int matrix[][]){
    int sum = 0;
        for(int i=0; i<matrix.length; i++){
            sum += matrix[i][i];

            if(i != matrix.length-1-i){
                sum += matrix[i][matrix.length-i-1];
            }
        }
        return sum;
   } 

    public static boolean stairCaseSearch(int matrix[][], int key){
        int row = matrix.length-1; 
        int col = 0;

        while( row>= 0 && col < matrix[matrix.length-1].length){
            if(matrix[row][col] == key){
                System.out.println("Key found at ("+row+","+col+")");
                return true;
            }
            else if( key < matrix[row][col]){
                row--;
            }
            else if( key> matrix[row][col]){
                col++;
            }
        }
        System.out.println("Key not found");
        return false;
    }  

    public static  void number7(int matrix[][]){
        int count = 0;

        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length;j++){
                if( matrix[i][j]== 7){
                    count++;
                }
            }
        }
        System.out.println(count);
    }

    public static void sum0f2nd(int num[][]){
        int sum =0;

        int col = 0;

        while( col < num[1].length){
            sum += num[1][col];
            col++;
        }
        System.out.println(sum);
    }

    public static void transpose(int num[][]){

        System.out.println("Original Matrix");
        for(int i=0; i<num.length; i++){
            for(int j=0; j<num[0].length; j++){
                System.out.print(num[i][j]+ " ");
            }
            System.out.println("");
        }
        System.out.println("");

        int transpose[][] = new int[num.length][num[0].length];
        for(int i=0; i<num.length; i++){
            for(int j=0; j<num[0].length; j++){
                transpose[j][i] = num[i][j];
            }
        }
        

        System.out.println("Transpose of matrix");
        for(int i=0; i<num.length; i++){
            for(int j=0; j<num[0].length; j++){
                System.out.print(transpose[i][j]+ " ");
            }
            System.out.println("");
        }
        
    }

    public static void main(String[] args) {
        try( Scanner sc = new Scanner(System.in)){
           int num[][]=  { {1,4,9},{11,4,3},{2,2,3} };

         transpose(num);
        }
        
    }
}
