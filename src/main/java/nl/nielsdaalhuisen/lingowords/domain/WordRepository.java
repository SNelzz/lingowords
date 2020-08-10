package nl.nielsdaalhuisen.lingowords.domain;

import java.util.List;

public interface WordRepository {
    List<Word> WordList();
    List<Word> WordListBySize(Integer length);
    Word WordBySize(Integer length);
}
