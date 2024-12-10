// Time complexity: O(n log(max - min)) O(n) for countLessEqualMethod. So overall TC is O(n log (max - min ))
// Space Complexity: O(1)
public class KthSmallestElementinSortedmatrix {
    public int kThsmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n - 1][n - 1];

        while (left < right) {
            int mid = left + (right - left) / 2;
            int count = countLessEqual(matrix, mid);

            if (count < k) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int countLessEqual(int[][] matrix, int target) {
        int n = matrix.length;
        int row = n - 1, col = 0;
        int count = 0;

        while (row >= 0 && col < n) {
            if (matrix[row][col] <= target) {
                count += (row + 1); // all elements in this col up to this row are < = target
                col++; // move to next coloumn
            } else {
                row--;
            }
        }
        return count;

    }

    public static void main(String[] args) {
        KthSmallestElementinSortedmatrix solver = new KthSmallestElementinSortedmatrix();
        int[][] matrix = {
                {1, 5, 9},
                {10, 11, 13},
                {12, 13, 15}
        };
        int k = 8;
        System.out.println("The " + k + "th smallest element is: " + solver.kThsmallest(matrix, k));
    }
}
