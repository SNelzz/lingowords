package nl.nielsdaalhuisen.lingowords;

import nl.nielsdaalhuisen.lingowords.domain.Word;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LingowordsApplicationTests {

	@Test
	@DisplayName("Validate false word")
	void validateFalseWord() {
		Word word = new Word("10-tal");
		assertFalse(word.isValid());
	}

	@Test
	@DisplayName("Validate valid word")
	void validateValidWord() {
		Word word = new Word("mislukt");
		assertTrue(word.isValid());
	}

}
