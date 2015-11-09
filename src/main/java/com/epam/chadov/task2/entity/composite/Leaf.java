package com.epam.chadov.task2.entity.composite;

/**
 *Interface for a composites of text
 */
public interface Leaf<E> extends Component {
    void change(E component);
}
