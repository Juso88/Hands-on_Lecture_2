import java.util.ArrayList;
import java.util.List;

public class pascal_triangle {

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();

        // Handle the edge case for 0 rows
        if (numRows <= 0) return triangle;

        for (int i = 0; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            
            // First element is always 1
            row.add(1);

            // Compute intermediate values
            for (int j = 1; j < i; j++) {
                int value = triangle.get(i - 1).get(j - 1) + triangle.get(i - 1).get(j);
                row.add(value);
            }

            // Last element is always 1 (only if row size > 1)
            if (i > 0) row.add(1);

            triangle.add(row);
        }

        return triangle;
    }

    public static void main(String[] args) {
        // Test Case #1
        System.out.println("Test Case #1");
        int numRows = 5;
        List<List<Integer>> result = generate(numRows);

        for (List<Integer> row : result) {
            System.out.println(row);
        }
        // Test Case #2
        System.out.println("Test Case #2");
        numRows = 0;
        result = generate(numRows);

        for (List<Integer> row : result) {
            System.out.println(row);
        }
        // Test Case #3
        System.out.println("Test Case #3");
        numRows = 3;
        result = generate(numRows);

        for (List<Integer> row : result) {
            System.out.println(row);
        }
    }
}
