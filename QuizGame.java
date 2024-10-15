/*
 * Author: Ethan Coleman
 * Course: Programming Assignment 4 for COP2210 - Fall 2024
 * Date: 10/15/2024
 *
 * Class that provides the user a quiz.
 */
import java.util.*;
public class QuizGame {

    private static int goodGuesses; // Keeps track of the number of correct guesses

    public static void main(String[] agrs) {
        Scanner scan = new Scanner(System.in);

        // Introduction for user
        System.out.println("Welcome to the SpongeBob SquarePants Quiz!");

        // Initializing 'QuizQuestion' objects; questions for user to answer
        QuizQuestion quest1 = new QuizQuestion("1. F is for: ", "Friends who do stuff together",
                "Fields full of flowers", "Foods full of flavor", "Flopping in football", "A");
        QuizQuestion quest2 = new QuizQuestion("2. U is for:", "Your car's extended warranty",
                "Umbrellas that don't work", "United States of America", "You and me", "D");
        QuizQuestion quest3 = new QuizQuestion("3. N is for: ", "Nothing Nowhere One at A Time",
                "Anywhere and anytime at all", "NewJeans' new EP",
                "Nisan Ultima is a popular mid-sized sedan produced by Nisan, known for...", "B");

        // Gives quiz to user
        displayQuizQuestion(quest1);
        displayQuizQuestion(quest2);
        displayQuizQuestion(quest3);

        // Announces end of test while giving final results
        System.out.printf("That's the end of the quiz, you guessed %d of the 3 questions right.", goodGuesses);

    }

    /**
     * Displays a given quiz question in an easily readable format, asks the user
     * for a guess, then responds depending on if the user gave the correct answer.
     *
     * @param bigQ 'QuizQuestion' object with a question, four possible responses,
     *              and a specified correct answer.
     *
     */
    public static void displayQuizQuestion(QuizQuestion bigQ) {
        Scanner sc = new Scanner(System.in);

        // Prints bigQ's question and options in a readable format
        System.out.printf("%s%n  A: %s%n  B: %s%n  C: %s%n  D: %s%n", bigQ.getQuestion(), bigQ.getOptionA(), bigQ.getOptionB(),
                bigQ.getOptionC(), bigQ.getOptionD());

        // Asks user for their best guess
        System.out.print("Enter your guess (A, B, C, or D): ");
        String userGuess = sc.nextLine();

        // Checks if user's guess is valid
        if (!userGuess.equalsIgnoreCase("A") && !userGuess.equalsIgnoreCase("B") && !userGuess.equalsIgnoreCase("C") && !userGuess.equalsIgnoreCase("D")) {
            System.out.println("You didn't enter a valid guess...\n");

        } else {

            // Checks if user's guess is correct
            if (bigQ.isCorrectAnswer(userGuess)) {
                System.out.println("That's correct!\n");
                goodGuesses++;

            } else {
                // Tells user their guess is wrong and shows the correct answer
                if (bigQ.getCorrectAnswer().equals("A")) {
                    System.out.println("That was incorrect. The right answer is "
                            + bigQ.getCorrectAnswer() + ": " + bigQ.getOptionA() + "\n");

                } else if (bigQ.getCorrectAnswer().equals("B")) {
                    System.out.println("That was incorrect. The right answer is "
                            + bigQ.getCorrectAnswer() + ": " + bigQ.getOptionB() + "\n");

                } else if (bigQ.getCorrectAnswer().equals("C")) {
                    System.out.println("That was incorrect. The right answer is "
                            + bigQ.getCorrectAnswer() + ": " + bigQ.getOptionC() + "\n");

                } else if (bigQ.getCorrectAnswer().equals("D")) {
                    System.out.println("That was incorrect. The right answer is "
                            + bigQ.getCorrectAnswer() + ": " + bigQ.getOptionD() + "\n");

                }
            }
        }
    }
}



class QuizQuestion {

    private String question;
    private String optionA,  optionB, optionC, optionD;
    private String correctAnswer;

    /**
     * Constructs a QuizQuestion object with it's own question, four options, and a correct answer.
     * All given parameters must be strings.
     *
     * @param quest the desired question
     * @param optA option A
     * @param optB option B
     * @param optC option C
     * @param optD option D
     * @param rightAns the correct answer
     */
    public QuizQuestion(String quest, String optA, String optB, String optC, String optD, String rightAns) {

        question = quest;
        optionA = optA;
        optionB = optB;
        optionC = optC;
        optionD = optD;
        correctAnswer = rightAns;

    }

    /**
     * Returns the question.
     *
     * @return the question.
    */
    public String getQuestion() { return question; }
    /**
     * Returns option A
     *
     * @return option A.
     */
    public String getOptionA() { return optionA; }
    /**
     * Returns option B.
     *
     * @return option B.
     */
    public String getOptionB() { return optionB; }
    /**
     * Returns option C.
     *
     * @return option C.
     */
    public String getOptionC() { return optionC; }
    /**
     * Returns option D.
     *
     * @return option D.
     */
    public String getOptionD() { return optionD; }
    /**
     * Returns the correct answer.
     *
     * @return the question's correct answer.
     */
    public String getCorrectAnswer() { return correctAnswer; }

    /**
     * Changes the question to a given string.
     *
     * @param quest replaces the current question.
     */
    public void setQuestion(String quest) { question = quest; }
    /**
     * Changes option A to a given string.
     *
     * @param optA replaces optionA.
     */
    public void setOptionA(String optA) { optionA = optA; }
    /**
     * Changes option B to a given string.
     *
     * @param optB replaces option B.
     */
    public void setOptionB(String optB) { optionB = optB; }
    /**
     * Changes option C to a given string.
     *
     * @param optC replaces option C.
     */
    public void setOptionC(String optC) { optionC = optC; }
    /**
     * Changes option D to a given string.
     *
     * @param optD replaces option D.
     */
    public void setOptionD(String optD) { optionD = optD; }
    /**
     * Changes correct answer to a given string.
     *
     * @param rightAns changes the correct answer.
     */
    public void setCorrectAnswer(String rightAns) { correctAnswer = rightAns; }

    /**
     * Checks to see if the given guess is the correct answer.
     *
     * @param guess is compared the correct answer.
     */
    public boolean isCorrectAnswer(String guess) {
        return guess.equalsIgnoreCase(correctAnswer); }

}
