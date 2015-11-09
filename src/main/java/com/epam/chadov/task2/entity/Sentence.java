package com.epam.chadov.task2.entity;

import com.epam.chadov.task2.entity.composite.AbstractComposite;
import com.epam.chadov.task2.entity.composite.Component;
import com.epam.chadov.task2.entity.token.SentenceToken;
import com.epam.chadov.task2.entity.token.Word;

import java.util.ArrayList;
import java.util.List;

/**
 *Class contains method to obtain a list words
 */
public class Sentence extends AbstractComposite<SentenceToken> {

    public List<Word>  getWords() {
    List<Word> result = new ArrayList<>();
    for (Component word : this.getComponents()) {
        if(word instanceof Word) {
            result.add((Word)word);
        }
    }
    return result;

    }
}