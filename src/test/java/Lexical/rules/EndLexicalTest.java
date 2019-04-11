package Lexical.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Core.Tape;

/**
 * Define all tests about integer
 * rule validation of lexical module
 *
 * @author Rodrigo Cachoeira
 */
@DisplayName("Lexical Analyzer Test Class of End Point")
class EndLexicalTest {

    /**
     * Test Analyzer
     */
    private EndLexical analyzer = new EndLexical();

    /**
     * Set default method for recognize some
     * text
     *
     * @return validated
     */
    private boolean recognize() {
        return this.analyzer.setInput(Tape.getCurrentInputValue()).ok();
    }

    @Test
    void regexAnalyzerShouldBeRecognizeAnSemicolon() {
        new Tape(";");
        assertTrue(this.recognize());
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnStringValue() {
        new Tape("q");
        assertFalse(this.recognize());
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnCommaOrDot() {
        new Tape(".");
        assertFalse(this.recognize());

        new Tape(",");
        assertFalse(this.recognize());
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnIntegerValue() {
        new Tape("1");

        assertFalse(this.recognize());
    }

}
