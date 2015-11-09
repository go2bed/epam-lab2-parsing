package com.epam.chadov.task2.entity.composite;

/**
 *Interface for a composites of text
 */
public interface Composite <E extends Component> extends Component{

    void add(E component);
    void remove(E component);

}
