package backend.take.home.parameters;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.http.client.utils.URIBuilder;

import java.net.URI;
import java.net.URISyntaxException;



/**
 * The QuotelyArgs class is responsible for arguments and parameters for the Quotely application that are
 * set or overridden by the user.
 *
 * It's responsible for:
 * - Creating and parsing command line parameters and arguments
 * - Providing default options for parameters
 * - Constructing necessary parameters for other systems that are based on input parameters.
 * For example, we build the URI for the Quotely HttpRequest here, because it is based on input parameters from the user.
 *
 * TODO: Also return help text to the user when passed --help.
 * See https://commons.apache.org/proper/commons-cli/javadocs/api-1.3.1/org/apache/commons/cli/HelpFormatter.html
 */
public class QuotelyArgs {
    public static final String FORISMATIC_API_URL = "http://api.forismatic.com/api/1.0/";

    public static final String METHOD_PARAM = "method";
    public static final String LANG_PARAM = "lang";
    public static final String FORMAT_PARAM = "format";

    public static final String DEFAULT_METHOD = "getQuote";
    public static final String DEFAULT_FORMAT = "json";
    public static final Language DEFAULT_LANG = Language.ENGLISH;

    private Language language;

    public QuotelyArgs() { }

    private Options buildOptions() {
        Options options = new Options();
        options.addOption("l", LANG_PARAM, true, "Quote language");
        return options;
    }

    /**
     * Parse the command line arguments and set all variables input by the user.

     * @param args Input arguments as a String array
     * @throws ParseException If some input parameters are invalid
     */
    public void parseArgs(String[] args) throws ParseException {
        Options options = buildOptions();

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd = parser.parse( options, args);

        String language_param = cmd.getOptionValue(LANG_PARAM);
        this.language = Language.lookup(language_param);
    }

    public Language getLanguage() {
        if (language == null)
            return DEFAULT_LANG;
        return language;
    }

    /**
     * Build the URI (including parameters) that will be called to access the API,
     * using the parameters input by the user.
     *
     * @return The complete URI object, or null if there is an error attempting to build the object.
     */
    public URI buildUri() {
        try {
            return new URIBuilder(FORISMATIC_API_URL)
                    .addParameter(METHOD_PARAM, DEFAULT_METHOD)
                    .addParameter(LANG_PARAM, this.getLanguage().getParamString())
                    .addParameter(FORMAT_PARAM, DEFAULT_FORMAT)
                    .build();
        } catch (URISyntaxException e) {
            System.out.println("The Forismatic API must have changed or is unavailable!");
            e.printStackTrace();
        }
        return null;
    }
}
