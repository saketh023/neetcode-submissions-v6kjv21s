class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character> hs = new HashSet<>();

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.') continue;
                if(!hs.add(board[i][j])) return false;
            }
            hs.clear();
        }

        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[j][i] == '.') continue;
                if(!hs.add(board[j][i])) return false;
            }
            hs.clear();
        }

        for(int row = 0; row < 9; row+=3){
            for(int col = 0; col < 9; col +=3){
                hs.clear();
                for(int i=row; i<row+3; i++){
                    for(int j=col; j<col+3;j++){
                        if(board[i][j] == '.') continue;
                        if(!hs.add(board[i][j])) return false;
                    }
                }
            }
        }
        return true;
    }
}
