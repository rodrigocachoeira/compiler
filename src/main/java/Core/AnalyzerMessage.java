package Core;

/**
 * Define response message after
 * analyzer
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class AnalyzerMessage {

    /**
     * Response Message
     */
    private static String message;

    /**
     * Set analyzer response message
     *
     * @param message analyzer message
     */
    public static void setMessage (String message) {
        AnalyzerMessage.message = message;
    }

    /**
     * Return analyzer message
     *
     * @return analyzer message
     */
    public static String getMessage () {
        return AnalyzerMessage.message;
    }

}
