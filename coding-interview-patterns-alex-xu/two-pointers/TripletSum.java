import java.util.*;

public class TripletSum {

    Set<List<Integer>> tripletSum(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        List<Integer> list = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        return set;
    }
}
