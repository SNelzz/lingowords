package nl.nielsdaalhuisen.lingowords.infrastructure.data;

import nl.nielsdaalhuisen.lingowords.domain.Word;

import java.util.List;

public interface SourceDeserializer {
    List<Word> importWords();
}
