package Arrays;

import java.util.HashSet;
import java.util.Set;
class SolutionSudoku {
    public boolean isValidSudoku(char[][] board) {
        Set<String> milgaya = new HashSet();

        int n = board.length;
        int m = board.length;

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                if(board[i][j] == '.'){
                    continue;
                }

                char val = (char) board[i][j];

                if(!milgaya.add("row" + i + "pe" + val) ||
                        !milgaya.add("col" + j + "pe" + val) ||
                        !milgaya.add("box" + i/3 + "aur" + j/3 + "pe" + val)){
                    return false;
                }
            }
        }
        return true;
    }
}