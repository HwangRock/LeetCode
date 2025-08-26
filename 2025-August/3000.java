import java.util.*;

class Solution {

    static int calculateDiagonal(int a, int b) {
        int dia = a * a + b * b;

        return dia;
    }

    static int calculateArea(int a, int b) {
        int area = a * b;

        return area;
    }

    public int areaOfMaxDiagonal(int[][] dimensions) {
        int ans = 0;
        int fin = dimensions.length;
        int md = 0;

        for (int i = 0; i < fin; i++) {
            int dia = calculateDiagonal(dimensions[i][0], dimensions[i][1]);
            int area = calculateArea(dimensions[i][0], dimensions[i][1]);
            System.out.println(dia + " " + md);
            if (dia > md) {
                md = dia;
                ans = area;
            } else if (dia == md && area > ans) {
                ans = area;
            }
        }
        return ans;
    }
}