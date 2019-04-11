package Config;

import java.util.ArrayList;

/**
 * Define all language words
 *
 * @author Rodrigo Cachoeira
 * @version 1.0.0
 */
public class Language {

    /**
     * Define all reserved words
     */
    public static final ArrayList<String> WORDS = new ArrayList<String>(){
        {
            add("int");
            add("float");
            add("public");
            add("private");
        }
    };

}
