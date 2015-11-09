package com.epam.chadov.task2.task;

import com.epam.chadov.task2.entity.token.Word;
import java.util.Comparator;

/**
 * Class - Comparator for comparing the first letters of the words
 */
public class CompareByAlphabetically implements Comparator<Word> {
    @Override
    public int compare(Word word1, Word word2) {
        return Character.compare(word1.getFirstLetter(),word2.getFirstLetter());
    }
}
