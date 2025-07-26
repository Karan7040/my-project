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


}
