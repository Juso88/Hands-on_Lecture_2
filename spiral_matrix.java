import java.util.ArrayList;
import java.util.List;

public class spiral_matrix {

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) return result;

        int m = matrix.length, n = matrix[0].length;
        int totalElements = m * n;

        int rowStart = 0, rowEnd = m - 1;
        int colStart = 0, colEnd = n - 1;

        while (result.size() < totalElements) {

            // Traverse Right
            for (int col = colStart; col <= colEnd && result.size() < totalElements; col++) {
                result.add(matrix[rowStart][col]);
            }
            rowStart++;

            // Traverse Down
            for (int row = rowStart; row <= rowEnd && result.size() < totalElements; row++) {
                result.add(matrix[row][colEnd]);
            }
            colEnd--;

            // Traverse Left
            for (int col = colEnd; col >= colStart && result.size() < totalElements; col--) {
                result.add(matrix[rowEnd][col]);
            }
            rowEnd--;

            // Traverse Up
            for (int row = rowEnd; row >= rowStart && result.size() < totalElements; row--) {
                result.add(matrix[row][colStart]);
            }
            colStart++;
        }

        return result;
    }

    public static void main(String[] args) {
        //Test Case #1
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        System.out.println(spiralOrder(matrix));
    }
}