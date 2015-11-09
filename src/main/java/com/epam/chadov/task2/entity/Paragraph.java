package com.epam.chadov.task2.entity;

import com.epam.chadov.task2.entity.composite.AbstractComposite;
import com.epam.chadov.task2.entity.composite.Component;

import java.util.ArrayList;
import java.util.List;

/**
 *Class contains method to obtain a list of sentences
 */
public class Paragraph extends AbstractComposite<Sentence>  {

    public List<Sentence> getSentences() {
        List<Sentence> result = new ArrayList<>();
        for (Component component : this.getComponents()) {
            result.add((Sentence) component);
            }
            return result;
        }
    }


