package nl.nielsdaalhuisen.lingowords.domain;

import java.util.UUID;

public class Word {
    private final UUID uuid;
    private final String value;

    public Word(String word) {
        this.uuid = UUID.randomUUID();
        this.value = word;
    }

    public boolean isValid(String word) {
        return true;
    }
}
