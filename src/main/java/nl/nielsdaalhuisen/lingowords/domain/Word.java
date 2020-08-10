package nl.nielsdaalhuisen.lingowords.domain;

import java.util.UUID;

public class Word {
    private final UUID uuid;
    private final String value;

    public Word(String word) {
        this.uuid = UUID.randomUUID();
        this.value = word;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getValue() {
        return value;
    }

    public boolean isValid() {
        if(this.value.matches("^[a-z]{5,7}$")) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return "Word{" +
                "uuid=" + uuid +
                ", value='" + value + '\'' +
                '}';
    }
}
