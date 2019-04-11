package Config;

/**
 * Define all patterns of language
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public enum LanguagePatterns {

    /**
     * Define end line of language
     */
    ENDLINE(";");

    /**
     * value of enu
     */
    public String value;

    /**
     * Constructor method
     *
     * @param value value of enum
     */
    LanguagePatterns(String value) {
        this.value = value;
    }

    /**
     * Return enum value
     *
     * @return Enum value
     */
    public String getPattern() {
        return this.value;
    }

}
