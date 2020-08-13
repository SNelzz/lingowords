package nl.nielsdaalhuisen.lingowords.application;

import nl.nielsdaalhuisen.lingowords.domain.*;

import java.util.List;

public class WordService {
    private WordRepository words;

    public WordService(WordRepository words){
        this.words = words;
    }

    public List<Word> wordList() {
        return words.WordList();
    }

    public List<Word> wordListBySize(Integer length) {
        return words.WordListBySize(length);
    }


    public Word wordBySize(Integer length) {
        return words.WordBySize(length);
    }
}
