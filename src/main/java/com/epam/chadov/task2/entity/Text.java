package com.epam.chadov.task2.entity;

import com.epam.chadov.task2.entity.composite.AbstractComposite;
import com.epam.chadov.task2.entity.composite.Component;
import com.epam.chadov.task2.entity.token.Word;
import java.util.ArrayList;
import java.util.List;

/**
 *Class contains methods to obtain a list of paragraphs,
 * and a list of words
 */
public class Text extends AbstractComposite<Paragraph> {

    public List<Paragraph> getParagraphs()
    {
        List<Paragraph> result = new ArrayList<>();
        for (Component component : this.getComponents()) {
             result.add((Paragraph)component);
            }
        return result;
    }

    public List<Word> getWords()
    {
        List<Word> result = new ArrayList<>();
        for (Paragraph paragraph : this.getParagraphs()) {
            for (Sentence sentence : paragraph.getSentences()) {
                result.addAll(sentence.getWords());
            }
        }
        return result;
    }
}
