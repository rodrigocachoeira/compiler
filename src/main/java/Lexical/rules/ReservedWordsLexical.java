package Lexical.rules;


import Config.Language;
import Exceptions.InvalidEndPointException;
import Exceptions.InvalidIntegerException;
import Exceptions.InvalidFloatException;
import Core.AnalyzerMessage;
import Core.Tape;

/**
 * Define and validate all reserved words
 *
 * @author Rodrigo
 */
public class ReservedWordsLexical implements RuleInterface {

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
    public ReservedWordsLexical() {
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
        return Language.WORDS.stream().anyMatch((String word) -> {
            return word.equals(input);
        });
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

        if (EndLexical.regexValidation(nextValue)) { //end
            this.validated = true;
            return this; //end of recursion
        }
        if (IntegerSeparatorLexical.regexValidation(nextValue)) { //q2
            if (IntegerLexical.isFloat) throw new InvalidFloatException("Invalid Float Message");

            IntegerLexical.isFloat = true;
            return new IntegerSeparatorLexical().goTo();
        }
        if (IntegerLexical.regexValidation(nextValue)) { //q1
            return this.goTo();
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
    public ReservedWordsLexical run() throws InvalidEndPointException, InvalidIntegerException, InvalidFloatException {
        this.goTo();

        AnalyzerMessage.setMessage("Integer found");
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
