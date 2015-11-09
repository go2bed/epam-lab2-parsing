package com.epam.chadov.task2.entity.composite;

import com.epam.chadov.task2.entity.token.SentenceToken;

/**
 *Parent class for a components and composites of text,
 * also common methods for inheritance classes and interfaces
 */
public abstract class AbstractComponent<E> implements Leaf<E>, SentenceToken {
    E leaf;

    public void add(E leaf) {
        this.leaf = leaf;
    }

    @Override
    public void change(E component) {
    }
    @Override
    public String toSourceString() {
        return leaf.toString();
    }
}
