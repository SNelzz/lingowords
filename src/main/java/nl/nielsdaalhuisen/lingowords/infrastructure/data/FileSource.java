package nl.nielsdaalhuisen.lingowords.infrastructure.data;

import nl.nielsdaalhuisen.lingowords.domain.Word;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSource implements SourceDeserializer{

    @Override
    public List<Word> importWords() {
        List<Word> words = new ArrayList<>();

        Resource resource = new ClassPathResource("basiswoorden-gekeurd.txt");
        try (Scanner sc = new Scanner(resource.getInputStream(), StandardCharsets.UTF_8);) {

            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                words.add(new Word(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }


}
