package com.epam.chadov.task2.task;

import com.epam.chadov.task2.entity.Text;
import com.epam.chadov.task2.entity.token.Word;
import com.epam.chadov.task2.exceptions.TaskException;

import java.util.List;

/**
 * Class contains methods for perfomance of Assignment
 * "Print the words of the text in alphabetical order of the first
 * letter. Words starting with a new letter, printed with a new line."
 */
public class Task implements TaskInterface {
    @Override
    public void execute(Text text) throws TaskException {
        List<Word> result = text.getWords();
        result.sort(new CompareByAlphabetically());
        printAccordingToTask(result);
    }

    public void printAccordingToTask(List<Word> words) {
        char tmpLetter = ' ';
        for (Word word : words) {
            char firstLetter = word.toString().toLowerCase().charAt(0);
            if (tmpLetter != firstLetter) {
                tmpLetter = firstLetter;
                System.out.println("" + word.toSourceString());
            } else {
                System.out.println(word.toSourceString());
            }
        }
    }
}
