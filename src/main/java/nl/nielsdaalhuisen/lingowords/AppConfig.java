package nl.nielsdaalhuisen.lingowords;

import nl.nielsdaalhuisen.lingowords.application.WordService;
import nl.nielsdaalhuisen.lingowords.domain.WordRepository;
import nl.nielsdaalhuisen.lingowords.infrastructure.data.FileSource;
import nl.nielsdaalhuisen.lingowords.infrastructure.data.SourceDeserializer;
import nl.nielsdaalhuisen.lingowords.infrastructure.data.SourceRepository;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public WordService wordService(WordRepository repository) {
        return new WordService(repository);
    }

    @Bean
    public WordRepository wordRepository(SourceDeserializer sourceDeserializer) {
        return new SourceRepository(sourceDeserializer);
    }

    @Bean
    public SourceDeserializer sourceDeserializer() {
        return new FileSource();
    }
}
