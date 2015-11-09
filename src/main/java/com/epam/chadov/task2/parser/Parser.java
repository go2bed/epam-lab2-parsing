package com.epam.chadov.task2.parser;

import com.epam.chadov.task2.entity.Text;
import com.epam.chadov.task2.exceptions.ClassNameNotFoundException;
import com.epam.chadov.task2.exceptions.ParsingException;
import com.epam.chadov.task2.exceptions.PropertyManagerException;

import java.io.IOException;

public interface Parser {
    Text parse(String stringText) throws ParsingException, InstantiationException, IllegalAccessException;
    void configure() throws ClassNameNotFoundException, IOException, PropertyManagerException;
}
