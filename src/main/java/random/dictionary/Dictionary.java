package random.dictionary;

public class  Dictionary {
    private DictionaryRepository dictionaryRepository;

    public Dictionary() {
        dictionaryRepository = new DictionaryRepository();
    }

    public void addWord(String word, String meaning) {
        dictionaryRepository.addWord(word, meaning);
    }

    public String getMeaning(String word) {
        return dictionaryRepository.getByWord(word);
    }
}
