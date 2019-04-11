package Lexical.rules;

import Exceptions.InvalidEndPointException;
import Exceptions.InvalidIntegerException;
import Exceptions.InvalidFloatException;
import Core.Tape;

/**
 * Set all rules about integer separator
 * validation
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class IntegerSeparatorLexical implements RuleInterface{

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
    IntegerSeparatorLexical() {
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
    public static boolean regexValidation(String input) {
        return input.matches("\\.") || input.matches(",");
    }

    /**
     * Define all connections
     *
     * @since 1.0.0
     * @return own class
     */
    @Override
    public RuleInterface goTo() throws InvalidEndPointException, InvalidIntegerException, InvalidFloatException {
        String nextValue = Tape.getNextInputValue();

        if (IntegerLexical.regexValidation(nextValue)) {
            return new IntegerLexical().goTo();
        }

        throw new InvalidIntegerException("Invalid Integer");
    }

    /**
     * Start class validation
     *
     * @since 1.0.0
     * @return own class
     */
    @Override
    public IntegerSeparatorLexical run() {
        this.validated = IntegerSeparatorLexical.regexValidation(this.input);
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
