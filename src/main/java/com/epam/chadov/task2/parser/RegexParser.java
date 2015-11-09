package com.epam.chadov.task2.parser;

import com.epam.chadov.task2.io.PropertyMgr;
import com.epam.chadov.task2.entity.Paragraph;
import com.epam.chadov.task2.entity.Sentence;
import com.epam.chadov.task2.entity.Text;
import com.epam.chadov.task2.entity.composite.Component;
import com.epam.chadov.task2.entity.composite.Composite;
import com.epam.chadov.task2.entity.token.*;
import com.epam.chadov.task2.exceptions.ClassNameNotFoundException;
import com.epam.chadov.task2.exceptions.ParsingException;
import com.epam.chadov.task2.exceptions.PropertyManagerException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *Class contains methods for configuration and Parsing
 *
 */
public class RegexParser implements Parser {
    private static final Logger logger = LogManager.getLogger(RegexParser.class.toString());
    private static final String REGEX = ".regex";
    private static final String COMPOSITES = "composites";
    private static final String COMMA = ",";

    Map<Class<? extends Composite>, Pattern> patterns;
    Map<Class<? extends Composite>, Class<? extends Component>> componentMap;

    /**
     * Method Parsing is recursion method
     * receives the string of Text for a manipulations
     *
     * @throws ParsingException
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    @Override
    public Text parse(String stringText) throws ParsingException, InstantiationException, IllegalAccessException {
        return parse(stringText, Text.class);
    }

    <T extends Composite> T parse(String stringText, Class<T> compositeClass) throws ParsingException, IllegalAccessException, InstantiationException {
        T type;
        try {
            type = compositeClass.newInstance();
            Class componentClass = componentMap.get(compositeClass);
            Matcher matcher = patterns.get(componentClass).matcher(stringText);
            while (matcher.find()) {
                if (componentClass == SentenceToken.class) {
                    if (matcher.group().matches(patterns.get(Word.class).toString())) {
                        type.add(new Word(matcher.group()));
                    }
                    if (matcher.group().matches(patterns.get(Numbers.class).toString())) {
                        Numbers number = new Numbers();
                        number.add(new Integer(matcher.group()));
                       type.add(number);
                    }
                    if (matcher.group().matches(patterns.get(Punctuation.class).toString())) {
                        Punctuation punctuation = new Punctuation();
                        punctuation.add(matcher.group().charAt(0));
                        type.add(punctuation);
                    }
                    if (matcher.group().matches(patterns.get(Space.class).toString())) {
                        Space space = new Space();
                        space.add(matcher.group().charAt(0));
                        type.add(space);
                    }
                    } else {
                        Component c = parse(matcher.group(), componentClass);
                        type.add(c);
                    }
                }
                return type;
            } catch(InstantiationException | IllegalAccessException ignored){
            logger.error("Could not parse the elements of text ");
                throw new ParsingException("Could not parse the elements of text ");
            }
         }

    /**
     * Method provides two hash map with the names and instances of classes,
     * as well as regular expressions for transmission method of parsing
     * @throws ClassNameNotFoundException
     * @throws PropertyManagerException
     */
    public void configure() throws ClassNameNotFoundException, PropertyManagerException {
        PropertyMgr propertyManager = null;
        try {
            propertyManager = PropertyMgr.getInstance();
        } catch (IOException e) {
            logger.error("PropertyManagerException - Could not create instance of Property Manager");
            throw new PropertyManagerException("Could not create instance of Property Manager", e);
        }
        patterns = new HashMap<>();
        String composites = propertyManager.getProperty(COMPOSITES);// Extraction the names of the parameters for regular expressions of the configuration file
        final String[] composite_names = composites.split(COMMA); //The division names on the set parameter - comma, and put into array
        for (String compositeName : composite_names) { // Iterate over the array of names for verification entity classes with regular expressions
            Class clazz;
            try {
                clazz = Class.forName(propertyManager.getProperty(compositeName + ".class"));
            } catch (ClassNotFoundException e) {
               logger.error("ClassNameNotFoundException - Class name is not exist");
                throw new ClassNameNotFoundException("Class name is not exist", e);
            }
            Pattern regex = Pattern.compile(propertyManager.getProperty(compositeName + REGEX));
            patterns.put(clazz, regex);

        }

        //Creating new HashMap for a certain order exemplars of Classes
        componentMap = new HashMap<>();
        componentMap.put(Text.class, Paragraph.class);
        componentMap.put(Paragraph.class, Sentence.class);
        componentMap.put(Sentence.class, SentenceToken.class);

    }
}
