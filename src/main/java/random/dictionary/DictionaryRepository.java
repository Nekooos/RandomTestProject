package random.dictionary;

import java.util.Map;

public class DictionaryRepository {
    private Map<String, String> wordMap;

    public void addWord(String word, String meaning) {
        wordMap.put(word, meaning);
    }

    public String getByWord(String word) {
         return wordMap.get(word);
    }
}
