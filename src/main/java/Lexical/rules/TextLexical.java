package Lexical.rules;

import Exceptions.InvalidEndPointException;
import Exceptions.InvalidIntegerException;
import Exceptions.InvalidFloatException;
import Exceptions.InvalidTextException;
import Core.AnalyzerMessage;
import Core.Tape;

/**
 * Set all rules about text
 * validation
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class TextLexical implements RuleInterface{

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
     * Set default construct method
     * and unique
     */
    public TextLexical() {
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
        return input.matches(".") && !QuotationMarksLexical.regexValidation(input);
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

        if (EndLexical.regexValidation(nextValue)) {
            AnalyzerMessage.setMessage("Text found");
            return this; //end of recursion
        }
        if (TextLexical.regexValidation(nextValue)) {
            return this.goTo();

        } else if (QuotationMarksLexical.regexValidation(nextValue)) {
            return new QuotationMarksLexical().goTo();
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
    public TextLexical run() throws InvalidEndPointException, InvalidIntegerException, InvalidTextException, InvalidFloatException {
        this.goTo();
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
