package Lexical.rules;

import Exceptions.InvalidEndPointException;
import Exceptions.InvalidIntegerException;
import Exceptions.InvalidFloatException;
import Exceptions.InvalidTextException;
import Core.AnalyzerMessage;
import Core.Tape;

/**
 * Set all rules about quotation marks
 * validation
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class QuotationMarksLexical implements RuleInterface{

    /**
     * Define input to be analyzer
     * by own rules
     */
    private String input;

    /**
     * Set attribute of identify successful ok
     * validation
     */
    private boolean validated;

    /**
     * Define specific character for open and close
     * sentence
     */
    public static String openedCharacter = null;

    /**
     * Set default construct method
     * and unique
     */
    public QuotationMarksLexical() {
        this.input = "";
        this.validated = false;
    }

    /**
     * Text to be analyzer
     *
     * @param input text to be analyzer
     * @return own class
     * @since 1.0.0
     */
    @Override
    public RuleInterface setInput(String input) {
        this.input = input;
        return this;
    }

    /**
     * Define regex validation of
     * class
     *
     * @since 1.0.0
     * @return validation successful
     */
    public static boolean regexValidation(String input) throws InvalidTextException {
        boolean identify = input.matches("\"") || input.matches("'");

        if (identify) {
            if (QuotationMarksLexical.openedCharacter == null) {
                QuotationMarksLexical.openedCharacter = input;
                return true;
            }
            //throws exception here
            if (QuotationMarksLexical.openedCharacter.equals(input)) {
                return true;
            }
            throw new InvalidTextException("Invalid end of text");
        }
        return false;
    }

    /**
     * Define all connections
     *
     * @since 1.0.0
     * @return own class
     */
    @Override
    public RuleInterface goTo() throws InvalidEndPointException, InvalidIntegerException, InvalidTextException, InvalidFloatException {
        String nextValue = Tape.getNextInputValue();

        if (EndLexical.regexValidation(nextValue)) { //end
            this.validated = true;
            return this; //end of recursion
        }
        if (TextLexical.regexValidation(nextValue)) {
            return new TextLexical().goTo();

        }
        if (QuotationMarksLexical.regexValidation(nextValue)) {
            return new EndLexical().goTo();
        }

        throw new InvalidTextException("Invalid Text Exception");
    }

    /**
     * Start class validation
     *
     * @since 1.0.0
     * @return own class
     */
    @Override
    public QuotationMarksLexical run() throws InvalidEndPointException, InvalidIntegerException, InvalidTextException, InvalidFloatException {
        this.goTo();

        AnalyzerMessage.setMessage("Text found");
        return this;
    }

    /**
     * Check if validation is ok
     *
     * @since 1.0.0
     * @return valid input
     */
    @Override
    public boolean ok() {
        return this.validated;
    }

}
