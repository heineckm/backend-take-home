package backend.take.home.parameters;

import backend.take.home.parameters.Language;
import backend.take.home.parameters.QuotelyArgs;
import org.apache.commons.cli.ParseException;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class QuotelyArgsTest {

    @Test
    public void buildUri() {
        // TODO: Test building URIs for different possible languages successfully
        // TODO: Test handling of URISyntaxException (if the FORISMATIC_API_URL is corrupted)
    }

    @Test
    public void parseArgs() {
        QuotelyArgs quoteArgs = new QuotelyArgs();

        String[] args = new String[]{};
        try {
            quoteArgs.parseArgs(args);
            assertEquals(quoteArgs.getLanguage(), Language.ENGLISH);

            args = new String[]{"lang", "english"};
            quoteArgs.parseArgs(args);
            assertEquals(quoteArgs.getLanguage(), Language.ENGLISH);

            args = new String[]{"--lang", "russian"};
            quoteArgs.parseArgs(args);
            assertEquals(quoteArgs.getLanguage(), Language.RUSSIAN);

            args = new String[]{"-l", "russian"};
            quoteArgs.parseArgs(args);
            assertEquals(quoteArgs.getLanguage(), Language.RUSSIAN);

            args = new String[]{"-l", "RuSsIaN"};
            quoteArgs.parseArgs(args);
            assertEquals(quoteArgs.getLanguage(), Language.RUSSIAN);

            args = new String[]{"-l", "EnGlIsH"};
            quoteArgs.parseArgs(args);
            assertEquals(quoteArgs.getLanguage(), Language.ENGLISH);
        } catch (ParseException e) {
            e.printStackTrace();
            fail("Incorrectly received an error attempting to parse arguments:" + Arrays.toString(args));
        }
    }

    @Test
    public void parseArgsExceptions() {
        QuotelyArgs quoteArgs = new QuotelyArgs();

        Exception exception = assertThrows(ParseException.class, () -> {
            String[] args = new String[]{"-foo", "english"};
            quoteArgs.parseArgs(args);
        });

    }

}