import java.util.HashSet;
import java.util.Set;

public class ZeroStriping {

    void zeroStriping(int[][] arr) {
        Set<Integer> zeroRows = new HashSet<>();
        Set<Integer> zeroCols = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {
                    zeroRows.add(i);
                    zeroCols.add(j);
                }
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (zeroRows.contains(i) || zeroCols.contains(j)) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    void zeroStripingByMarking(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == 0) {

                    for (int k = 0; k < arr[0].length; k++) {
                        if (arr[i][k] != 0)
                            arr[i][k] = -1;
                    }

                    for (int k = 0; k < arr.length; k++) {
                        if (arr[k][j] != 0) {
                            arr[k][j] = -1;
                        }
                    }

                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] == -1) {
                    arr[i][j] = 0;
                }
            }
        }
    }

    void zeroStripingOptimized(int[][] arr) {
        int rows = arr.length;
        int columns = arr[0].length;
        boolean firstRowHasZero = false;
        boolean firstColumnHasZero = false;

        for (int j = 0; j < columns; j++) {
            if (arr[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (arr[i][0] == 0) {
                firstColumnHasZero = true;
                break;
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if (arr[i][j] == 0) {
                    arr[i][0] = 0;
                    arr[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            if (arr[i][0] == 0) {
                for (int j = 0; j < columns; j++) {
                    arr[i][j] = 0;
                }
            }
        }

        for (int j = 1; j < columns; j++) {
            if (arr[0][j] == 0) {
                for (int i = 0; i < rows; i++) {
                    arr[i][j] = 0;
                }
            }
        }

        if (firstRowHasZero) {
            for (int j = 0; j < columns; j++) {
                arr[0][j] = 0;
            }
        }

        if (firstColumnHasZero) {
            for (int i = 0; i < rows; i++) {
                arr[i][0] = 0;
            }
        }
    }

}
