import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class VerifySudokuBoard {

    boolean verifySudokuBoard(int[][] sudoku) {
        for (int[] row : sudoku) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < sudoku[0].length; j++) {
                if (set.contains(row[j])) {
                    return false;
                }
                set.add(row[j]);
            }
        }

        for (int i = 0; i < sudoku.length; i++) {
            Set<Integer> set = new HashSet<>();
            for (int j = 0; j < sudoku[0].length; j++) {
                if (set.contains(sudoku[j][i])) {
                    return false;
                }
                set.add(sudoku[j][i]);
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                Set<Integer> set = new HashSet<>();
                for (int k = 0; k < 9; k++) {
                    int row = i * 3 + k / 3;
                    int col = j * 3 + k % 3;
                    if (set.contains(sudoku[row][col])) {
                        return false;
                    }
                    set.add(sudoku[row][col]);
                }
            }
        }
        return true;

    }

    boolean validSudokuOptimized(int[][] arr) {
        if (arr == null || arr.length != 9 || arr[0].length != 9) {
            return false;
        }
        List<Set<Integer>> rows = new ArrayList<>();
        List<Set<Integer>> cols = new ArrayList<>();
        List<List<Set<Integer>>> grid = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
        }

        for (int i = 0; i < arr.length / 3; i++) {
            grid.add(new ArrayList<>());
            for (int j = 0; j < arr.length / 3; j++) {
                grid.get(i).add(new HashSet<>());
            }
        }

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int value = arr[i][j];
                if (value == 0) {
                    continue;
                }

                if (!rows.get(i).add(value) || !cols.get(j).add(value) || !grid.get(i / 3).get(j / 3).add(value)) {
                    return false;
                }

            }

        }
        return true;
    }
}
