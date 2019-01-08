package code_03.simaple;

public class RotateMatrix {

    public static void rotateMatrix(int[][] matrix){
        int LTX = 0;
        int LTY = 0;
        int RBX = matrix.length-1;
        int RBY = matrix[0].length-1;

        while (LTX < RBX){
            rotate(matrix,LTX++,LTY++,RBX--,RBY--);
        }
    }

    public static void rotate(int[][] matrix, int LTX, int LTY, int RBX, int RBY){
        int times = RBX - LTX;
        int temp =0;
        for (int i=0; i!=times; i++){
            temp = matrix[LTX][LTY+i];
            matrix[LTX][LTY+i] = matrix[RBX-i][LTY];
            matrix[RBX-i][LTY] = matrix[RBX][RBY-i];
            matrix[RBX][RBY-i] = matrix[LTX+i][RBY];
            matrix[LTX+i][RBY] =temp;
        }

    }

    public static void printMatrix(int[][] matrix) {
        for (int i = 0; i != matrix.length; i++) {
            for (int j = 0; j != matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int[][] matrix = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 },
                { 13, 14, 15, 16 } };
        printMatrix(matrix);
        rotateMatrix(matrix);
        System.out.println("=========");
        printMatrix(matrix);

    }
}
