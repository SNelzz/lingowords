package nl.nielsdaalhuisen.lingowords.application;

import nl.nielsdaalhuisen.lingowords.domain.*;

import java.util.List;

public class WordService {
    private WordRepository words;

    public WordService(WordRepository words){
        this.words = words;
    }

    public List<Word> wordList(Integer length) {
        return words.WordList(length);
    }

    public Word word(Integer length) {
        return words.Word(length);
    }
}
