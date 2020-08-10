package nl.nielsdaalhuisen.lingowords.infrastructure.data;

import nl.nielsdaalhuisen.lingowords.domain.Word;
import nl.nielsdaalhuisen.lingowords.domain.WordRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SourceRepository implements WordRepository {
    private SourceDeserializer sourceDeserializer;

    public SourceRepository(SourceDeserializer sourceDeserializer) {
        this.sourceDeserializer = sourceDeserializer;
    }

    @Override
    public List<Word> WordList(Integer length) {
        return sourceDeserializer.importWords().stream().filter(p -> p.isValid() && p.getValue().length() == length).collect(Collectors.toList());
    }

    @Override
    public Word Word(Integer length) {
        List<Word> words = sourceDeserializer.importWords().stream().filter(p -> p.isValid() && p.getValue().length() == length).collect(Collectors.toList());

        Random rand = new Random();
        return words.get(rand.nextInt(words.size()));
    }

}
