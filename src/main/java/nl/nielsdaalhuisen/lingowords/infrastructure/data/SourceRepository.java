package nl.nielsdaalhuisen.lingowords.infrastructure.data;

import nl.nielsdaalhuisen.lingowords.domain.Word;
import nl.nielsdaalhuisen.lingowords.domain.WordRepository;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class SourceRepository implements WordRepository {
    private SourceDeserializer sourceDeserializer;
    private Random rand = new Random();

    public SourceRepository(SourceDeserializer sourceDeserializer) {
        this.sourceDeserializer = sourceDeserializer;
    }

    @Override
    public List<Word> WordList() {
        return sourceDeserializer.importWords().stream().filter(p -> p.isValid()).collect(Collectors.toList());
    }

    @Override
    public List<Word> WordListBySize(Integer length) {
        return sourceDeserializer.importWords().stream().filter(p -> p.isValid() && p.getValue().length() == length).collect(Collectors.toList());
    }

    @Override
    public Word WordBySize(Integer length) {
        List<Word> words = sourceDeserializer.importWords().stream().filter(p -> p.isValid() && p.getValue().length() == length).collect(Collectors.toList());

        return words.get(rand.nextInt(words.size()));
    }

}
