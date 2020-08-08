package nl.nielsdaalhuisen.lingowords.domain;

import java.util.List;

public interface WordRepository {
    List<Word> WordList(Integer length);
    Word Word(Integer length);
    void save(Word word);
}
