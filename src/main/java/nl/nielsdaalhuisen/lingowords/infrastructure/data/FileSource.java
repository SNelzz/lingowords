package nl.nielsdaalhuisen.lingowords.infrastructure.data;

import nl.nielsdaalhuisen.lingowords.domain.Word;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileSource implements SourceDeserializer{

    public FileSource() {}

    @Override
    public List<Word> importWords() {
        List<Word> words = new ArrayList<Word>();

        InputStream inputStream = null;
        Scanner sc = null;
        try {
            Resource resource = new ClassPathResource("basiswoorden-gekeurd.txt");
            inputStream = resource.getInputStream();
            sc = new Scanner(inputStream, "UTF-8");
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                words.add(new Word(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if(inputStream != null) {
                    inputStream.close();
                }
                if(sc != null) {
                    sc.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return words;
    }


}
