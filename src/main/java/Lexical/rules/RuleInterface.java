package Lexical.rules;

import Exceptions.InvalidEndPointException;
import Exceptions.InvalidIntegerException;
import Exceptions.InvalidFloatException;
import Exceptions.InvalidTextException;

/**
 * Interface witch defines the standard behavior
 * of lexical rules
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public interface RuleInterface {

    /**
     * Text to be analyzer
     *
     * @param input text to be analyzer
     * @return own class
     * @since 1.0.0
     */
    RuleInterface setInput(String input);

    /**
     * Define regex validation of
     * class
     *
     * @param input value to be analyze
     * @since 1.0.0
     * @return validation successful
     */
    static boolean regexValidation(String input) {
        return false;
    }

    /**
     * Define all connections
     *
     * @return own class
     * @since 1.0.0
     */
    default RuleInterface goTo() throws InvalidEndPointException, InvalidIntegerException, InvalidTextException, InvalidFloatException {
        return this;
    }

    /**
     * Start class validation
     *
     * @return own class
     * @since 1.0.0
     */
    default RuleInterface run() throws InvalidEndPointException, InvalidIntegerException, InvalidTextException, InvalidFloatException {
        return this;
    }

    /**
     * Check if validation is ok
     *
     * @since 1.0.0
     * @return valid input
     */
    boolean ok();

}
