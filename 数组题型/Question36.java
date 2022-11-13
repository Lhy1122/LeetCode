class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            for(int j = 0; j < 9; j++){
                if(board[i][j] == '.')
                    continue;
                for(int k = 0; k < 9; k++){
                    if(k != j){
                        if(board[i][k] == board[i][j]){
                            return false;
                        }
                    }

                    if(k != i){
                        if(board[k][j] == board[i][j])
                            return false;
                    }
                }

                int n1 = i / 3;
                int n2 = j / 3;
                n1 *= 3;
                n2 *= 3;

                for(int x = n1; x < n1 + 3; x++){
                    for(int y = n2; y < n2 + 3; y++){
                        if(x == i && y == j)
                            continue;

                        if(board[x][y] == board[i][j])
                            return false;
                    }
                }

            }
        }

        return true;
    }
}