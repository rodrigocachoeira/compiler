package Lexical.rules;

import Config.LanguagePatterns;
import Core.Tape;

/**
 * Set all rules about end line or file
 * validation
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class EndLexical implements RuleInterface {

    /**
     * Define input to be analyzer
     * by own rules
     */
    private String input;

    /**
     * Set default construct method
     * and unique
     */
    EndLexical() {
        this.input = "";
    }

    /**
     * Text to be analyzer
     *
     * @param input text to be analyzer
     * @return own class
     * @since 1.0.0
     */
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
        return input.matches(LanguagePatterns.ENDLINE.getPattern());
    }

    /**
     * Check if validation is ok
     *
     * @since 1.0.0
     * @return valid input
     */
    public boolean ok() {
        return EndLexical.regexValidation(Tape.getCurrentInputValue());
    }
}
