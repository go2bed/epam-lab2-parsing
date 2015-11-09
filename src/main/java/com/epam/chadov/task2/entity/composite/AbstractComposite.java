package com.epam.chadov.task2.entity.composite;

import java.util.ArrayList;
import java.util.List;

/**
 *Class contains list  composite components
 * of text, also common methods for inheritance classes and interfaces
 */
public class AbstractComposite<E extends Component> implements Composite<E> {

    List<Component> components = new ArrayList<>();

    public void add(E component) {
        components.add(component);
    }

    public void remove(E component) {
        components.remove(component);
    }

    public  List<Component> getComponents() {
        return components;
    }

    public void setComponents(List<Component> components) {
        this.components = components;
    }

    public String toSourceString() {
        StringBuilder builder = new StringBuilder();
        for (Component component : components) builder.append(component.toSourceString());
        return builder.toString();
    }
}
