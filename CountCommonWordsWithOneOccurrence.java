import java.util.HashMap;
import java.util.Map;

public class CountCommonWordsWithOneOccurrence {
    public static void main(String[] args) {
        String[] words1 = { "leetcode", "is", "amazing", "as", "is" };
        String[] words2 = { "amazing", "leetcode", "is" };
        System.out.println(countWords(words1, words2));
    }

    public static int countWords(String[] words1, String[] words2) {
        if (words1.length > words2.length) {
            return countWords(words2, words1);
        }

        Map<String, Integer> wordsMap = new HashMap<>();

        for (String word : words1) {
            wordsMap.putIfAbsent(word, 0);
            wordsMap.put(word, wordsMap.get(word) + 1);
        }

        for (String word : words2) {
            if (wordsMap.containsKey(word) && wordsMap.get(word) <= 1) {
                wordsMap.put(word, wordsMap.get(word) - 1);
            }
        }

        int wordsCounter = 0;

        for (String key : wordsMap.keySet()) {
            if (wordsMap.get(key) == 0)
                wordsCounter++;
        }
        return wordsCounter;
    }
}
