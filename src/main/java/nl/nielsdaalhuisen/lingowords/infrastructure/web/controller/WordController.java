package nl.nielsdaalhuisen.lingowords.infrastructure.web.controller;

import nl.nielsdaalhuisen.lingowords.application.WordService;
import nl.nielsdaalhuisen.lingowords.domain.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words")
public class WordController {
    @Autowired
    private WordService wordService;

    @GetMapping(produces = "application/json")
    public List<Word> wordList(@RequestParam(required = false) Integer size) {
        if(size == null) {
            return this.wordService.wordList();
        } else {
            return this.wordService.wordListBySize(size);
        }
    }

    @GetMapping("random")
    public Word wordBySize(@RequestParam int size) {
        return this.wordService.wordBySize(size);
    }
}
