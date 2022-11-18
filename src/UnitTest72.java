import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UnitTest72 {

    @Test
    void createRows() {
        int min = -10; int max = 10; int m = 5; int n = 4;
        int[][] a = new int[m][n];
        Main.CreateRows(a, m, n, min, max, 0);
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                assertTrue(min <= a[i][j] && a[i][j] <= max);
            }
        }
    }
}