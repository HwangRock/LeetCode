import java.util.*;

class Solution {

    static char g[][];

    static boolean checkCol() {
        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < 9; i++) { // 세로
            for (int j = 0; j < 9; j++) { // 가로
                char c = g[i][j];
                if (c != '.') {
                    if (h.contains(c)) {
                        return false;
                    } else {
                        h.add(c);
                    }
                }
            }
            h.clear();
        }
        return true;
    }

    static boolean checkRow() {
        HashSet<Character> h = new HashSet<>();
        for (int i = 0; i < 9; i++) { // 가로
            for (int j = 0; j < 9; j++) { // 세로
                char c = g[j][i];
                if (c != '.') {
                    if (h.contains(c)) {
                        return false;
                    } else {
                        h.add(c);
                    }
                }
            }
            h.clear();
        }
        return true;
    }

    static boolean checkBox() {
        HashSet<Character> h = new HashSet<>();
        int y = 0;
        int x = 0;
        while (y != 9) {
            for (int i = y; i < y + 3; i++) {
                for (int j = x; j < x + 3; j++) {
                    char c = g[i][j];
                    if (c != '.') {
                        if (h.contains(c)) {
                            return false;
                        } else {
                            h.add(c);
                        }
                    }
                }
            }
            x += 3;
            if (x == 9) {
                y += 3;
                x = 0;
            }
            h.clear();
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        g = board;
        if (!checkCol() || !checkRow() || !checkBox()) {
            return false;
        } else {
            return true;
        }
    }
}