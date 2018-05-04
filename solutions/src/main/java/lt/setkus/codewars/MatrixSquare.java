package lt.setkus.codewars;

/**
 * https://www.codewars.com/kata/matrix-square-up-b
 */
public class MatrixSquare {
    public static String[][] matrixSquareUp(int i) {
        String[][] matrix = new String[i][i];
        for (int row = 0; row < matrix.length; row++) {
            int counter = 1;
            for (int column = matrix[row].length - 1; column >= 0; column--) {
                if (counter <= row + 1) {
                    matrix[row][column] = String.valueOf(counter);
                    counter++;
                } else {
                    matrix[row][column] = "x";
                }
            }
        }
        return matrix;
    }
}