package com.epam.chadov.task2;

import com.epam.chadov.task2.entity.Text;
import com.epam.chadov.task2.exceptions.*;
import com.epam.chadov.task2.io.FileUtils;
import com.epam.chadov.task2.parser.RegexParser;
import com.epam.chadov.task2.task.Task;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;

/**
 * Task:
 * "Print the words of the text in alphabetical order of the first
 * letter. Words starting with a new letter, printed with a new line."
 *
 * @author Chadov Andrey
 *       : Text Parsing for Epam Systems
 */
public class Main
{
    private static final Logger logger = LogManager.getLogger(Main.class.toString());

    /**
     * Main method creates exemplars of classes of Parsing and Assignment
     * And calls methods for their realisation
     *
     * @throws ReadingException
     * @throws PreparingException
     * @throws ParsingException
     * @throws IOException
     * @throws ClassNameNotFoundException
     * @throws PropertyManagerException
     * @throws TaskException
     */
    public static void  main(String[] args) throws ReadingException, PreparingException, ParsingException, IOException, ClassNameNotFoundException, PropertyManagerException, TaskException {
        FileUtils fileUtils = new FileUtils();
        System.out.println("Reading file\n");
        String stringText = fileUtils.readAllBytes();
        System.out.println("...Done\n");
        RegexParser regexParser = new RegexParser();
        Text text = new Text();
        try {
            regexParser.configure();
        } catch (ClassNameNotFoundException e) {
            logger.error("Class name is not exist");
            throw new ClassNameNotFoundException("Class name is not exist", e);
        } catch (PropertyManagerException e) {
            throw new PropertyManagerException("Could not create instance of Property Manager", e);
        }
        try {
            System.out.println("Parsing text\n");
           text = regexParser.parse(stringText);
        } catch (InstantiationException e) {
            logger.error("Could not parse stringText");
            throw new ParsingException("Could not parse stringText");
        } catch (IllegalAccessException e) {
            logger.error("Please, check parameters of Parsing");
            throw new ParsingException("Please, check parameters of Parsing");
        }
        System.out.println("...Done\n");
        Task task = new Task();
        System.out.println("Executing task\n");
        task.execute(text);
        System.out.println("\n...Done");
        System.out.println("\n");
        System.out.println("Text assembly\n");
        System.out.println(text.toSourceString());
        System.out.println("...Done\n");
    }
}

