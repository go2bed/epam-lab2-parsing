package com.epam.chadov.task2.entity.token;

import com.epam.chadov.task2.entity.Letter;
import com.epam.chadov.task2.entity.composite.AbstractComposite;
import com.epam.chadov.task2.entity.composite.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *Class contains methods to obtain a list of paragraphs
 * and a list of words,
 */
public class Word extends AbstractComposite<Letter> implements SentenceToken {

    public Word(String string) {
        List<Component> letters = new ArrayList<>();
        for (int count = 0; count < string.length(); count++) {
            Letter letter= new Letter();
            letter.add((string.charAt(count)));
            letters.add(letter);
        }
        this.setComponents(letters);
    }

    public char getFirstLetter() {
        return this.toSourceString().charAt(0);
    }
}