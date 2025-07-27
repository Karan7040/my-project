import java.util.*;

public class KMostFrequentStrings {
    public List<String> kthMostFrequentStringsusingMaxHeap(List<String> words, int k) {
        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> {
            int compare = map.get(b) - map.get(a);
            if (compare == 0) {
                return a.compareTo(b);
            }
            return compare;
        });

        maxHeap.addAll(map.keySet());

        for (int i = 0; i < k; i++) {
            result.add(maxHeap.poll());
        }
        return result;

    }

    public List<String> kMostFrequentStringsUsingMinHeap(List<String> words, int k) {

        Map<String, Integer> map = new HashMap<>();
        List<String> result = new ArrayList<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> minHeap = new PriorityQueue<>((a, b) -> {
            int compare = map.get(b) - map.get(a);
            if (compare == 0) {
                return a.compareTo(b);
            }
            return compare;
        });

        for (String word : map.keySet()) {
            minHeap.offer(word);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        for (int i = 0; i < k; i++) {
            result.add(minHeap.poll());
        }
        Collections.sort(result);
        return result;
    }
}





    }
            }
