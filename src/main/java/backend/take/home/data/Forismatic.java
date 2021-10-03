package backend.take.home.data;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Simple class for deserializing from the forismatic API
 * See http://forismatic.com/en/api/
 */
public class Forismatic {
    public final String quoteText;
    public final String quoteAuthor;
    public final String senderName;
    public final String senderLink;
    public final String quoteLink;

    public Forismatic(@JsonProperty("quoteText") String quoteText,
                      @JsonProperty("quoteAuthor") String quoteAuthor,
                      @JsonProperty("senderName") String senderName,
                      @JsonProperty("senderLink") String senderLink,
                      @JsonProperty("quoteLink") String quoteLink) {
        this.quoteText = quoteText.trim();
        this.quoteAuthor = quoteAuthor.trim();
        this.senderName = senderName.trim();
        this.senderLink = senderLink.trim();
        this.quoteLink = quoteLink.trim();
    }

    public void print() {
        System.out.println("Quote:  " + this.quoteText);
        System.out.println("Author: " + this.quoteAuthor);
    }
}
