import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for quiz.
 */
class Quiz {
    String question;
    String[] choices;
    String correct;
    String maxMarks;
    String penality;
    /**
     * Constructs the object.
     */
    Quiz() {

    }
    /**
     * Constructs the object.
     *
     * @param      question  The question
     * @param      choices   The choices
     * @param      correct   The correct
     * @param      maxMarks  The maximum marks
     * @param      penality  The penality
     */
    Quiz(String question, String[] choices, String correct, String maxMarks, String penality) {
        this.question = question;
        this.choices = choices;
        this.correct = correct;
        this.maxMarks = maxMarks;
        this.penality = penality;
        //System.out.println(question);
    }

}
