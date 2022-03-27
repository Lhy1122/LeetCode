import java.util.ArrayList;

class Solution {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        ArrayList<Integer> arr = new ArrayList<>(m*n);
        for(int j = 0; j < n; j++){
            for(int i = m - 1; i >= 0; i--){
                arr.add(matrix[i][j]);
            }
        }

        int t = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = arr.get(t);
                t++;
            }
        }

    }
}