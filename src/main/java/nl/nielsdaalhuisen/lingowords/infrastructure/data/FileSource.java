package nl.nielsdaalhuisen.lingowords.infrastructure.data;

import nl.nielsdaalhuisen.lingowords.domain.Word;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSource implements SourceDeserializer{

    @Override
    public List<Word> importWords() {
        List<Word> words = new ArrayList<Word>();

        FileInputStream inputStream = null;
        Scanner sc = null;
        try {
            Resource resource = new ClassPathResource("basiswoorden-gekeurd.txt");
            inputStream = (FileInputStream) resource.getInputStream();
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                words.add(new Word(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(inputStream != null) {
                inputStream.close();
            }
            if(sc != null) {
                sc.close();
            }
        }

        return words;
    }


}
