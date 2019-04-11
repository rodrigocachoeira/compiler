package Lexical.rules;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import Exceptions.InvalidEndPointException;
import Exceptions.InvalidTextException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import Core.Tape;

/**
 * Define all tests about integer
 * rule validation of lexical module
 *
 * @author Rodrigo Cachoeira
 */
@DisplayName("Lexical Analyzer Test Class of Quotation Marks")
class QuotationMarksLexicalTest {

    /**
     * Set default method for recognize some
     * text
     *
     * @return validated
     */
    private boolean recognize() throws InvalidTextException {
        return QuotationMarksLexical.regexValidation(Tape.getCurrentInputValue());
    }

    @Test
    void regexAnalyzerShouldBeRecognizeASimpleQuotationMark() throws InvalidTextException {
        new Tape("'");
        assertTrue(this.recognize());
    }

    @Test
    void regexAnalyzerShouldRecognizeAQuotationMark() throws InvalidTextException {
        new Tape("\"");
        assertTrue(this.recognize());
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnCommaOrDot() throws InvalidTextException {
        new Tape(".");
        assertFalse(this.recognize());

        new Tape(",");
        assertFalse(this.recognize());
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnIntegerValue() throws InvalidTextException {
        new Tape("1");

        assertFalse(this.recognize());
    }

    @Test
    void regexAnalyzerDoNotShouldRecognizeAnText() throws InvalidTextException {
        new Tape("s");

        assertFalse(this.recognize());
    }

}
