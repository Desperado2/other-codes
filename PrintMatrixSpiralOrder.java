package code_03;

public class PrintMatrixSpiralOrder {

    public static void  printMatrixSpiralOrder(int[][] arr){
        int LTX = 0;
        int LTY = 0;
        int RBX = arr.length -1;
        int RBY = arr[0].length-1;
        while (LTX <= RBX && LTY <= RBY){
            printMatrix(arr,LTX++,LTY++,RBX--,RBY--);
        }
    }

    public static void printMatrix(int[][] arr, int LTX, int LTY, int RBX, int RBY){
        if(LTX == RBX){
            while (LTY == RBY){
                System.out.println(arr[LTX][LTY++]);
            }
        }else if(LTY == RBY){
            while (LTX == RBX){
                System.out.println(arr[LTX++][LTY]);
            }
        }else{
            int curX = LTX;
            int curY = LTY;
            while (curX != RBX){
                System.out.println(arr[LTX][curX++]);
            }
            while (curY != RBY){
                System.out.println(arr[curY++][RBX]);
            }
            while (curX != LTX){
                System.out.println(arr[RBX][curX--]);
            }
            while (curY != LTY){
                System.out.println(arr[curY--][LTY]);
            }
        }

    }
    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrixSpiralOrder(matrix);

    }

}
